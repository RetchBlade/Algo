package Such;

public class binarySearchRecursive {

	public static int  binarysearch(int[] array, int target, int left, int right) {
		if (left > right) {
            return -1; 
        }
	
        int mid = left + (right - left) / 2;

      
        if (array[mid] == target) {
            return mid; 
        }

       
        if (target < array[mid]) {
            return binarysearch(array, target, left, mid - 1);
        } else {
            return binarysearch(array, target, mid + 1, right);
        }
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] array = {3, 9, 10, 27, 38, 43, 82 };
	        System.out.println("Array:");
	        for (int num : array) {
	            System.out.print(num + " ");
	        }
	        
	        
	        System.out.println("\nBinarysearch");
	        int target = 43;
	        int result = binarysearch(array, target, 0, array.length - 1);
	        if (result == -1) {
	            System.out.println("Element nicht gefunden");
	        } else {
	            System.out.println("Element " + target + " gefunden an Index " + result);
	        }
	}
}
