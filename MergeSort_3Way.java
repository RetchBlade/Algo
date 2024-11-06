package Sort;

public class MergeSort_3Way {

	public static void mergeSort(int[] a) {
        int[] helpA = new int[a.length];
        doMergeSort(a, 0, a.length - 1, helpA);
    }

    public static void doMergeSort(int[] a, int left, int right, int[] helpA) {
        if (right - left > 0) {
            int middle = (left + right) / 2;
            doMergeSort(a, left, middle, helpA);
            doMergeSort(a, middle + 1, right, helpA);
            mergeParts(a, left, middle, right, helpA);
        }
    }

    public static void mergeParts(int[] a, int leftEnd, int middle, int rightEnd, int[] helpA) {
        for (int i = leftEnd; i <= rightEnd; i++) {
            helpA[i] = a[i];
        }
        int leftIndex = leftEnd;
        int rightIndex = middle + 1;
        int outIndex = leftEnd;

        while (leftIndex <= middle && rightIndex <= rightEnd) {
            if (helpA[leftIndex] < helpA[rightIndex]) {
                a[outIndex] = helpA[leftIndex];
                leftIndex++;
            } else {
                a[outIndex] = helpA[rightIndex];
                rightIndex++;
            }
            outIndex++;
        }

        while (leftIndex <= middle) {
            a[outIndex] = helpA[leftIndex];
            outIndex++;
            leftIndex++;
        }
        while (rightIndex <= rightEnd) {
            a[outIndex] = helpA[rightIndex];
            outIndex++;
            rightIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 101};
        System.out.print("Nicht Sortierte Liste: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        mergeSort(arr);
        System.out.print("\nSortierte Liste: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}