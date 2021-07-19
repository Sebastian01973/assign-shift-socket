package structures;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T>{

    private MyQueue<T>[] listQueue;
    private Comparator<T> comparator;

    public PriorityQueue(int sizePriority, Comparator<T> comparator) {
        this.comparator = comparator;
        listQueue = new MyQueue[sizePriority];
        for (int i = 0; i < sizePriority; i++) {
            listQueue[i] = new MyQueue<T>(this.comparator);;
        }
    }

    public void push(T data, int priority){
        listQueue[priority].push(data);
    }

    public T poll(){
        int size = listQueue.length;
        for (int i = 0; i < size; i++) {
            if (!listQueue[i].isEmpty()){
                return listQueue[i].poll();
            }
        }
        return null;
    }

    public T peek(){
        int size = listQueue.length;
        for (int i = 0; i < size; i++) {
            if (!listQueue[i].isEmpty()){
                return listQueue[i].peek();
            }
        }
        return null;
    }

    public boolean isEmpty(){
        int size = listQueue.length, count = 0;
        for (int i = 0; i < size; i++) {
            if (listQueue[i].isEmpty()){
                count++;
            }
        }
        return (count == listQueue.length);
    }

    public void show(int size){
        for (int i = 0; i < size; i++) {
            System.out.println(""+listQueue[i].show());
        }
    }

    public boolean exist(T data ){
        int size = listQueue.length;
        for (int i = 0; i < size; i++) {
            if (listQueue[i].exist(data)){
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator(){
        int size = listQueue.length;
        ArrayList<T> ok = new ArrayList<>();
        for (MyQueue<T> ts : listQueue) {
            for (T aux : ts) {
                ok.add(aux);
            }
        }
        return ok.iterator();
    }

}
