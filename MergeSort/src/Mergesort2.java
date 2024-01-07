public class Mergesort2 {
	public static void main(String[] args) {
		int[] a = { 40, 20, 7, 80, 60, 50, 10, 30, 17, 42 };
		System.out.println("Zu sortierendes Array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		mergeSort(a);
		System.out.println("Sortiertes Array:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			
		}
	}
	
	public static void mergeSort(int[] array) {
		int inputLength = array.length;
		//Abbruchbedingung, das Array wird immer weiter geteilt (teile und herrsche Prinzip) bis nur noch ein Element da ist => es ist sortiert
		if (inputLength < 2) {
			return;
		}
		
		int midIndex = inputLength/2;
		
		//Linkes und rechtes Array erstellen und mit den Elementen aus dem Eingabearray befüllen
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];
		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = array[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i-midIndex] = array[i];
		}
		
		// Auf links und rechts erneut anwenden
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(array,leftHalf,rightHalf);
		
	}
	
	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		//Die Länge des linken und rechten Arrays 
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		
		//i zeigt aufs linke Array, k aufs rechte, und j auf das inputArray
		int i = 0, k = 0, j = 0;
		
		//Elemente vergleichen und ins inputArray einsortieren
		while(i<leftSize && k < rightSize) {  //um jeweils ans Ende des linken und rechten Teilarrays zu gehen ohne ArrayOutOfBoundsExc
			
			
			//Ist das i'te Element im leftHalf kleiner als das k'te im rightHalf? Dann packe es ins InputArray, ansonsten halt das andere. Zeiger werden jeweils erhöht
			if (leftHalf[i] < rightHalf[k]) {
				inputArray[j] = leftHalf[i];
				i++;
			}else {
				inputArray[j] = rightHalf[k];
				k++;
			}
			j++;
		}
		// Wenn die obere While-Loop durch ist, dann bleiben in einem der Teilarrays Elemente übrig, diese sortieren wir nun ein - wir gucken uns das linke Teilarray an
		while (i < leftSize) {
			inputArray[j] = leftHalf[i];
			i++;
			j++;
		}
		//Falls links nichts übrig ist wird rechts geguckt ob noch was einsortiert werden muss
		while(k < rightSize) {
			inputArray[j] = rightHalf[k];
			k++;
			j++;
		}
		//jetzt rufen wir das ganze nur noch oben in der Methode auf!
	}
	
	
}