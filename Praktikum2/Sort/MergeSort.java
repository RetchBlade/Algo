package Sort;

public class MergeSort {

    public static void mergeSort(int[] a) {
        int[] helpa = new int[a.length];
        doMergeSort(a, 0, a.length - 1, helpa);
    }

    public static void doMergeSort(int[] a, int left, int right, int[] helpa) {
        if (right - left > 0) {
            int middle = (left + right) / 2;
            doMergeSort(a, left, middle, helpa);
            doMergeSort(a, middle + 1, right, helpa);
            mergeParts(a, left, middle, right, helpa);
        }
    }

    public static int mergeParts(int[] a, int left, int middle, int right, int[] helpa) {
        int comparisons = 0;

        for (int i = left; i <= right; i++) {
            helpa[i] = a[i];
        }

        int leftIndex = left;
        int rightIndex = middle + 1;
        int outIndex = left;

        while (leftIndex <= middle && rightIndex <= right) {
            comparisons++;
            if (helpa[leftIndex] <= helpa[rightIndex]) {
                a[outIndex] = helpa[leftIndex];
                leftIndex++;
            } else {
                a[outIndex] = helpa[rightIndex];
                rightIndex++;
            }
            outIndex++;
        }

        while (leftIndex <= middle) {
            a[outIndex] = helpa[leftIndex];
            outIndex++;
            leftIndex++;
        }

        while (rightIndex <= right) {
            a[outIndex] = helpa[rightIndex];
            outIndex++;
            rightIndex++;
        }

        return comparisons;
    }

    public static void main(String[] args) {
        int[] a = {34, 76, 23, 11, 84, 32, 77, 51};

        System.out.println("Vorher:");
        print(a);

        mergeSort(a);

        System.out.println("Nachher:");
        print(a);
    }

    private static void print(int[] a) {
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}

