package graphtheory;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DFSTest {
	
	Graph g = new Graph(8);
	
	@Before
	public void setup() {
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 0);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 7);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 3);
		g.addEdge(5, 3);
		g.addEdge(5, 6);
		g.addEdge(6, 5);
		g.addEdge(7, 2);
	}
	
	@Test
	/*
	 * Tests for ONE possible path 
	 * Tests the DFS method in the DFS class for the graph g starting at 
	 * index 0.
	 * 
	 */
	public void testDFS() {
		boolean correct1, correct2, correct3, correct4, answer;
		int[] expected1 = {0,1,3,4,5,6,2,7};
		int[] expected2 = {0,1,3,5,6,4,2,7};
		int[] expected3 = {0,2,7,1,3,4,5,6};
		int[] expected4 = {0,2,7,1,3,5,6,4};
		int[] testDFS = DFS.dfs(g, 0);
		correct1 = Arrays.equals(expected1, testDFS);
		correct2 = Arrays.equals(expected2, testDFS);
		correct3 = Arrays.equals(expected3, testDFS);
		correct4 = Arrays.equals(expected4, testDFS);
		answer = (correct1 || correct2 || correct3 || correct4);
		assertTrue("DFS was not implemented correctly!", answer);
	}

}
