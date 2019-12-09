package graphtheory;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GraphTesting {
	
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
		boolean iscorrect1, iscorrect2, iscorrect3, iscorrect4, answer;
		int[] expected1 = {0,1,3,4,5,6,2,7};
		int[] expected2 = {0,1,3,5,6,4,2,7};
		int[] expected3 = {0,2,7,1,3,4,5,6};
		int[] expected4 = {0,2,7,1,3,5,6,4};
		int[] testDFS = DFS.dfs(g, 0);
		iscorrect1 = Arrays.equals(expected1, testDFS);
		iscorrect2 = Arrays.equals(expected2, testDFS);
		iscorrect3 = Arrays.equals(expected3, testDFS);
		iscorrect4 = Arrays.equals(expected4, testDFS);
		answer = (iscorrect1 || iscorrect2 || iscorrect3 || iscorrect4);
		assertTrue("DFS was not implemented correctly!", answer);
	}
	
	@Test
	public void testBFS() {
		boolean iscorrect1, iscorrect2, iscorrect3, iscorrect4, iscorrect5, iscorrect6, iscorrect7, iscorrect8, answer;
		int[] expected1 = {0,1,2,3,7,4,5,6};
		int[] expected2 = {0,2,1,3,7,4,5,6};
		int[] expected3 = {0,1,2,7,3,4,5,6};
		int[] expected4 = {0,2,1,7,3,4,5,6};
		int[] expected5 = {0,1,2,3,7,5,4,6};
		int[] expected6 = {0,1,2,7,3,5,4,6};
		int[] expected7 = {0,2,1,3,7,5,4,6};
		int[] expected8 = {0,2,1,7,3,5,4,6};
		int[] testBFS = BFS.bfs(g, 0);
		iscorrect1 = Arrays.equals(expected1, testBFS);
		iscorrect2 = Arrays.equals(expected2, testBFS);
		iscorrect3 = Arrays.equals(expected3, testBFS);
		iscorrect4 = Arrays.equals(expected4, testBFS);
		iscorrect5 = Arrays.equals(expected5, testBFS);
		iscorrect6 = Arrays.equals(expected6, testBFS);
		iscorrect7 = Arrays.equals(expected7, testBFS);
		iscorrect8 = Arrays.equals(expected8, testBFS);
		answer = (iscorrect1 || iscorrect2 || iscorrect3 || iscorrect4 || iscorrect5 || iscorrect6 || iscorrect7 || iscorrect8);
		assertTrue("DFS was not implemented correctly!", answer);
	}

}
