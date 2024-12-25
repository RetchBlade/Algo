package Suchbaeume;

class Treenode {
    Treenode firstChild;
    Treenode secondChild;
    int wert;

    public Treenode(int wert) {
        this.wert = wert;
    }
}

public class Partielle_Suchbaum {

    private Treenode wurzel;

    public Partielle_Suchbaum() {
        this.wurzel = null;
    }

    // a. Suche nach einem Element
    public boolean search(int k) {
        return searchRekursiv(wurzel, k);
    }

    private boolean searchRekursiv(Treenode knoten, int k) {
        if (knoten == null) {
            return false;
        }
        if (k == knoten.wert) {
            return true;
        }
        return k < knoten.wert
                ? searchRekursiv(knoten.firstChild, k)
                : searchRekursiv(knoten.secondChild, k);
    }

    // b. Einfügen eines Elements
    public boolean insert(int k) {
        if (wurzel == null) {
            wurzel = new Treenode(k);
            return true;
        }
        return insertRekursiv(wurzel, k);
    }

    private boolean insertRekursiv(Treenode knoten, int k) {
        if (k == knoten.wert) {
            return false; // Element bereits vorhanden
        }
        if (k < knoten.wert) {
            if (knoten.firstChild == null) {
                knoten.firstChild = new Treenode(k);
                return true;
            } else {
                return insertRekursiv(knoten.firstChild, k);
            }
        } else {
            if (knoten.secondChild == null) {
                knoten.secondChild = new Treenode(k);
                return true;
            } else {
                return insertRekursiv(knoten.secondChild, k);
            }
        }
    }

    // c. Ausgabe des Bauminhalts (In-Order)
    public void printout() {
        inorderAusgabe(wurzel);
        System.out.println();
    }

    private void inorderAusgabe(Treenode knoten) {
        if (knoten != null) {
            inorderAusgabe(knoten.firstChild);
            System.out.print(knoten.wert + " ");
            inorderAusgabe(knoten.secondChild);
        }
    }

    // d. Löschen eines Elements
    public boolean delete(int k) {
        if (!search(k)) {
            return false; // Element nicht vorhanden
        }
        wurzel = deleteRekursiv(wurzel, k);
        return true;
    }

    private Treenode deleteRekursiv(Treenode knoten, int k) {
        if (knoten == null) {
            return null;
        }

        if (k < knoten.wert) {
            knoten.firstChild = deleteRekursiv(knoten.firstChild, k);
        } else if (k > knoten.wert) {
            knoten.secondChild = deleteRekursiv(knoten.secondChild, k);
        } else {
            if (knoten.firstChild == null) {
                return knoten.secondChild;
            } else if (knoten.secondChild == null) {
                return knoten.firstChild;
            }
            knoten.wert = findeMin(knoten.secondChild);
            knoten.secondChild = deleteRekursiv(knoten.secondChild, knoten.wert);
        }
        return knoten;
    }

    private int findeMin(Treenode knoten) {
        while (knoten.firstChild != null) {
            knoten = knoten.firstChild;
        }
        return knoten.wert;
    }

    // e. Höhe eines Baumes berechnen
    public static int depth(Treenode p) {
        if (p == null) {
            return 0;
        }
        int leftDepth = depth(p.firstChild);
        int rightDepth = depth(p.secondChild);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // f. Prüfen, ob der Baum balanciert ist
    public static boolean isBalanced(Treenode p) {
        if (p == null) {
            return true;
        }
        int leftDepth = depth(p.firstChild);
        int rightDepth = depth(p.secondChild);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(p.firstChild) && isBalanced(p.secondChild);
    }

    // Testen des Programms
    public static void main(String[] args) {
        Partielle_Suchbaum baum = new Partielle_Suchbaum();

        int[] zahlen = {3, 7, 6, 10, 12, 9};
        for (int zahl : zahlen) {
            baum.insert(zahl);
        }

        System.out.println("In-Order Ausgabe vor dem Löschen:");
        baum.printout();

        System.out.println("Lösche Element 10: " + baum.delete(10));

        System.out.println("In-Order Ausgabe nach dem Löschen:");
        baum.printout();

        System.out.println("Höhe des Baumes: " + depth(baum.wurzel));
        System.out.println("Ist der Baum balanciert? " + isBalanced(baum.wurzel));
    }
}
