package Stack_Queue;
/**
 	Z2: Zusatzaufgabe (1/3 Punkt):  
	Bestimmen Sie ob für die folgende Aufgabe eine Stack oder eine Queue zieführender ist. Be
	nutzen Sie dann eine selbstgewählte (gerne auch: selbst gefundene) Stack- oder Queue-Imple
	mentierung, um einen Cursor in einer Textverarbeitung zu realisieren. Für die Zeile, in der der 
	Cursor sich befindet, soll eine Datenstruktur-Instanz die Zeichen links des Cursors, und eine 
	Datenstruktur-Instanz die Zeichen rechts vom Cursor enthalten. Der Cursor soll folgenden Ope
	rationen effizient leisten können, und dabei die beiden Datenstruktur-Instanzen updaten. 
		• moveLeft() : Bewege den Cursor ein Zeiche nach links 
		• moveRight() : Bewege den Cursor ein Zeiche nach links 
		• delete(): Lösche das Zeichen links vom Cursor 
		• type(String c)oder type(char c): schreibt das übergebenene Zeichen (d.h. ei
 */
public class TextCursor {
    private Stack leftStack;  // Zeichen links vom Cursor
    private Stack rightStack; // Zeichen rechts vom Cursor

    public TextCursor() {
        leftStack = new Stack();
        rightStack = new Stack();
    }

    public void type(char c) {
        leftStack.push(c);
    }

    public void moveLeft() throws Exception {
        if (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
    }

    public void moveRight() throws Exception {
        if (!rightStack.isEmpty()) {
            leftStack.push(rightStack.pop());
        }
    }

    public void delete() throws Exception {
        if (!leftStack.isEmpty()) {
            leftStack.pop();
        }
    }

    public void printContent() throws Exception {
        System.out.print("Left stack: ");
        printStack(leftStack);
        System.out.print("Right stack: ");
        printStack(rightStack);
    }

    private void printStack(Stack stack) throws Exception {
        Stack temp = new Stack();
        while (!stack.isEmpty()) {
            int element = stack.pop();
            temp.push(element);
            System.out.print((char) element + " ");
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println();
    }
}

