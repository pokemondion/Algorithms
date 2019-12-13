package sorting;

import java.util.Arrays;

public class HeapSort {
	
	// fix this method
	public static void HeapHippityHopSort(int[] array) {
		int size = array.length;
		int[] newArray = Arrays.copyOf(array, size);
		constructMaxHeap(newArray);
		for (int i = size-1; i >= 0; i --) {
			array[i] = deleteMax(i, newArray);
		}
	}
	
	private static int rightChildPos(int pos) {
		return (pos * 2) + 1;
	}
	
	private static int leftChildPos(int pos) {
		return (pos * 2);
	}
	
	private static boolean isLeaf(int pos, int[] array) {
		int size = array.length;
		if (pos >= (size/2) + 1) {
			return true;
		}
		return false;
	}
	
	public static void constructMaxHeap(int[] array) {
		int size = array.length;
		for (int i = size/2; i >= 0; i --) {
			downMaxHeap(i, array);
		}
	}
	
	private static void downMaxHeap(int index, int[] array) {
		int pos = index + 1;
		int size = array.length;
		if (!isLeaf(pos, array)) {
			if (rightChildPos(pos) <= size) {
				if (array[leftChildPos(pos) - 1] > array[index] || array[rightChildPos(pos) - 1] > array[index]) {
					if (array[leftChildPos(pos) - 1] > array[rightChildPos(pos) - 1]) {
						swap(index, leftChildPos(pos) - 1, array);
						downMaxHeap(leftChildPos(pos) - 1, array);
					}
					else {
						swap(index, rightChildPos(pos) - 1, array);
						downMaxHeap(rightChildPos(pos) - 1, array);
					}
				}			
			}
			else if (leftChildPos(pos) <= size) {
				if (array[leftChildPos(pos) - 1] > array[index]) {
					swap(index, leftChildPos(pos) - 1, array);
					downMaxHeap(leftChildPos(pos) - 1, array);
				}
			}
		}
	}
	
	private static int deleteMax(int i, int[] array) {
		int max = array[0];
		swap(0, i, array);
		// one line of code to decrease the size of array by 1 and conduct the loop algo again
		downMaxHeap(0, array);
		return max;
	}
	
	private static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main (String[] args) {
		int[] test = {7,3,5,6,8};
		int[] expted = {8,7,5,6,3};
		HeapSort.HeapHippityHopSort(test);
		for (int i = 0; i < test.length; i ++) {
			System.out.print(test[i] + " ");
		}
	}
	
}
