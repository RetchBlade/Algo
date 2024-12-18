package test;

import javax.swing.JOptionPane;

class Zelle { 
	String inhalt; // Beachten Sie: inhalt ist sowohl der Schluesselwert, als auch der komplette zugehörige Dateneintrag 
	Zelle next; 
	//Konstruktor: 
	Zelle (String el) { 
		inhalt = el; next = null; 
	} 
	Zelle (String el, Zelle z) { 
		inhalt = el; next = z; 
	} 
}

class Liste { 
    Zelle anfang; 
    Zelle cursor; 
 
    int laenge () { 
        Zelle cur = anfang; 
        int l = 0; 
        while (cur != null) { 
            l++; 
            cur = cur.next; 
        } 
 
        return l; 
    } 
 
    int hashFunktion (String x,int b) { 
        int hash = 0;
        for(int i = 0; i < x.length(); i++) {
        	hash += x.charAt(i);
        }
        return hash % b;
    	//return b-1; 
    } 
 
    boolean istGueltigePosition (int p) { 
        return (p >= 1) && (p <= laenge () ); 
    } 
 
    void setzeCursor (int p){ 
        cursor = null; 
        if (istGueltigePosition (p) ) { 
            Zelle cur = anfang; 
            for (int i = 1; i < p;i++) 
                cur = cur.next; 
            cursor = cur; 
        } 
    } 
 
 
    void einsetzenAnfang (String e){ 
        Zelle z = new Zelle (e,anfang); 
        anfang = z; 
    } 
 
 
    void loesche (int p) { 
        if (istGueltigePosition(p)){ 
            if (p == 1) // Loesche 1. Zelle 
                anfang = anfang.next; 
            else { 
                setzeCursor(p-1); 
                cursor.next = cursor.next.next; 
            } 
        } 
    } 
 
 
    void loescheElem (String e) { 
 
        for (int i = 1; i <= laenge(); i++) { 
 
            if(inhalt(i).equals(e)) 
                loesche(i); 
        } 
 
        //Loesche(Suche (e)); 
    } 
 
    String inhalt (int p){ 
        setzeCursor (p); 
        return cursor.inhalt; 
    } 
 
 
} 

