package sorting;

public class InsertionSort {
	
	public static void insertSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i ++) {
			for (int j = i + 1; j < arr.length; j ++) {
				if (arr[i] > arr[j]) {
					swap(i, j, arr);
				}
			}
		}
	}
	
	private static void swap (int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
