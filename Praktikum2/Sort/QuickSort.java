package Sort;

public class QuickSort {

    public static void quickSort(int[] A) {
        quickSortIntern(A, 0, A.length - 1);
    }

    public static void quickSortIntern(int[] A, int left, int right) {
        if (right - left > 0) {
            int pivotIndex = partitioniere(A, left, right);
            quickSortIntern(A, left, pivotIndex - 1);
            quickSortIntern(A, pivotIndex + 1, right);
        }
    }

    public static int partitioniere(int[] A, int left, int right) {
        int pivot = A[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (A[j] <= pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[right];
        A[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {34, 76, 23, 11, 84, 32, 77, 51};

        System.out.println("Vorher:");
        print(a);

        quickSort(a);

        System.out.println("Nachher:");
        print(a);
    }

    private static void print(int[] a) {
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