public class SelbstTest3 {
	  public static void main (String args []) { 
	        final int B = 5; 
	        String  menue = "Eingabe\n" ; 
	        menue += " 1) Element einfuegen\n"; 
	        menue += " 2) Element suchen\n"; 
	        menue += " 3) Zelle loeschen\n"; 
	        menue += " 4) Laenge der Liste von Korb k\n"; 
	        menue += " 5) Liste von Korb k ansehen\n"; 
	        menue += " 6) Laenge der Listen von allen Koerben\n"; 
	        menue += " 7) Liste zufaellig fuellen\n"; 
	        String ausgabe=""; 
	        Liste hashTabelle[]; 
	        hashTabelle = new Liste [B]; 
	        for (int i = 0; i < B;i++) 
	            hashTabelle[i] = new Liste(); 
	        while (true) { 
	            String menueeingabe = JOptionPane.showInputDialog(menue); 
	            if (menueeingabe == null) 
	                break; 
	            String dialogEingabe; 
	            if (menueeingabe.equals("1")) { 
	                dialogEingabe = JOptionPane.showInputDialog("Datenstring?"); 
	                //int zahl = Integer.parseInt (eingabe); 
	                int h = hashTabelle[0].hashFunktion(dialogEingabe, B); //Welcher Korb? 
	                boolean existsInHashtable = false; 
	                for (int j = 1; j <= hashTabelle[h].laenge(); j++) { 
	                    if (hashTabelle[h].inhalt(j).equals(dialogEingabe)) 
	                        ausgabe = "Element in Korb " + h + " gefunden, daher nicht eingefuegt"; 
	                    existsInHashtable = true; 
	                    break; 
	                } 
	                if (!existsInHashtable) { 
	                    hashTabelle[h].einsetzenAnfang(dialogEingabe); 
	                    ausgabe = "Eingabe eingefuegt in bucket " + h; 
	                } 
	                JOptionPane.showMessageDialog(null, ausgabe); 
	            } 
	 
	            if (menueeingabe.equals("2")) { 
	                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?"); 
	                ausgabe = ""; 
	                int h = hashTabelle[0].hashFunktion(dialogEingabe, B); //Welcher Korb? 
	                boolean existsInHashtable = false; 
	                for (int j = 1; j <= hashTabelle[h].laenge(); j++) { 
	                    if (hashTabelle[h].inhalt(j).equals(dialogEingabe)) 
	                        ausgabe = "Element in Korb " + h + " gefunden"; 
	                    existsInHashtable = true; 
	                    break; 
	                } 
	                if (!existsInHashtable) { 
	                    ausgabe = "Eingabe ungueltig"; 
	                } 
	                JOptionPane.showMessageDialog(null, ausgabe); 
	            } 
	 
	            if (menueeingabe.equals("3")) { 
	                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll geloescht werden?"); 
	                ausgabe = "";
	                int h = hashTabelle[0].hashFunktion(dialogEingabe, B); //Welcher Korb? 
	                boolean existsInHashtable = false; 
	                for (int j = 1; j <= hashTabelle[h].laenge(); j++) { 
	                    if (hashTabelle[h].inhalt(j).equals(dialogEingabe)) 
	                        ausgabe = "Element in Korb " + h + " geloescht"; 
	                    existsInHashtable = true; 
	                    hashTabelle[h].loesche(j);
	                    break; 
	                } 
	                if (!existsInHashtable) { 
	                    ausgabe = "Eingabe ungueltig"; 
	                } 
	                JOptionPane.showMessageDialog(null, ausgabe); 
	               
	            } 
	 
	            if (menueeingabe.equals("4")) { 
	                dialogEingabe = JOptionPane.showInputDialog("Von welchem Korb soll die Laenge angezeigt werden?"); 
	                ausgabe = ""; 
	                int k = Integer.parseInt(dialogEingabe); 
	                int l = hashTabelle[k].laenge(); 
	                ausgabe = "Liste hat L�nge " + l; 
	                JOptionPane.showMessageDialog(null, ausgabe); 
	            } 
	 
	            if (menueeingabe.equals("5")) { 
	            	dialogEingabe = JOptionPane.showInputDialog("Welcher Korb soll angezeigt werden?");
					ausgabe = "";
					int k = Integer.parseInt(dialogEingabe);
					if(k<B && k>=0) {
						 for (int j = 1; j <= hashTabelle[k].laenge(); j++) { 
							 ausgabe += hashTabelle[k].inhalt(j) +"\n";
						 }
					} else {
						 ausgabe = "Eingabe ungueltig"; 
					}
	            } 
	 
	            if (menueeingabe.equals("6")) { 
	            	ausgabe="";
	            	for (int j = 1; j < B; j++) { 
						 ausgabe += hashTabelle[j].laenge()+"\n";
					 }
	            	JOptionPane.showMessageDialog(null, ausgabe);
	            } 
	 
	            if (menueeingabe.equals("7")) { 
	                dialogEingabe = JOptionPane.showInputDialog("Anzahl?"); 
	                ausgabe = ""; 
	                int zahl = Integer.parseInt(dialogEingabe); 
	                for (int j = 1; j <= zahl; j++) { 
	                    String s = ""; 
	                    int laenge = (int) ((Math.random() * 8) + 3); 
	 
	                    for (int k = 1; k <= laenge; k++) { 
	                        char zufall = (char) ((Math.random() * 26) + 65); 
	                        s += zufall; 
	                    } 
	                    int h = hashTabelle[0].hashFunktion(s, B); //Welcher Korb? 
	                    hashTabelle[h].einsetzenAnfang(s); 
	                } 
	            } 
	        } 
	    } 
}
