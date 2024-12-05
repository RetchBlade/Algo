package test;

// Repräsentiert einen Knoten in der Queue oder im Stack
class Knoten {
    public Object data; // Gespeicherte Daten
    public Knoten next; // Verweis auf den nächsten Knoten

    // Konstruktor: Initialisiert die Daten und setzt den nächsten Knoten auf null
    public Knoten(Object obj) {
        this.data = obj;
        this.next = null;
    }
}

// Implementierung einer Queue (Warteschlange) basierend auf Knoten
class Queue {
    private Knoten front, end; // Anfang und Ende der Queue

    // Konstruktor: Initialisiert eine leere Queue
    public Queue() {
        this.front = null;
        this.end = null;
    }

    // Fügt ein Element am Ende der Queue hinzu
    public void enqueue(Object data) {
        Knoten newNode = new Knoten(data);
        if (end != null) {
            end.next = newNode; // Verbinde das bisherige Ende mit dem neuen Knoten
        }
        end = newNode; // Setze das neue Ende
        if (front == null) {
            front = end; // Falls die Queue vorher leer war, setze auch den Anfang
        }
    }

    // Entfernt und gibt das Element am Anfang der Queue zurück
    public Object dequeue() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty!"); // Fehler, wenn die Queue leer ist
        }
        Object data = front.data; // Speichere die Daten des ersten Knotens
        front = front.next; // Setze den Anfang auf den nächsten Knoten
        if (front == null) {
            end = null; // Leere Queue: Setze auch das Ende auf null
        }
        return data;
    }

    // Gibt das Element am Anfang der Queue zurück, ohne es zu entfernen
    public Object front() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty!");
        }
        return front.data;
    }

    // Prüft, ob die Queue leer ist
    public boolean isEmpty() {
        return front == null;
    }
}

// Implementierung eines Stacks (LIFO) basierend auf Knoten
class Stack {
    private Knoten top; // Oberstes Element des Stacks

    // Konstruktor: Initialisiert einen leeren Stack
    public Stack() {
        this.top = null;
    }

    // Fügt ein Element oben auf den Stack hinzu
    public void push(Object data) {
        Knoten newNode = new Knoten(data);
        newNode.next = top; // Verbinde neuen Knoten mit dem bisherigen Top
        top = newNode; // Setze das neue Top
    }

    // Entfernt und gibt das oberste Element des Stacks zurück
    public Object pop() throws Exception {
        if (top == null) {
            throw new Exception("Stack is empty!");
        }
        Object data = top.data; // Speichere die Daten des obersten Knotens
        top = top.next; // Setze das Top auf den nächsten Knoten
        return data;
    }

    // Gibt das oberste Element des Stacks zurück, ohne es zu entfernen
    public Object top() throws Exception {
        if (top == null) {
            throw new Exception("Stack is empty!");
        }
        return top.data;
    }

    // Prüft, ob der Stack leer ist
    public boolean isEmpty() {
        return top == null;
    }
}

// Hauptklasse zur Demonstration der Queue- und Stack-Funktionalität
public class SelbstTest2 {
    public static void main(String[] args) {
        System.out.println("Queue:\n");
        Queue queue = new Queue();
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8};

        // Hinzufügen und Entfernen von Elementen in der Queue
        for (int i = 0; i < elements.length; i += 2) {
            queue.enqueue(elements[i]);
            System.out.println("Added: " + elements[i]);

            queue.enqueue(elements[i + 1]);
            System.out.println("Added: " + elements[i + 1]);

            try {
                System.out.println("To be removed: " + queue.dequeue());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Now accessible: " + queue.front());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Entferne und drucke die verbleibenden Elemente der Queue
        System.out.println("Elements in final state:");
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
                System.out.println("Queue is empty: " + queue.isEmpty());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nStack: \n");
        Stack stack = new Stack();

        // Hinzufügen und Entfernen von Elementen im Stack
        for (int i = 0; i < elements.length; i += 2) {
            stack.push(elements[i]);
            System.out.println("Added: " + elements[i]);

            stack.push(elements[i + 1]);
            System.out.println("Added: " + elements[i + 1]);

            try {
                System.out.println("To be removed: " + stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Now accessible: " + stack.top());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Entferne und drucke die verbleibenden Elemente des Stacks
        System.out.println("Elements in final state:");
        while (!stack.isEmpty()) {
            try {
                System.out.println(stack.pop());
                System.out.println("Stack is empty: " + stack.isEmpty());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
