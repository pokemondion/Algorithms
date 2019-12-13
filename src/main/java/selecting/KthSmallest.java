package selecting;

/**
 * 1. The Kth smallest could also be the Kth largest by changing a couple of lines below.
 * This algorithm uses an implementation of Quick Select to find the Kth smallest item
 * in O(n) time.
 * 
 * 2. The simple approach would be to order the elements from lowest to greatest and extrapolate
 * the Kth smallest element but this would result in a Minimum time complexity of nlogn.
 * 
 * 3. Another Solution would be to incrementally scan all the elements and rearrange them so that
 * all of the scanned items forms a max heap of size K thus far. If the currently scanned item is 
 * too large, we discard it. If it is less than A[0], Kth smallest, remove A[0] and place the 
 * scanned item in the heap. This takes O(nlogK) time
 * 
 * 4. Another solution would be to form a min heap of the array and perform K successive DeleteMin 
 * operations. This takes O(n + Klogn)
 * @author diont
 *
 */
public class KthSmallest {
	
	public int kthSmallest(int[] arr, int k) {
		return quickSelect(arr, k, 0, arr.length-1);
	}
	
	public int quickSelect(int[] arr, int k, int left, int right) {
		int randomIndex = (int) (right - left + 1 * Math.random()) + left;
		int pivot = partition(arr, randomIndex, left, right);
		if (pivot - left >= k + left) {
			return quickSelect(arr, k, left, pivot - 1);
		}
		else if (arr.length - (right - pivot) >= k + left) {
			return arr[pivot];
		}
		else {
			return quickSelect(arr, k - arr.length + (right - pivot), pivot + 1, right);
		}
	}
	
	public int partition(int[] arr, int randomIndex, int left, int right) {
		int i = left - 1, j = left;
		while (j <= right) {
			if (j == randomIndex) {
				j ++;
				continue;
			}
			if (i == randomIndex) {
				i ++;
				continue;
			}
			if (arr[j] < arr[randomIndex]) {
				swap(arr, ++ i, j);
			}
			j ++;
		}
		swap(arr, ++ i, randomIndex);
		return i;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		KthSmallest p = new KthSmallest();
		int[] arr = {2,5,3,6,7,4};
		System.out.println(p.kthSmallest(arr, 6));
	}
}
