package Sort;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {34, 76, 23, 11, 84, 32, 77, 51};

        System.out.println("Vorher:");
        print(a);

        bubbleSort(a);

        System.out.println("Nachher:");
        print(a);
    }

    private static void print(int[] a) {
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}

