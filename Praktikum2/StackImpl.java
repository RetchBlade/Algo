package Praktikum2;

public class StackImpl<T> implements ADTStack<T> {

    private Knoten<T> topKnoten = null;

    /** Adds the given item to the top of the stack and returns the modified Stack. */
    public StackImpl<T> push(T element) {
        topKnoten = new Knoten<T>(element, topKnoten);
        return this;
    }

    /** Returns the top item from the stack without popping it.
     *  @exception java.lang.IllegalStateException if the stack is empty.
     */
    public T top() {
        if (isEmpty()) {
            throw new java.lang.IllegalStateException();
        } else {
            return topKnoten.getElement();
        }
    }

    /** Removes the top item from the stack and returns the modified Stack.
     *  @exception java.lang.IllegalStateException if the stack is empty.
     */
    public StackImpl<T> pop() {
        if (isEmpty()) {
            throw new java.lang.IllegalStateException();
        } else {
            topKnoten = topKnoten.getNext();
            return this;
        }
    }

    /** Returns whether the stack is empty or not. */
    public boolean isEmpty() {
        return (topKnoten == null);
    }
}

