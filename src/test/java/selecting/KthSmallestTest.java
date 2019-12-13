package selecting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KthSmallestTest {
	
	@Test
	public void testKthSmallest() {
		int[] arr = {4,122,45,77,1,0};
		int k = 5;
		int expected = 77;
		int test = KthSmallest.kthSmallest(arr, 5);
		boolean ans = (expected == test)? true : false;
		assertTrue(ans);
	}

}
