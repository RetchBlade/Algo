package Stack_Queue;
/**
	Aufgabenteil c: 
	Programmieren Sie ein Programm DataStructureTest um Ihre Datenstruktur zu testen.  
		• In diesem Programm sollen innerhalbeiner Schleife die folgenden Aktionen in je
			dem Schleifendurchlauf durchgeführt werden:  
			o  2 Elemente (z.B. Integer, Double und Strings) werden der Datenstruktur hin
				zugefügt. 
			
			o  Ein Element wird entfernt. 
			 
		• Führen Sie diesen Test 4-fach aus mit den insgesamt 8 Eingabeelementen: 8,7,6,5,4,3,2,1.  
		
		• Beachten Sie: Alle Eingabeelementen sollten genau einmal eingefügt werden. Der 
			Test soll auch für alternative Eingabearrays zumindest für solche bestehend aus 
			eine geraden Anzahl von Zahlen) funktionieren. 
		
		• Geben Sie vor jedem einzelnen Hinzufügen und Entfernen von Elementen diese 
			auf den Bildschirm aus, und geben sie weiterhin aus welches das derzeit zugreif
			bare Element der Datenstruktur ist, siehe auch folgende Beispielausgabe. Beach
			ten Sie: Die Bildschirmausgabe, (d.h. z.B. System.out.println()-Aufrufe) soll nicht 
			von den Methoden der Datenstruktur erfolgen, sondern aus Ihrem Testprogramm 
			heraus. 
			
		• Added: 8 
		• Added: 7 
		• To be removed: 8 
		• Now accessible: ... 
		• Added ... 
		• Geben Sie nach der obigen Prozedur den Zustand der Datenstruktur aus, indem 
			Sie in einer Schleife alle verbliebenen Elemente jeweils erst auf den Bildschirm 
			ausgeben und dann entfernen. 
			
		Elements in data structure in final state of data: ...  
 */
public class DataStructureTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        int[] elements = {8, 7, 6, 5, 4, 3, 2, 1};

        for (int i = 0; i < elements.length; i += 2) {
            queue.enqueue(elements[i]);
            System.out.println("Added: " + elements[i]);
            queue.enqueue(elements[i + 1]);
            System.out.println("Added: " + elements[i + 1]);

            try {
                System.out.println("To be removed: " + queue.dequeue());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println("Now accessible: " + queue.front());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Elements in final state:");
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

