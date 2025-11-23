package Praktikum2;

public class Knoten<T> {

    private T object;        // Das zu verwaltende Datenelement
    private Knoten<T> next;  // Referenz auf den nächsten Knoten

    public Knoten(T object, Knoten<T> next) {
        this.object = object;
        this.next = next;
    }

    /** Setzt die Referenz auf den Nachfolger-Knoten */
    public void setNext(Knoten<T> next) {
        this.next = next;
    }

    /** Gibt das Datenelement des Knotens zurück */
    public T getElement() {
        return object;
    }

    /** Gibt den Nachfolge-Knoten zurück */
    public Knoten<T> getNext() {
        return next;
    }
}

