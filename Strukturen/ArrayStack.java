package Stack_Queue;
/**
 	Z1: Zusatzaufgabe (1/3 Punkt): Implementieren Sie die zweite Struktur (Stack oder 
		Queue), die Sie noch nicht für die Hauptaufgabe implementiert haben. Bei dieser Imple
		mentierung dürfen Sie zwischen einer Knoten-basierten und eine Array-basierte Imple
		mentierung wählen.
 */

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack() {
        capacity = 10; // Startkapazität
        stack = new int[capacity];
        top = -1;
    }

    public void push(int data) {
        if (top == capacity - 1) { // Stack ist voll
            resize();
        }
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return stack[top--];
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        capacity *= 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
