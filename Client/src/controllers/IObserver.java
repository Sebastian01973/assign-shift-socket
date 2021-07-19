package controllers;

public interface IObserver {

    public void addClient(String client);
    public void deleteClient(String client);
    public void updateClient(String client);

}
