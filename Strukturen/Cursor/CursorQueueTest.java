package Stack_Queue;

public class CursorQueueTest {
    public static void main(String[] args) throws Exception {
        CursorQueue cursor = new CursorQueue();

        // 1. Text schreiben: "Hallo Wält!"
        String text = "Hallo Wält!";
        for (char c : text.toCharArray()) {
            cursor.type(c);
        }
        System.out.println("After typing:");
        cursor.display();

        // 2. Cursor bewegen (an die gewünschte Position)
        for (int i = 0; i < 2; i++) { // Cursor nach links bewegen
            cursor.moveLeft();
        }
        System.out.println("Cursor moved left twice:");
        cursor.display();

        // 3. Lösche das "ä"
        cursor.delete();
        System.out.println("After deleting 'ä':");
        cursor.display();

        // 4. Füge ein "e" ein
        cursor.type('e');
        System.out.println("After typing 'e':");
        cursor.display();

        // 5. Cursor vor das "W" bewegen
        while (!cursor.right.isEmpty() && (char) cursor.right.front() != 'W') {
            cursor.moveRight();
        }
        System.out.println("Cursor placed before 'W':");
        cursor.display();

        // 6. Ausgabe der Datenstrukturen
        System.out.println("Final state of data structures:");
        cursor.display();
    }
}
