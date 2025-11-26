package Stack;

class Knoten<T>{
    private T objekt;
    private Knoten<T> next;
    public Knoten(T objekt, Knoten<T> next) {
        this.objekt = objekt;
        this.next = next;
    }
    public T getObjekt() {
        return objekt;
    }
    public Knoten<T> getNext() {
        return next;
    }
}

interface ADTStack<T>{
    ADTStack<T> push(T item);
    ADTStack<T> pop();
    T top();
    boolean isEmpty();
}

public class Stack<T> implements ADTStack<T>{

    Knoten<T> knoten = null;

    public static void main(String[] args) {

        // Beispiel für Stack
        ADTStack<Integer> stack = new Stack<>();
        System.out.println("push 10, 20 und 30");
        stack.push(10).push(20).push(30);

        System.out.println("Top: " + stack.top());

        System.out.println("Stack leer? " + stack.isEmpty());

        System.out.println("Pop");
        stack.pop();

        System.out.println("Stack leer? " + stack.isEmpty());

        while(!stack.isEmpty()) {
            System.out.println("Top: " + stack.top());
            stack.pop();
        }

        System.out.println("Stack leer? " + stack.isEmpty());

        // ===== DEMO: CURSOR =====
        System.out.println("\n===== CURSOR-DEMO =====");
        Cursor cursor = new Cursor();

        for(char c : "Hallo Welt".toCharArray()) {
            cursor.type(c);
        }

        System.out.println(cursor.getTextWithCursor());

        cursor.moveLeft();
        cursor.moveLeft();
        cursor.moveLeft();
        System.out.println(cursor.getTextWithCursor());

        cursor.delete();
        System.out.println(cursor.getTextWithCursor());
        cursor.type('X');
        System.out.println(cursor.getTextWithCursor());
        cursor.moveRight();
        System.out.println(cursor.getTextWithCursor());
        cursor.moveRight();
        System.out.println(cursor.getTextWithCursor());
    }

    @Override
    public ADTStack<T> push(T item) {
        knoten = new Knoten<T>(item, knoten);
        return this;
    }

    @Override
    public ADTStack<T> pop() {
        if(isEmpty()){
            throw new java.lang.IllegalStateException();
        } else {
            knoten = knoten.getNext();
            return this;
        }
    }

    @Override
    public T top() {
        if(isEmpty()){
            throw new java.lang.IllegalStateException();
        } else {
            return knoten.getObjekt();
        }
    }

    @Override
    public boolean isEmpty() {
        return (knoten == null);
    }
}


// ============================================
//            CURSOR-KLASSE HIER
// ============================================

class Cursor {

    private ADTStack<Character> left;
    private ADTStack<Character> right;

    public Cursor() {
        left = new Stack<>();
        right = new Stack<>();
    }

    // Zeichen links vom Cursor schreiben
    public void type(char c) {
        left.push(c);
    }

    // Zeichen links vom Cursor löschen (Backspace)
    public void delete() {
        if (!left.isEmpty()) {
            left.pop();
        }
    }

    // Cursor nach links bewegen
    public void moveLeft() {
        if (!left.isEmpty()) {
            char c = left.top();
            left.pop();
            right.push(c);
        }
    }

    // Cursor nach rechts bewegen
    public void moveRight() {
        if (!right.isEmpty()) {
            char c = right.top();
            right.pop();
            left.push(c);
        }
    }

    // Ausgabe des kompletten Textes inkl. |
    public String getTextWithCursor() {
        String leftText = stackToString(left);
        String rightText = stackToString(right);
        return leftText + "|" + rightText;
    }

    // Stack-Inhalt in Leserichtung ausgeben (Stack bleibt unverändert)
    private String stackToString(ADTStack<Character> st) {
        ADTStack<Character> temp = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // Stack in temp umkehren
        while (!st.isEmpty()) {
            char c = st.top();
            st.pop();
            temp.push(c);
        }

        // richtige Reihenfolge erzeugen & originalen Stack wiederherstellen
        while (!temp.isEmpty()) {
            char c = temp.top();
            temp.pop();
            sb.append(c);
            st.push(c);
        }

        return sb.toString();
    }
}
