package sorting;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testMergeSort() {
		int[] testArray = {21,61,34,85,11,24,22,21};
		int[] expectedArray = {11,21,21,22,24,34,61,85};
		int size = testArray.length;
		
		QuickSort.quickSort(testArray, 0, size-1);
		boolean correct = true;
		for (int i = 0; i < size; i++) {
			if (testArray[i] != expectedArray[i]) {
				correct = false;
			}
		}
		assertTrue("Quick Sort was not implemented correctly",correct);
	}
}
