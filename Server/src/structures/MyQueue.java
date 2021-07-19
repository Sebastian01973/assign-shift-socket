package structures;

import java.util.Comparator;
import java.util.Iterator;

public class MyQueue<T> implements Iterable<T>{

    private NodeQueue<T> head;
    private Comparator<T> comparator;

    public MyQueue(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(T data){
        if (isEmpty()){
            head = new NodeQueue<>(data);
        }else{
            NodeQueue<T> aux = head;
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            NodeQueue<T> next = new NodeQueue<>(data);
            aux.setNext(next);
        }
    }

    public T peek(){
        return (isEmpty()) ? null:head.getData();
    }

    public T poll(){
        if (isEmpty()){
            return null;
        }else{
            T next = head.getData();
            NodeQueue<T> aux = head.getNext();
            head = null;
            head = aux;
            return next;
        }
    }

    public boolean exist(T data){
        NodeQueue<T> aux = head;
        while (aux != null){
            if(comparator.compare(aux.getData(),data) == 0){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public String show() {
        String string = "";
        if (isEmpty()) {
            string = "Empty List";
        }else {
            NodeQueue<T> aux = head;
            while(aux!=null) {
                string+=aux.getData().toString()+"-->";
                aux = aux.getNext();
            }
        }
        return string;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator<>(head);
    }
}
