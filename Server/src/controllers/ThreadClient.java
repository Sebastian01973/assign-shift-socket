package controllers;

import models.Client;
import models.ConstantServer;
import models.CustomerType;
import models.ManagerEntity;
import nets.Connection;
import org.json.simple.DeserializationException;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import persistence.FileManagerJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadClient extends Thread {

    private final Connection connection;
    private final ManagerEntity managerEntity;
    private final FileManagerJson fileManagerJson;
    private final IObserved iObserved;

    public ThreadClient(Socket socket, ManagerEntity managerEntity,IObserved iObserved) {
        fileManagerJson = new FileManagerJson();
        connection = new Connection(socket);
        this.managerEntity = managerEntity;
        this.iObserved = iObserved;
    }

    @Override
    public void run() {
        execute();
    }

    public void execute(){
        while (connection.readBoolean()){
            switch (connection.readInt()){
                case 1: this.addClient(); break; //Add Client
                case 2: this.deleteClient(); break; //delete Client
                default: break;
            }
        }
        connection.closeSocket();
        Logger.getGlobal().warning("Se cerro la transmicion");
    }

    private String readClients(){
        fileManagerJson.writeClientToFile(managerEntity.getClients());
        JsonObject root = null;
        try {
            root = (JsonObject) Jsoner.deserialize(new FileReader(FileManagerJson.PATH_FILE_OUT));
        } catch (DeserializationException | IOException e) {
            e.printStackTrace();
        }
        return root.toJson();
    }

    private void deleteClient() {
        Client client = managerEntity.delete();
        if (client != null){
            Logger.getGlobal().info("Delete: "+client.getName());
            managerEntity.lastDelete(sendInformation(client.getTurn(),client.getName()));
            iObserved.deleteClient(ConstantServer.DELETE);
            iObserved.updateClients(ConstantServer.UPDATE);
        }
    }

    public String getLastDelete(){
        return managerEntity.getLastDelete();
    }

    private void addClient() {
        Client client = managerEntity.createClient(connection.readString(),
                getCustomerType(connection.readInt()));
        managerEntity.addClient(client);
        connection.writeString(ConstantServer.ADD);
        String auxClient = sendInformation(client.getTurn(),client.getName());
        connection.writeString(auxClient);
        iObserved.updateClients(ConstantServer.UPDATE);
    }

    public CustomerType getCustomerType(int value){
        switch (value){
            case 1: return CustomerType.OLD_MAN;
            case 2: return CustomerType.PREGNANT_WOMAN;
            case 3: return CustomerType.NORMAL_CUSTOMER;
            default: return null;
        }
    }

    public String sendInformation(String turn,String name){
        return turn+"-"+name;
    }

    public void sendDelete(String delete){
        connection.writeString(delete);
        connection.writeString(getLastDelete());
        System.out.println("ok: "+ getLastDelete());
    }

    public void sendNotify(String clients) {
        connection.writeString(clients);
        connection.writeString(readClients());
    }
}
