package Praktikum3;

import java.util.NoSuchElementException;

interface ADTQueue<T> {
    ADTQueue<T> enqueue(T item);
    ADTQueue<T> dequeue();
    T front();
    boolean isEmpty();
}
public class BoundedQueue<T> implements ADTQueue<T> {

    private Object[] array;
    private int size = 0;
    private int outIndex = 0;  
    private int inIndex = 0;

    public BoundedQueue(int capacity) {
        array = new Object[capacity];
    }

    public BoundedQueue enqueue(T item) {
        if (size == array.length) {
            throw new IllegalStateException("Cannot add to full queue");
        }

        array[inIndex] = item;
        inIndex = (inIndex + 1) % array.length;  // Modulo für zirkulären Array-Überlauf
        size++;
        return this;
    }

    public BoundedQueue dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }

        Object item = array[outIndex];
        array[outIndex] = null;
        outIndex = (outIndex + 1) % array.length;
        size--;
        return this;
    }

    public T front() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot return front from empty queue");
        }

        return (T) array[outIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

