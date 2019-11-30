package sorting;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void testMergeSort() {
		int[] testArray = {21,61,34,85,11,24,22,21};
		int[] expectedArray = {11,21,21,22,24,34,61,85};
		int size = testArray.length;
		
		MergeSort.mergeSort(testArray, 0, size-1);
		boolean correct = true;
		for (int i = 0; i < size; i++) {
			if (testArray[i] != expectedArray[i]) {
				correct = false;
			}
		}
		assertTrue("Merge Sort was not implemented correctly!",correct);
	}

}
