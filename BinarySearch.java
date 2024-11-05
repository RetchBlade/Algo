package Such;

public class BinarySearch {

    // Iterative Methode für die binäre Suche
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Prüfen, ob das mittlere Element das gesuchte Ziel ist
            if (arr[mid] == target) {
                return mid;
            }

            // Wenn das Ziel kleiner als das mittlere Element ist, linke Hälfte durchsuchen
            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                // Andernfalls rechte Hälfte durchsuchen
                left = mid + 1;
            }
        }

        return -1; // Element nicht gefunden
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        int result = binarySearch(arr, target);
        
        if (result == -1) {
            System.out.println("Element nicht gefunden");
        } else {
            System.out.println("Element gefunden an Index " + result);
        }
    }
}
