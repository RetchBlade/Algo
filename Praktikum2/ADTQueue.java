package Praktikum2;

public interface ADTQueue<T> {

    /** Adds the given item to the rear of the queue and returns the modified queue. */
    ADTQueue<T> enqueue(T item);

    /** Removes the front item from the queue and returns the modified queue.
     *  @exception java.util.NoSuchElementException if the queue is empty.
     */
    ADTQueue<T> dequeue();

    /** Returns the front item from the queue without popping it.
     *  @exception java.util.NoSuchElementException if the queue is empty.
     */
    T front();

    /** Returns whether the queue is empty or not. */
    boolean isEmpty();
}
