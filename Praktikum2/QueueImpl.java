package Praktikum2;

import java.util.NoSuchElementException;

public class QueueImpl<T> implements ADTQueue<T> {

    private Knoten<T> tail = null;
    private Knoten<T> head = null;

    /** Adds the given item to the rear of the queue and returns the modified queue. */
    public QueueImpl<T> enqueue(T element) {
        Knoten<T> oldtail = tail;
        tail = new Knoten<T>(element, null);
        if (head != null) {
            oldtail.setNext(tail);
        } else {
            head = tail;
        }
        return this;
    }

    /** Removes the front item from the queue and returns the modified queue.
     *  @throws java.util.NoSuchElementException if the queue is empty.
     */
    public ADTQueue<T> dequeue() {
        if (!isEmpty()) {
            head = head.getNext();
        } else {
            throw new NoSuchElementException();
        }
        return this;
    }

    /** Returns the front item from the queue without popping it.
     *  @throws java.util.NoSuchElementException if the queue is empty.
     */
    public T front() {
        if (!isEmpty()) {
            return head.getElement();
        } else {
            throw new NoSuchElementException();
        }
    }

    /** Returns whether the queue is empty or not. */
    public boolean isEmpty() {
        return head == null;
    }
}
