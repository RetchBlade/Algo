package Sort;

public class MergeSortOriginal {

    // --- 1:1 aus dem Skript (Session 5, Folie 343–344) ---
    public static void mergeSort(int[] a) {
        int[] helpa = new int[a.length];
        doMergeSort(a, helpa, 0, a.length - 1);  // <— Reihenfolge fix
    }

    public static void doMergeSort(int[] a, int[] helpa, int left, int right) {
        if (right - left > 0) {
            int middle = (left + right) / 2;
            doMergeSort(a, helpa, left, middle);        // Sortiere a[left,…,middle]
            doMergeSort(a, helpa, middle + 1, right);   // Sortiere a[middle+1,…,right]
            mergeParts(a, left, middle, right, helpa);  // Füge die 2 Teile zusammen
        }
    }
    // --- Ende Skript-Teil ---

    // Im Skript nur erwähnt – hier ergänzt, damit es läuft
    private static void mergeParts(int[] a, int left, int middle, int right, int[] helpa) {
        for (int i = left; i <= right; i++) helpa[i] = a[i];
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right) {
            if (helpa[i] <= helpa[j]) a[k++] = helpa[i++];
            else a[k++] = helpa[j++];
        }
        while (i <= middle) a[k++] = helpa[i++];
        // Rechte Reste sind schon an Ort und Stelle
    }

    // Beispiel zum Testen
    public static void main(String[] args) {
        int[] arr = {34, 76, 23, 11, 84, 32, 77, 51};

        System.out.println("Ursprünglich:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\nNach MergeSort:");
        printArray(arr);
    }

    private static void printArray(int[] a) {
        for (int n : a) System.out.print(n + " ");
        System.out.println();
    }
}

