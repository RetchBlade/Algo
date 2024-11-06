package test;

public class SelbstTest {
	
	public static void mergeSort(int[] array) {
		if(array.length <= 1) {return;}
		
		int mid = array.length / 2;
		
		int [] leftarray = new int[mid];
		int [] rightarray = new int[array.length-mid];
		
		System.arraycopy(array, 0, leftarray, 0, mid);
		System.arraycopy(array, mid, rightarray, 0, array.length-mid);
		
		mergeSort(leftarray);
		mergeSort(rightarray);
		
		merge(array, leftarray, rightarray);
	}
	
	public static void merge(int[] array, int[] leftarray, int[] rightarray) {
		int 	m_index = 0,
				l_index = 0,
				r_index = 0;
		
		while(l_index < leftarray.length && r_index < rightarray.length){
			if(leftarray[l_index] <= rightarray[r_index]){
				array[m_index++] = leftarray[l_index++];
			} else {
				array[m_index++] = rightarray[r_index++];
			}
		}
			while(l_index < leftarray.length) {
				array[m_index++] = leftarray[l_index++];
			}
			
			while(r_index < rightarray.length) {
				array[m_index++] = rightarray[r_index++];
			}
		}
	
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
		 int[] array = {38, 27, 43, 3, 9, 82, 10};
	        System.out.println("Originales Array:");
	        for (int num : array) {
	            System.out.print(num + " ");
	        }
	        
	        mergeSort(array);
	        System.out.println("\nSortiertes Array:");
	        for (int num : array) {
	            System.out.print(num + " ");
	        }
	        
	        System.out.println("\nBinarysearch");
	        int target = 43;
	        int result = binarysearch(array, target, 0, array.length - 1);
	        if (result == -1) {
	            System.out.println("Element nicht gefunden");
	        } else {
	            System.out.println("Element" + target + " gefunden an Index " + result);
	        }
	}
}
