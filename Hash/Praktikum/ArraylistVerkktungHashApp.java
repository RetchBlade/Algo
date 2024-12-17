package VerkettungHash;

import javax.swing.JOptionPane;
import java.util.ArrayList; // Import der ArrayList

public class ArraylistVerkktungHashApp {
	    public static void main(String args[]) {
	        final int B = 5; // Anzahl der Körbe in der Hash-Tabelle
	        String menue = "Eingabe\n";
	        menue += " 1) Element einfuegen\n";
	        menue += " 2) Element suchen\n";
	        menue += " 3) Element loeschen\n";
	        menue += " 4) Laenge der Liste von Korb k\n";
	        menue += " 5) Liste von Korb k ansehen\n";
	        menue += " 6) Laenge der Listen von allen Koerben\n";
	        menue += " 7) Liste zufaellig fuellen\n";

	        String ausgabe = "";
	        
	        // Erstellen der Hash-Tabelle als Array von ArrayLists
	        ArrayList<String>[] hashTabelle = new ArrayList[B];
	        for (int i = 0; i < B; i++) {
	            hashTabelle[i] = new ArrayList<>(); // Initialisiere jeden Korb als ArrayList
	        }

	        while (true) {
	            String menueeingabe = JOptionPane.showInputDialog(menue);
	            if (menueeingabe == null) break;

	            String dialogEingabe;
	            switch (menueeingabe) {
	                case "1": // Element einfuegen
	                    dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
	                    int h = hashFunktion(dialogEingabe, B); // Hash-Funktion berechnen
	                    if (hashTabelle[h].contains(dialogEingabe)) {
	                        ausgabe = "Element in Korb " + h + " gefunden, daher nicht eingefügt";
	                    } else {
	                        hashTabelle[h].add(0, dialogEingabe);
	                        ausgabe = "Eingabe eingefügt in Bucket " + h;
	                    }
	                    JOptionPane.showMessageDialog(null, ausgabe);
	                    break;

	                case "2": // Element suchen
	                    dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?");
	                    h = hashFunktion(dialogEingabe, B);
	                    if (hashTabelle[h].contains(dialogEingabe)) {
	                        ausgabe = "Element gefunden in Korb " + h;
	                    } else {
	                        ausgabe = "Element nicht gefunden";
	                    }
	                    JOptionPane.showMessageDialog(null, ausgabe);
	                    break;

	                case "3": // Element löschen
	                    dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gelöscht werden?");
	                    h = hashFunktion(dialogEingabe, B);
	                    if (hashTabelle[h].remove(dialogEingabe)) {
	                        ausgabe = "Element wurde aus Korb " + h + " gelöscht";
	                    } else {
	                        ausgabe = "Element nicht gefunden";
	                    }
	                    JOptionPane.showMessageDialog(null, ausgabe);
	                    break;

	                case "4": // Länge der Liste eines bestimmten Korbs
	                    dialogEingabe = JOptionPane.showInputDialog("Von welchem Korb soll die Länge angezeigt werden?");
	                    int index = Integer.parseInt(dialogEingabe);
	                    ausgabe = "Liste hat Länge " + hashTabelle[index].size();
	                    JOptionPane.showMessageDialog(null, ausgabe);
	                    break;

	                case "5": // Liste eines bestimmten Korbs ansehen
	                    dialogEingabe = JOptionPane.showInputDialog("Welcher Korb soll angezeigt werden?");
	                    index = Integer.parseInt(dialogEingabe);
	                    ausgabe = String.join("\n", hashTabelle[index]);
	                    JOptionPane.showMessageDialog(null, ausgabe.isEmpty() ? "Korb leer" : ausgabe);
	                    break;

	                case "6": // Anzahl der Elemente aller Körbe anzeigen
	                    ausgabe = "";
	                    for (int i = 0; i < B; i++) {
	                        ausgabe += "Korb " + i + ": " + hashTabelle[i].size() + "\n";
	                    }
	                    JOptionPane.showMessageDialog(null, ausgabe);
	                    break;

	                case "7": // Zufällige Elemente einfügen
	                    dialogEingabe = JOptionPane.showInputDialog("Anzahl?");
	                    int anzahl = Integer.parseInt(dialogEingabe);
	                    for (int j = 0; j < anzahl; j++) {
	                        StringBuilder zufallString = new StringBuilder();
	                        int laenge = (int) ((Math.random() * 8) + 3);
	                        for (int k = 0; k < laenge; k++) {
	                            char zufall = (char) ((Math.random() * 26) + 65);
	                            zufallString.append(zufall);
	                        }
	                        int zufallKorb = hashFunktion(zufallString.toString(), B);
	                        hashTabelle[zufallKorb].add(0, zufallString.toString());
	                    }
	                    JOptionPane.showMessageDialog(null, "Zufällige Elemente wurden eingefügt");
	                    break;

	                default:
	                    JOptionPane.showMessageDialog(null, "Ungültige Eingabe");
	            }
	        }
	    }

	    // Die Hash-Funktion als statische Methode
	    public static int hashFunktion(String x, int b) {
	        int hash = 0;
	        for (int i = 0; i < x.length(); i++) {
	            hash += x.charAt(i);
	        }
	        return hash % b;
	    }
	}

