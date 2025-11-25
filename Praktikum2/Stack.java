package Stack;

class Knoten<T>{
	private T objekt;
	private Knoten<T> next;
	
	public Knoten(T objekt, Knoten<T> next) {
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

interface ADTStack<T>{
	ADTStack<T> push(T item);
	ADTStack<T> pop();
	T top();
	boolean isEmpty();
}

public class Stack<T> implements ADTStack<T> {
	
	private Knoten<T> knoten = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ADTStack<Integer> stack = new Stack<>();
		stack.push(10).push(20).push(30);
		System.out.println("Stack leer: " + stack.isEmpty());
		
		System.out.println(stack.top());
		
		System.out.println("pop");
		stack.pop();
		
		while(!stack.isEmpty()){
			 System.out.println(stack.top());
			 System.out.println("pop");
	         stack.pop();
		} 
		
		System.out.println("Stack leer: " + stack.isEmpty());
	}

	@Override
	public ADTStack<T> push(T item) {
		// TODO Auto-generated method stub
		knoten = new Knoten<T>(item, knoten);
;		return this;
	}

	@Override
	public ADTStack<T> pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new java.lang.IllegalStateException();
		} else {
			knoten = knoten.getNext();
			return this;
		}
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new java.lang.IllegalStateException();
		} else {
			return knoten.getObjekt();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (knoten == null);
	}

}
