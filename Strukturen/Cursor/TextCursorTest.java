package Stack_Queue;
/**
 	Testen Sie Ihre Implementierung, anhand der unten dargestellten Situation (Cursor in blau), und 
	benutzen Sie ausschließlich die obigen Cursor-Methoden. 
		0. Erzeugen Sie einen Cursor, ohne Text. 
		1. Schreiben Sie mit dem Cursor (mit insgesamt 11 Aufrufen) den Text „Hallo Wält!“. 
		2. Bewegen Sie den Cursor an die im Beispiel dargestellte Stelle.  
		3. Löschen Sie das „ä“       
		4. Fügen Sie ein „e“ ein.  
		5. Platzieren Sie den Cursor dann vor dem „W“ von „Welt“, 
		6. Geben Sie nun den Inhalt der beiden Datenstrukturen aus. 
	Hinweis: Sie können in Ihrer Implementierung auf Exception-Handling, etwa für das Herauslaufen 
	aus der Zeile verzichten. 
 */

public class TextCursorTest {
    public static void main(String[] args) {
        try {
            TextCursor cursor = new TextCursor();
            
            // Schritt 1: Schreibe "Hallo Wält!"
            String text = "Hallo Wält!";
            for (char c : text.toCharArray()) {
                cursor.type(c);
            }

            // Schritt 2: Bewege den Cursor vor das "ä"
            for (int i = 0; i < 2; i++) {
                cursor.moveLeft();
            }

            // Schritt 3: Lösche das "ä"
            cursor.delete();

            // Schritt 4: Füge ein "e" ein
            cursor.type('e');

            // Schritt 5: Bewege den Cursor vor das "W"
            for (int i = 0; i < 4; i++) {
                cursor.moveLeft();
            }

            // Schritt 6: Ausgabe der beiden Datenstrukturen
            System.out.println("Final state of the text:");
            cursor.printContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

