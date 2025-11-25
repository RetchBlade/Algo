package Queue;

class Knoten<T>{
	private T objekt;
	private Knoten<T> next;
	public Knoten(T objekt, Knoten<T> next) {
		super();
		this.objekt = objekt;
		this.next = next;
	}
	
	public Knoten<T> getNext() {
		return next;
	}
	
	public void setNext(Knoten<T> next) {
		this.next = next;
	}
	
	public T getObjekt() {
		return objekt;
	}
}

interface ADTQueue<T>{

  ADTQueue<T> enqueue(T item);
  ADTQueue<T> dequeue();
  T front();
  boolean isEmpty();
}

public class Queue<T> implements ADTQueue<T> {
	
	Knoten<T> head = null;
	Knoten<T> tail = null;
	
	public static void main(String[] args) {
		 ADTQueue<String> queue = new Queue<>();
		 
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
	}

	@Override
	public ADTQueue<T> enqueue(T item) {
		// TODO Auto-generated method stub
		Knoten<T> oldtail = tail;
		tail = new Knoten<T>(item, null);
		if(head != null) {
			oldtail.setNext(tail);
		} else {
			head = tail;
		}
		
		return this;
	}

	@Override
	public ADTQueue<T> dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new java.lang.IllegalStateException();
		} else {
			head = head.getNext();
			return this;	
		}
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new java.lang.IllegalStateException();
		} else {
		 return head.getObjekt();	
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head == null);
	}
}
