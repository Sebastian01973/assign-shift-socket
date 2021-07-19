package controllers;

import models.Client;
import models.CustomerType;
import models.ManagerEntity;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements IObserved{

    private static final int PORT = 1234;
    private ServerSocket serverSocket;
    private ManagerEntity managerEntity;
    private ArrayList<ThreadClient> clientArrayList;

    private boolean active;

    public Server() {
        active = true;
        try {
            serverSocket = new ServerSocket(PORT);
            managerEntity = new ManagerEntity();
            clientArrayList = new ArrayList<>();
            addClients();
            while (active) {
                Socket socket = serverSocket.accept();
                ThreadClient threadClient = new ThreadClient(socket,managerEntity,this);
                threadClient.start();
                clientArrayList.add(threadClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addClients() {
        managerEntity.addClient(new Client("Lola", CustomerType.NORMAL_CUSTOMER));
        managerEntity.addClient(new Client("Erneso", CustomerType.OLD_MAN));
        managerEntity.addClient(new Client("Fausto", CustomerType.OLD_MAN));
        managerEntity.addClient(new Client("Maradona", CustomerType.PREGNANT_WOMAN));
        managerEntity.addClient(new Client("Estefa", CustomerType.PREGNANT_WOMAN));
        managerEntity.addClient(new Client("David", CustomerType.NORMAL_CUSTOMER));
        managerEntity.addClient(new Client("Miguel", CustomerType.OLD_MAN));
        managerEntity.addClient(new Client("MIchi", CustomerType.PREGNANT_WOMAN));
        managerEntity.addClient(new Client("Carlo", CustomerType.NORMAL_CUSTOMER));
        managerEntity.addClient(new Client("Camilo", CustomerType.NORMAL_CUSTOMER));
    }

    @Override
    public void updateClients(String clients) {
        for (ThreadClient threadClient: clientArrayList) {
            threadClient.sendNotify(clients);
        }
    }

    @Override
    public void deleteClient(String clients) {
        for (ThreadClient threadClient: clientArrayList) {
            threadClient.sendDelete(clients);
        }
    }
}
