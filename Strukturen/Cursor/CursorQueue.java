package Stack_Queue;

public class CursorQueue {
    private Queue left;   // Zeichen links vom Cursor
    Queue right;  // Zeichen rechts vom Cursor

    public CursorQueue() {
        left = new Queue();
        right = new Queue();
    }

    // Bewege den Cursor ein Zeichen nach links
    public void moveLeft() throws Exception {
        if (!left.isEmpty()) {
            int charToMove = left.dequeue();
            right.enqueue(charToMove);
        }
    }

    // Bewege den Cursor ein Zeichen nach rechts
    public void moveRight() throws Exception {
        if (!right.isEmpty()) {
            int charToMove = right.dequeue();
            left.enqueue(charToMove);
        }
    }

    // Lösche das Zeichen links vom Cursor
    public void delete() throws Exception {
        if (!left.isEmpty()) {
            left.dequeue();
        }
    }

    // Füge ein Zeichen links vom Cursor ein
    public void type(char c) {
        left.enqueue((int) c);
    }

    // Ausgabe des aktuellen Zustands
    public void display() throws Exception {
        System.out.print("Left (Queue): ");
        Queue tempLeft = copyQueue(left);
        while (!tempLeft.isEmpty()) {
            System.out.print((char) tempLeft.dequeue());
        }
        System.out.println();

        System.out.print("Right (Queue): ");
        Queue tempRight = copyQueue(right);
        while (!tempRight.isEmpty()) {
            System.out.print((char) tempRight.dequeue());
        }
        System.out.println("\n");
    }

    // Hilfsmethode: Kopiere eine Queue (da keine direkte Methode vorhanden ist)
    private Queue copyQueue(Queue original) throws Exception {
        Queue copy = new Queue();
        Queue temp = new Queue();

        while (!original.isEmpty()) {
            int data = original.dequeue();
            copy.enqueue(data);
            temp.enqueue(data);
        }

        // Original-Queue wiederherstellen
        while (!temp.isEmpty()) {
            original.enqueue(temp.dequeue());
        }

        return copy;
    }
}
