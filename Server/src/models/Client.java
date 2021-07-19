package models;

public class Client {

    private String name;
    private CustomerType type;
    private String turn;

    public Client(String name, CustomerType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public CustomerType getType() {
        return type;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", turn='" + turn + '\'' +
                '}';
    }
}
