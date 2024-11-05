package Sort;

public class RecursiveBubbleSort {
    // Methode, um das Array rekursiv zu sortieren
    public static void bubbleSort(int[] array, int n) {
        // Basisfall: Wenn die Länge des Arrays 1 ist, ist das Array bereits sortiert
        if (n == 1) {
            return;
        }
        
        // Ein Durchlauf durch das Array, um das größte Element nach rechts zu schieben
        for (int j = 0; j < n - 1; j++) {
            // Vergleich benachbarter Elemente und Tausch, falls nötig
            if (array[j] > array[j + 1]) { // Ändere das Zeichen auf '<', um absteigend zu sortieren
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        
        // Rekursiver Aufruf für das Array ohne das letzte Element
        bubbleSort(array, n - 1);
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Unsortiertes Array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        
        // Aufruf der rekursiven bubbleSort-Methode
        bubbleSort(array, array.length);
        
        System.out.println("\nSortiertes Array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
