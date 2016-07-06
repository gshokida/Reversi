package juego.modelo.utils;

import java.util.LinkedList;

/**
 * Created by german.shokida on 6/7/2016.
 */
public class Cola<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return list.poll();
    }

    public boolean hasItems() {
        return !list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
