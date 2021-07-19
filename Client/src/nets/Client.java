package nets;


import controllers.ConstantClient;
import controllers.IObserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final int PORT = 1234;
    private static final String HOST = "localHost";
    private IObserver iObserver;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private boolean status;

    public Client(IObserver iObserver){
        status = true;
        try {
            socket = new Socket(HOST,PORT);
            this.iObserver = iObserver;
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        new Thread(() ->{
            while (status){
                if (available() > 0){
                    String arrive = readString();
                    System.out.println(arrive);
                    switch (arrive){
                        case ConstantClient.UPDATE:
                            String update = readString();
                            System.out.println("Json: "+update);
                            iObserver.updateClient(update);
                            break;
                        case ConstantClient.DELETE:
                            String delete = readString();
                            System.out.println(delete);
                            iObserver.deleteClient(delete);
                            break;
                        case ConstantClient.ADD:
                            String all = readString();
                            System.out.println("Add:"+all);
                            iObserver.addClient(all);
                            break;
                        default: break;
                    }
                }
            }
        }).start();
    }

    public void setStatus(boolean s) {
        this.status = s;
    }

    public int available(){
        int aux = 0;
        try {
            aux = input.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aux;
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

    public boolean readBoolean(){
        boolean auxBoolean = true;
        try {
            auxBoolean = input.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return auxBoolean;
    }

    public void writeBoolean(boolean b){
        try {
            output.writeBoolean(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeString(String string){
        try {
            output.writeUTF(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
