package models;

import structures.ComparatorQueue;
import structures.PriorityQueue;

import java.util.ArrayList;
import java.util.Iterator;

public class ManagerEntity {

    private PriorityQueue<Client> listClients;
    private int[] counts;
    private String delete;

    public ManagerEntity() {
        delete = "";
        counts = new int[3];
        listClients = new PriorityQueue(3,new ComparatorQueue());
    }

    public Client getClient(){
        return listClients.peek();
    }

    public  void show(){
        listClients.show(3);
    }

    public void generateTurn(Client client,int priority){
        String[] code = {"A","E","N"};
        counts[priority]++;
        client.setTurn(code[priority]+ counts[priority]);
    }

    public void addClient(Client client){
        int priority = client.getType().ordinal();
        generateTurn(client,priority);
        listClients.push(client,priority);
    }

    public Client createClient(String name,CustomerType type){
        return new Client(name,type);
    }

    public synchronized Client delete(){
        return listClients.poll();
    }

    public void lastDelete(String delete){
        this.delete = delete;
    }

    public String getLastDelete(){
        if (!listClients.isEmpty()){
            return this.delete;
        }else{
            return ConstantServer.ERROR;
        }
    }

    public synchronized ArrayList<Object[]> getClients(){
        Iterator<Client> iterator = listClients.iterator();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        int count = 0;
        boolean stop = true;
        while (iterator.hasNext() && stop){
            Client client = iterator.next();
            arrayList.add(new Object[]{
                    client.getName(),client.getTurn()
            });
            if (count == 7){
                stop = false;
            }
            count++;
        }
        return arrayList;
    }

    public Iterator<Client> iteratorClients(){
        return listClients.iterator();
    }
}
