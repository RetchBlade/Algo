package Stack_Queue;
/**
 Aufgabenteil bSt (zu bearbeiten, wenn Sie die Datenstruktur Stack implementieren): 
 Programmieren Sie eine Klasse Stack.  
	• Diese Klasse soll zwei Methoden („push“ und „pop“) enthalten, um Elemente zu ei
	nem Stapel zuzufügen, bzw. zu entfernen.  
	
	• Zusätzlich soll die Klasse die Methode „top“ enthalten; diese liefert das oberste, d.h. 
	das zuletzt hinzugefügte, Element des Stacks zurück, ohne aber das Element zu 
	entfernen. 
	
	• Zusätzlich soll die Klasse die Methoden eine Hilfsmethode „isEmpty“ enthalten, wel
	che überprüft, ob sich noch Elemente auf dem Stack befinden. 
 */

public class Stack {
    private Knoten top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Knoten newNode = new Knoten(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() throws Exception {
        if (top == null) {
            throw new Exception("Stack is empty!");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int top() throws Exception {
        if (top == null) {
            throw new Exception("Stack is empty!");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

