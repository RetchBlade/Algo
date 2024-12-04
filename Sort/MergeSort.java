package Sort;

public class MergeSort {

    // Hauptfunktion, die MergeSort aufruft
    public static void mergeSort(int[] array) {
        // Wenn das Array nur ein oder null Elemente hat, ist es bereits sortiert
        if (array.length <= 1) {
            return;
        }
        
        // Die Mitte des Arrays berechnen, um es in zwei Hälften zu teilen
        int mid = array.length / 2;

        // Arrays für die linke und rechte Hälfte erstellen
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Das Array in die linke und rechte Hälfte aufteilen
        // 				 Quelle,	Startindex,	Ziel-Array,	Startindex im Ziel-Array,	die Anzahl der Elemente
        System.arraycopy(array, 	0, 			left, 		0, 							mid);
        
        //		 		Quelle,		Startindex,	Ziel-Array,	Startindex im Ziel-Array,	die Anzahl der Elemente
        System.arraycopy(array, 	mid, 		right, 		0, 							array.length - mid);

        // Die linke und rechte Hälfte rekursiv sortieren
        mergeSort(left);
        mergeSort(right);

        // Die sortierten Hälften zusammenführen
        merge(array, left, right);
    }

    // Hilfsfunktion zum Zusammenführen der beiden sortierten Arrays
    private static void merge(int[] originalArray, int[] leftHalf, int[] rightHalf) {
        // Zeiger für linkes, rechtes und das zusammengeführte Array
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        // Die Elemente der beiden Hälften in das Originalarray einfügen, bis eine Hälfte leer ist
        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                originalArray[mergedIndex++] = leftHalf[leftIndex++]; // Element von links einfügen und Zeiger erhöhen
            } else {
                originalArray[mergedIndex++] = rightHalf[rightIndex++]; // Element von rechts einfügen und Zeiger erhöhen
            }
        }

        // Restliche Elemente der linken Hälfte einfügen, falls vorhanden
        while (leftIndex < leftHalf.length) {
            originalArray[mergedIndex++] = leftHalf[leftIndex++];
        }
        
        // Restliche Elemente der rechten Hälfte einfügen, falls vorhanden
        while (rightIndex < rightHalf.length) {
            originalArray[mergedIndex++] = rightHalf[rightIndex++];
        }
    }
    
    public static void main(String[] args) {
        // Beispielarray, das sortiert werden soll
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Originales Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        
        // Aufruf von mergeSort zum Sortieren des Arrays
        mergeSort(array);

        // Ausgabe des sortierten Arrays
        System.out.println("\nSortiertes Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
