package sorting;

/**
 * Implementation of Merge Sort - worst-case = O(nlogn)
 * @author diont
 *
 */
public class MergeSort {

	// this merge sort keeps track of the indices of the array
	public static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}
	
	private static void merge(int[] arr, int low, int mid, int high) {
		// get the two subarrays to be merged
		int size1 = mid - low + 1;
		int size2 = high - mid;
		int[] subarr1 = new int[size1];
		int[] subarr2 = new int[size2];
		
		//copy data to temp arrays
		//subarr1
		for (int i = 0; i < size1; i ++) {
			subarr1[i] = arr[low + i];
		}
		//subarr2
		for (int i = 0; i < size2; i ++) {
			subarr2[i] = arr[mid + 1 + i];
		}
		
		// i = index for first array, j = index for second array
		int i = 0, j = 0;
		int arrIndex = low;
		while (i < size1 && j < size2) {
			if (subarr1[i] > subarr2[j]) {
				arr[arrIndex] = subarr2[j];
				j ++;
			}
			else {
				arr[arrIndex] = subarr1[i];
				i ++;
			}
			arrIndex ++;
		}
		while (i < size1) {
			arr[arrIndex] = subarr1[i];
			i ++;
			arrIndex ++;
		}
		while (j < size2) {
			arr[arrIndex] = subarr2[j];
			j ++;
			arrIndex ++;
		}
	}
}
