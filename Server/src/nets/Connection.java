package nets;

import models.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Connection {

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Connection(Socket socket) {
        try {
           this.socket = socket;
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
           Logger.getGlobal().severe(e.toString());
        }
        Logger.getGlobal().info("Cliente Aceptado");
    }


    public void closeSocket(){
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int readInt(){
        int auxInt = 0;
        try {
            auxInt = input.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxInt;
    }

    public void writeInt(int integer){
        try {
            output.writeInt(integer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double readDouble(){
        double auxDouble = 0;
        try {
            auxDouble = input.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxDouble;
    }

    public void writeDouble(double d){
        try {
            output.writeDouble(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBoolean(boolean b){
        try {
            output.writeBoolean(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean readBoolean(){
        boolean auxBoolean = true;
        try {
            auxBoolean = input.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxBoolean;
    }

    public String readString(){
        String auxString = "";
        try {
            auxString = input.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxString;
    }

    public void writeString(String string){
        try {
            output.writeUTF(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
