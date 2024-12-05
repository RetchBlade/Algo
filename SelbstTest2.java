package test;

// Klasse, die einen Knoten für die Queue repräsentiert
class Knoten {
    public Object data; // Daten, die im Knoten gespeichert sind
    public Knoten next; // Verweis auf den nächsten Knoten

    // Konstruktor für einen neuen Knoten
    public Knoten(Object obj) {
        this.data = obj; // Initialisiere die Daten
        this.next = null; // Setze den nächsten Knoten auf null (kein Nachfolger)
    }
}

// Implementierung der Queue (Warteschlange) mit Hilfe von Knoten
class Queue {
    private Knoten front, end; // front: Anfang der Queue, end: Ende der Queue

    // Konstruktor für eine leere Queue
    public Queue() {
        this.front = null; // Anfang ist leer
        this.end = null; // Ende ist leer
    }

    // Methode, um ein Element in die Queue einzufügen
    public void enqueue(Object data) {
        Knoten newNode = new Knoten(data); // Erstelle einen neuen Knoten
        if (end != null) { // Wenn die Queue nicht leer ist
            end.next = newNode; // Verknüpfe das bisherige Ende mit dem neuen Knoten
        }
        end = newNode; // Setze das neue Ende
        if (front == null) { // Falls die Queue vorher leer war
            front = end; // Setze auch den Anfang
        }
    }

    // Methode, um ein Element aus der Queue zu entfernen
    public Object dequeue() throws Exception {
        if (front == null) { // Überprüfen, ob die Queue leer ist
            throw new Exception("Queue is empty!"); // Fehler werfen, wenn leer
        }
        Object data = front.data; // Daten des ersten Knotens speichern
        front = front.next; // Den Anfang auf den nächsten Knoten setzen
        if (front == null) { // Wenn die Queue jetzt leer ist
            end = null; // Das Ende ebenfalls auf null setzen
        }
        return data; // Entfernte Daten zurückgeben
    }

    // Methode, um das erste Element der Queue zu betrachten (ohne es zu entfernen)
    public Object front() throws Exception {
        if (front == null) { // Überprüfen, ob die Queue leer ist
            throw new Exception("Queue is empty!"); // Fehler werfen, wenn leer
        }
        return front.data; // Daten des ersten Knotens zurückgeben
    }

    // Methode, um zu prüfen, ob die Queue leer ist
    public boolean isEmpty() {
        return front == null; // Leer, wenn der Anfang null ist
    }
}

// Hauptklasse zur Demonstration der Queue
public class SelbstTest2 {
    public static void main(String[] args) {
        Queue queue = new Queue(); // Erstelle eine neue Queue
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8}; // Zu verarbeitende Elemente

        // Elemente der Queue hinzufügen und teilweise entfernen
        for (int i = 0; i < elements.length; i += 2) {
            queue.enqueue(elements[i]); // Füge das aktuelle Element hinzu
            System.out.println("Added: " + elements[i]);

            queue.enqueue(elements[i + 1]); // Füge das nächste Element hinzu
            System.out.println("Added: " + elements[i + 1]);

            try {
                System.out.println("To be removed: " + queue.dequeue()); // Entferne ein Element
            } catch (Exception e) {
                e.printStackTrace(); // Behandle mögliche Fehler
            }

            try {
                System.out.println("Now accessible: " + queue.front()); // Betrachte das nächste Element
            } catch (Exception e) {
                e.printStackTrace(); // Behandle mögliche Fehler
            }
        }

        // Entferne und drucke die verbleibenden Elemente in der Queue
        System.out.println("Elements in final state:");
        while (!queue.isEmpty()) { // Solange die Queue nicht leer ist
            try {
                System.out.println(queue.dequeue()); // Entferne und drucke das nächste Element
                System.out.println("Die Queue ist leer: " +queue.isEmpty());
            } catch (Exception e) {
                e.printStackTrace(); // Behandle mögliche Fehler
            }
        }
    }
}
