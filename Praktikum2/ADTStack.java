package Praktikum2;

public interface ADTStack<T> {

    /** Adds the given item to the top of the stack and returns the modified Stack. */
    ADTStack<T> push(T item);

    /** Returns the top item from the stack without popping it.
     *  @exception java.lang.IllegalStateException if the stack is empty.
     */
    T top();

    /** Removes the top item from the stack and returns the modified Stack.
     *  @exception java.lang.IllegalStateException if the stack is empty.
     */
    ADTStack<T> pop();

    /** Returns whether the stack is empty or not. */
    boolean isEmpty();
}
