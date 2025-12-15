package Praktikum3;

import java.util.NoSuchElementException;
interface ADTStack<T> {

    ADTStack<T> push(T item);
    T top();
    ADTStack<T> pop();
    boolean isEmpty();
}

public class BoundedStack<T> implements ADTStack<T> {
	private Object[] array;
	private int topIndex = -1; 
	
	public BoundedStack(int capacity) {
		array = new Object[capacity];
	}

	public BoundedStack<T> push(T item) {
		if (topIndex == array.length-1) {
			throw new IllegalStateException("Cannot add to full stack"); }
		topIndex ++;
		array[topIndex] = item;
		return this;
	}

	public BoundedStack<T> pop() {
		if (topIndex == -1) {
			throw new NoSuchElementException("Cannot remove from empty stack");}
			Object item = array[topIndex];
			array[topIndex] = null;
			topIndex--;
			return this;
	}
	
	public T top() {
		if (topIndex == -1) {
			throw new NoSuchElementException("Cannot return front from empty stack");}
		return (T) array[topIndex];
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topIndex == -1;
	}
}
