package Stack_Queue;
/**
 Aufgabenteil bQu (zu bearbeiten, wenn Sie die Datenstruktur Queue implementieren): 
 Programmieren Sie eine Klasse Queue.  
	• Diese Klasse soll zwei Methoden („enqueue“ und „dequeue“) enthalten, um Ele
	mente zu einem Queue zuzufügen, bzw. zu entfernen.  
	
	• Zusätzlich soll die Klasse die Methode „front“ enthalten; diese liefert das vorderste, 
	d.h. das bereits am längsten in der aktuellen Queue befindliche, Element der Queue 
	zurück, ohne aber das Element zu entfernen 
	
	• Zusätzlich soll die Klasse die Methoden eine Hilfsmethode „isEmpty“ enthalten, wel
	che überprüft, ob sich noch Elemente in der Queue befinden. 
 */

public class Queue {
    private Knoten front, rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Knoten newNode = new Knoten(data);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    public int dequeue() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty!");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public int front() throws Exception {
        if (front == null) {
            throw new Exception("Queue is empty!");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

