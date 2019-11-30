package sorting;

/**
 * Implementation of Quick Sort - worst-case = O(n^2)
 * @author diont
 *
 */
public class QuickSort {
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			// puts the pivot into place and performs quick sort on the other
			// partitions
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right) {
		int i = left, j = left - 1;
		int pivotValue = arr[right];
		while (i < right) {
			if (arr[i] < pivotValue) {
				j ++;
				swap(arr, i, j);
			}
			i ++;
		}
		j ++;
		swap(arr, right, j);
		return j;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
