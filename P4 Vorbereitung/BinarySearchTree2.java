package P4;

//Implementierung eines Binären Suchbaums mit zusätzlicher Ausgabe der Baumstruktur

class TreeNode2 {
 int key; // Wert des Knotens
 TreeNode2 left, right; // Zeiger auf die linken und rechten Kinder

 public TreeNode2(int key) {
     this.key = key;
     left = right = null; // Initialisiere Kinder mit null
 }
}

public class BinarySearchTree2 {
 TreeNode2 root; // Wurzel des Baums

 public BinarySearchTree2() {
     root = null; // Initialisiere den Baum als leer
 }

 // Methode zum Einfügen eines Schlüssels in den Baum
 public void insert(int key) {
     root = insertRec(root, key); // Rekursive Hilfsmethode
 }

 // Rekursive Logik für das Einfügen eines Schlüssels
 private TreeNode2 insertRec(TreeNode2 root, int key) {
     // Basisfall: Wenn der aktuelle Knoten leer ist, erstelle einen neuen Knoten
     if (root == null) {
         root = new TreeNode2(key);
         return root;
     }
     // Wenn der Schlüssel kleiner ist, füge ihn in den linken Teilbaum ein
     if (key < root.key)
         root.left = insertRec(root.left, key);
     // Wenn der Schlüssel größer ist, füge ihn in den rechten Teilbaum ein
     else if (key > root.key)
         root.right = insertRec(root.right, key);

     return root; // Gib die aktualisierte Baumstruktur zurück
 }

 // Methode zum Suchen eines Schlüssels im Baum
 public boolean search(int key) {
     return searchRec(root, key); // Rekursive Hilfsmethode
 }

 // Rekursive Logik für die Suche eines Schlüssels
 private boolean searchRec(TreeNode2 root, int key) {
     // Basisfall: Baum ist leer oder Schlüssel wurde gefunden
     if (root == null)
         return false;
     if (root.key == key)
         return true;
     // Entscheide anhand des Schlüssels, ob links oder rechts gesucht wird
     return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
 }

 // Methode zum Löschen eines Schlüssels aus dem Baum
 public void delete(int key) {
     root = deleteRec(root, key); // Rekursive Hilfsmethode
 }

 // Rekursive Logik zum Löschen eines Schlüssels
 private TreeNode2 deleteRec(TreeNode2 root, int key) {
     // Basisfall: Knoten nicht gefunden
     if (root == null)
         return root;

     // Suche nach dem zu löschenden Schlüssel
     if (key < root.key)
         root.left = deleteRec(root.left, key);
     else if (key > root.key)
         root.right = deleteRec(root.right, key);
     else { // Schlüssel gefunden
         // Fall 1: Knoten hat nur ein Kind oder keines
         if (root.left == null)
             return root.right;
         else if (root.right == null)
             return root.left;

         // Fall 2: Knoten hat zwei Kinder
         root.key = minValue(root.right); // Finde kleinsten Wert im rechten Teilbaum
         root.right = deleteRec(root.right, root.key); // Lösche diesen Wert
     }
     return root; // Gib die aktualisierte Baumstruktur zurück
 }

 // Hilfsmethode: Findet den kleinsten Wert im Baum
 private int minValue(TreeNode2 root) {
     int min = root.key;
     while (root.left != null) { // Gehe ganz nach links
         min = root.left.key;
         root = root.left;
     }
     return min;
 }

 // In-Order Traversierung (Links-Wurzel-Rechts)
 public void inOrder() {
     inOrderRec(root); // Rekursive Hilfsmethode
 }

 private void inOrderRec(TreeNode2 root) {
     if (root != null) {
         inOrderRec(root.left); // Besuche linken Teilbaum
         System.out.print(root.key + " "); // Drucke Schlüssel
         inOrderRec(root.right); // Besuche rechten Teilbaum
     }
 }

 // Pre-Order Traversierung (Wurzel-Links-Rechts)
 public void preOrder() {
     preOrderRec(root); // Rekursive Hilfsmethode
 }

 private void preOrderRec(TreeNode2 root) {
     if (root != null) {
         System.out.print(root.key + " "); // Drucke Schlüssel
         preOrderRec(root.left); // Besuche linken Teilbaum
         preOrderRec(root.right); // Besuche rechten Teilbaum
     }
 }

 // Post-Order Traversierung (Links-Rechts-Wurzel)
 public void postOrder() {
     postOrderRec(root); // Rekursive Hilfsmethode
 }

 private void postOrderRec(TreeNode2 root) {
     if (root != null) {
         postOrderRec(root.left); // Besuche linken Teilbaum
         postOrderRec(root.right); // Besuche rechten Teilbaum
         System.out.print(root.key + " "); // Drucke Schlüssel
     }
 }

 // Zusätzliche Methode zur Ausgabe der Baumstruktur
 public void printTree() {
     System.out.println(treeToString(root));
 }

 // Rekursive Logik zur Erstellung der Baumstruktur als String
 private String treeToString(TreeNode2 root) {
     if (root == null) {
         return "null"; // Leerer Knoten
     }
     String left = treeToString(root.left); // Verarbeite linken Teilbaum
     String right = treeToString(root.right); // Verarbeite rechten Teilbaum
     return "(" + root.key + " " + left + " " + right + ")"; // Formatiere Knoten
 }

 // Hauptmethode zum Testen
 public static void main(String[] args) {
     BinarySearchTree2 tree = new BinarySearchTree2();

     // Einfügen von Elementen
     tree.insert(5);
     tree.insert(3);
     tree.insert(7);
     tree.insert(2);
     tree.insert(4);
     tree.insert(6);
     tree.insert(8);

     System.out.println("In-Order Traversierung:");
     tree.inOrder(); // Ausgabe in sortierter Reihenfolge

     System.out.println("\n\nPre-Order Traversierung:");
     tree.preOrder(); // Ausgabe in Pre-Order

     System.out.println("\n\nPost-Order Traversierung:");
     tree.postOrder(); // Ausgabe in Post-Order

     System.out.println("\n\nBaumstruktur vor dem Löschen:");
     tree.printTree(); // Ausgabe der Baumstruktur

     System.out.println("\nSuche nach 4: " + tree.search(4)); // Suche nach Schlüssel

     System.out.println("\nLösche 2");
     tree.delete(2); // Lösche Schlüssel 2
     System.out.println("In-Order Traversierung nach dem Löschen:");
     tree.inOrder(); // Ausgabe nach dem Löschen

     System.out.println("\n\nBaumstruktur nach dem Löschen:");
     tree.printTree(); // Ausgabe der aktualisierten Baumstruktur
 }
}


