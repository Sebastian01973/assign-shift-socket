package controllers;

import nets.Client;
import org.json.simple.DeserializationException;
import persistence.FileManagerJson;
import views.Constant;
import views.JMainWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements IObserver,ActionListener, WindowListener {
    
    private final JMainWindows jMainWindows;
    private final FileManagerJson fileManagerJson;
    private final Client client;

    public Controller(){
        jMainWindows = new JMainWindows(this,this);
        fileManagerJson = new FileManagerJson();
        jMainWindows.labelsFalse();
        client = new Client(this);
    }

    @Override
    public void addClient(String client) {
        String[] ok = client.split("-");
        jMainWindows.setValues();
        jMainWindows.setLastClient(ok[0],ok[1]);
    }

    @Override
    public void deleteClient(String client) {
        System.out.println("el: " + client);
        if (!client.equals(ConstantClient.ERROR)){
            String[] dates = client.split("-");
            jMainWindows.setUser(dates[1],dates[0]);
        }else {
            showMessageDialog(null, Constant.NOT_SHIFT);
            jMainWindows.setUser( Constant.NONE,"-");
        }
    }

    @Override
    public void updateClient(String client) {
        try {
            ArrayList<Object[]> arrayList = fileManagerJson.readClients(client);
            updateClients(arrayList);
        } catch (DeserializationException e) {
            e.printStackTrace();
        }
    }

    public void updateClients(ArrayList<Object[]> arrayList){
        String[] names = new String[6];
        String[] codes = new String[6];
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object[] objects = arrayList.get(i);
            if (objects != null && i < 6){
                codes[i] = String.valueOf(objects[0]);
                names[i] = String.valueOf(objects[1]);
            }
        }
        jMainWindows.setLabels(names,codes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case TURN_CREATE: this.createClient(); break;
            case DELETE_TURN: this.deleteTurn(); break;
            default:
                break;
        }
    }

    private void deleteTurn() {
        client.writeBoolean(true);
        client.writeInt(2); // option create client
    }

    private void createClient() {
        Object[] aux = jMainWindows.createClient();
        if (aux != null){
            client.writeBoolean(true);
            client.writeInt(1); // option create client
            client.writeString(String.valueOf(aux[0]));
            client.writeInt(Integer.parseInt(String.valueOf(aux[1])));
        }else{
            showMessageDialog(null, Constant.FILL_SPACE);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //To do...
    }
    @Override
    public void windowClosing(WindowEvent e) {
        String[] buttons = {Constant.CLOSE_CONNECTION,Constant.CANCEL};
        int option = JOptionPane.showOptionDialog(jMainWindows,Constant.QUESTION_CLOSE,Constant.CLOSE,0,0,null,buttons,jMainWindows);
        if (option == 0){
            client.writeBoolean(false);
            client.setStatus(false);
            client.closeSocket();
            System.exit(option);
        }
    }
    @Override
    public void windowClosed(WindowEvent e) {
        //To do...
    }
    @Override
    public void windowIconified(WindowEvent e) {
        //To do...
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
        //To do...
    }
    @Override
    public void windowActivated(WindowEvent e) {
        //To do...
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
        //To do...
    }
}
