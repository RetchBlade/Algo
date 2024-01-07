public class MergeSort {
    public static void main(String[] args) {
        // Beispielarray erstellen
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Unsortiertes Array:");
        printArray(array);

        // MergeSort aufrufen
        mergeSort(array, 0, array.length - 1);

        System.out.println("Sortiertes Array:");
        printArray(array);
    }

    // MergeSort-Funktion
    static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            // Berechne den Mittelpunkt des Arrays
            int m = (l + r) / 2;

            // Sortiere die beiden Hälften rekursiv
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            // Führe die sortierten Hälften zusammen
            merge(array, l, m, r);
        }
    }

    // Merge-Funktion zum Zusammenführen der sortierten Hälften
    static void merge(int[] array, int l, int m, int r) {
        // Größe der beiden zu mergenden Teilarrays berechnen
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporäre Arrays erstellen
        int[] linksArray = new int[n1];
        int[] rechtsArray = new int[n2];

        // Daten in die temporären Arrays kopieren
        for (int i = 0; i < n1; ++i)
            linksArray[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            rechtsArray[j] = array[m + 1 + j];

        // Die beiden Teilarrays zusammenführen

        // Initialisierung der Indizes für die beiden Teilarrays
        int i = 0, j = 0;

        // Initialisierung des Index für das zusammengeführte Array
        int k = l;

        // Vergleiche die Elemente der beiden Teilarrays und füge sie in das zusammengeführte Array ein
        while (i < n1 && j < n2) {
            if (linksArray[i] <= rechtsArray[j]) {
                array[k] = linksArray[i];
                i++;
            } else {
                array[k] = rechtsArray[j];
                j++;
            }
            k++;
        }

        // Restliche Elemente der linken und rechten Teilarrays kopieren, falls vorhanden
        while (i < n1) {
            array[k] = linksArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rechtsArray[j];
            j++;
            k++;
        }
    }

    // Hilfsfunktion zum Ausdrucken eines Arrays
    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
