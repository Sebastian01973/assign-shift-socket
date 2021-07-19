package structures;

public class NodeQueue<T> {

    private NodeQueue<T> next;
    private T data;

    public NodeQueue(T data) {
        next = null;
        this.data = data;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }

    public NodeQueue getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
