package OffeneAdressierungHash;

import javax.swing.JOptionPane;
// Closed Hashing
public class OffeneAdressierungHashApp {
	public static void main(String args[]) {
		final int B = 5;
		String menue = "Eingabe\n" ;
		menue += " 1) Element einfuegen\n";
		menue += " 2) Element suchen\n";
		menue += " 3) Zelle loeschen\n";
		menue += " 4) Ausgabe\n";
		String ausgabe="";
		String array[] = new String[B];
		
		while(true) {
			String menueeingabe = JOptionPane.showInputDialog(menue);
			if (menueeingabe == null)
				break;
			String dialogEingabe;
			if (menueeingabe.equals("1")) {
				dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
				boolean w = einfuegenLinearemSondieren(array, dialogEingabe);
				if(w) 
					ausgabe= "Eingefuegt";
				else
					ausgabe = "Nicht eingefuegt";
				
				JOptionPane.showMessageDialog(null, ausgabe);
				
			}
			
			if (menueeingabe.equals("2")) {
				dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
				int w = suchen(array, dialogEingabe);
				if(w>=0) 
					ausgabe= "Gefunden in "+w;
				else
					ausgabe = "Nicht gefunden";
				
				JOptionPane.showMessageDialog(null, ausgabe);
				
			}
			
			if (menueeingabe.equals("3")) {
				dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
				boolean w = loeschen(array, dialogEingabe);
				if(w) 
					ausgabe= "Geloescht";
				else
					ausgabe = "Nicht geloescht";
				
				JOptionPane.showMessageDialog(null, ausgabe);
				
			}
			if (menueeingabe.equals("4")) {
				ausgabe = "";
				for(int i = 0; i<B; i++)
					ausgabe += array[i]+"\n";
				JOptionPane.showMessageDialog(null, ausgabe);
				
			}
		}
		
		
		
	}
	
	public static boolean einfuegenLinearemSondieren(String array[], String i){
		int index = hashFunktion(i, array.length);
		boolean w = false;
		int a = array.length;
		while(a>0) {
			if(array[index] == null) {
				array[index] = i;
				w = true;
				break;
			}
			else {
				if(index > 0) {
					index--;
				}
				else {
					index = array.length-1;
				}
			}
			a--;
		}
		return w;
		
	}
	
	public static boolean einfuegenQuadratischesSondieren(String array[], String i) {
	    int index = hashFunktion(i, array.length);

	    for (int j = 0; j < array.length; j++) { // Maximal so viele Versuche wie die Array-Länge
	        int neuerIndex = (index + j * j) % array.length; // Quadratisches Sondieren
	        if (array[neuerIndex] == null) {
	            array[neuerIndex] = i;
	            return true;
	        }
	    }

	    return false; // Kein Platz gefunden
	}

	public static int suchenQuadratischesSondieren(String array[], String i) {
	    int index = hashFunktion(i, array.length);

	    for (int j = 0; j < array.length; j++) {
	        int neuerIndex = (index + j * j) % array.length;
	        if (array[neuerIndex] != null && array[neuerIndex].equals(i)) {
	            return neuerIndex;
	        }
	    }

	    return -1; // Nicht gefunden
	}

	
	public static boolean loeschen(String array[], String i) {
		boolean w = false;
		int a = suchen(array, i);
		if(a>=0) {
			System.out.println("1");
			array[a] = null;
			w = true;
		}
		return w;
	}
	
	public static int suchen(String array[],String i) {
		int index = hashFunktion(i, array.length);
		int a = array.length-1;
		while(a>=0) {
			if(array[index] != null) {
				System.out.println("not null");
			
				if(array[index].equals(i)) {
					System.out.println("2");
					return index;
				}
				else {
					System.out.println("3");
					if(index > 0) {
						index--;
					}
					else {
						index = array.length-1;
					}
				}
			}
			else {
				if(index > 0) {
					index--;
				}
				else {
					index = array.length-1;
				}
			}
			a--;
		}
		return -1;
		
	}
	
	public static int hashFunktion (String x,int b) {
		int a=0;
		for(int i=0; i<x.length();i++) {
			a += x.charAt(i);
		}
		return a%b;
		//return b-1;
	}

}
