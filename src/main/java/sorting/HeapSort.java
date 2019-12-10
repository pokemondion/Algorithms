package sorting;

import java.util.Arrays;

public class HeapSort {
	
	public static void HeapHippityHopSort(int[] array) {
		int size = array.length;

		for (int i = size; i > 0; i --) {
			
			constructMaxHeap(array);
		//	swap(0, i-1, array);
			
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
	
	private static void constructMaxHeap(int[] array) {
		int size = array.length;
		for (int i = size/2; i >= 0; i --) {
			downMaxHeap(i, array);
		}
	}
	
	private static void downMaxHeap(int index, int[] array) {
		int pos = index + 1;
		int size = array.length;
		if (!isLeaf(pos, array)) {
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
