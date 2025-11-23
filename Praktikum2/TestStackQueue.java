package Praktikum2;

public class TestStackQueue {

    public static void main(String[] args) {
        testStack();
        System.out.println("--------------------------------------------------");
        testQueue();
    }

    private static void testStack() {
        System.out.println("=== STACK TEST ===");

        ADTStack<Integer> stack = new StackImpl<>();

        System.out.println("Stack am Anfang leer? " + stack.isEmpty());

        System.out.println("Push 10, 20, 30");
        stack.push(10).push(20).push(30);

        System.out.println("Stack leer? " + stack.isEmpty());
        System.out.println("Top (erwartet 30): " + stack.top());

        System.out.println("Pop");
        stack.pop();
        System.out.println("Top (erwartet 20): " + stack.top());

        System.out.println("Alle Elemente mit pop ausgeben:");
        while (!stack.isEmpty()) {
            System.out.println("Top: " + stack.top());
            stack.pop();
        }
        System.out.println("Stack am Ende leer? " + stack.isEmpty());

        // Fehlerfall testen
        System.out.println("\nFehlerfall: pop() auf leerem Stack");
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Erwartete Exception gefangen: " + e);
        }

        System.out.println("Fehlerfall: top() auf leerem Stack");
        try {
            stack.top();
        } catch (IllegalStateException e) {
            System.out.println("Erwartete Exception gefangen: " + e);
        }
    }

    private static void testQueue() {
        System.out.println("=== QUEUE TEST ===");

        ADTQueue<String> queue = new QueueImpl<>();

        System.out.println("Queue am Anfang leer? " + queue.isEmpty());

        System.out.println("Enqueue: \"A\", \"B\", \"C\"");
        queue.enqueue("A").enqueue("B").enqueue("C");

        System.out.println("Queue leer? " + queue.isEmpty());
        System.out.println("Front (erwartet A): " + queue.front());

        System.out.println("Dequeue");
        queue.dequeue();
        System.out.println("Front (erwartet B): " + queue.front());

        System.out.println("Alle Elemente mit dequeue ausgeben:");
        while (!queue.isEmpty()) {
            System.out.println("Front: " + queue.front());
            queue.dequeue();
        }
        System.out.println("Queue am Ende leer? " + queue.isEmpty());

        // Fehlerfall testen
        System.out.println("\nFehlerfall: dequeue() auf leerer Queue");
        try {
            queue.dequeue();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Erwartete Exception gefangen: " + e);
        }

        System.out.println("Fehlerfall: front() auf leerer Queue");
        try {
            queue.front();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Erwartete Exception gefangen: " + e);
        }
    }
}
