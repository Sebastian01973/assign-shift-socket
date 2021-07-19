package structures;

import java.util.Iterator;

public class QueueIterator<T> implements Iterator<T> {

    private NodeQueue<T> head;

    public QueueIterator(NodeQueue<T> head){
        this.head = head;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public T next() {
        T data = head.getData();
        head = head.getNext();
        return data;
    }
}
