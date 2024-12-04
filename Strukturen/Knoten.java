package Stack_Queue;
/**
	Aufgabenteil a: Programmieren Sie eine Hilfsklasse Knoten.  
		• In den Instanzen dieser Klasse soll neben einem (zur Verkettung erforderlichen) 
		Zeiger auf einen weiteren Knoten jeweils das im Knoten vorgehaltene Datenele
		ment gespeichert werden.  
		
		• In Ihrer Implementierung kann das Datenelement als vom Typ Object deklariert 
		werden, oder durch einen Template-Parameter der Klasse Knoten spezifiziert wer
		den. 
 */

public class Knoten {
    public int data; // Gespeichertes Element
    public Knoten next; // Zeiger auf den nächsten Knoten

    public Knoten(int data) {
        this.data = data;
        this.next = null;
    }
}
