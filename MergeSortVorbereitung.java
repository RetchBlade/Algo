
public class MergeSortVorbereitung {

	 // Einstieg wie im Skript: Hilfsarray erzeugen und doMergeSort starten
    public static void mergeSort(int[] a) {
        if (a == null || a.length <= 1) return;
        int[] helpa = new int[a.length];
        doMergeSort(a, helpa, 0, a.length - 1);
    }

    // Rekursive Sortiermethode mit Indizes
    private static void doMergeSort(int[] a, int[] helpa, int left, int right) {
        if (left >= right) return; // Bereich <= 1 Element
        int middle = (left + right) / 2;

        doMergeSort(a, helpa, left, middle);       // sortiere linke Hälfte
        doMergeSort(a, helpa, middle + 1, right);  // sortiere rechte Hälfte

        mergeParts(a, left, middle, right, helpa); // füge zusammen
    }

    // Mergen mit Hilfsarray (wie MergeSortOriginal)
    private static void mergeParts(int[] a, int left, int middle, int right, int[] helpa) {
        // betroffenen Bereich in helpa kopieren
        for (int i = left; i <= right; i++) {
            helpa[i] = a[i];
        }

        int i = left;        // Zeiger linke Hälfte
        int j = middle + 1;  // Zeiger rechte Hälfte
        int k = left;        // Schreibindex im Ziel a

        while (i <= middle && j <= right) {
            if (helpa[i] <= helpa[j]) {
                a[k++] = helpa[i++];
            } else {
                a[k++] = helpa[j++];
            }
        }
        // linke Reste zurückschreiben
        while (i <= middle) {
            a[k++] = helpa[i++];
        }
        // rechte Reste sind schon an Ort und Stelle
    }

    // Deine binäre Suche kann unverändert bleiben
    public static int binarysearch(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (array[mid] == target) return mid;
        if (target < array[mid]) return binarysearch(array, target, left, mid - 1);
        return binarysearch(array, target, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Originales Array:");
        for (int num : array) System.out.print(num + " ");

        mergeSort(array); // nutzt jetzt Hilfe-Variante

        System.out.println("\nSortiertes Array:");
        for (int num : array) System.out.print(num + " ");

        System.out.println("\nBinarysearch");
        int target = 43;
        int result = binarysearch(array, target, 0, array.length - 1);
        if (result == -1) System.out.println("Element nicht gefunden");
        else System.out.println("Element " + target + " gefunden an Index " + result);
    }
}
