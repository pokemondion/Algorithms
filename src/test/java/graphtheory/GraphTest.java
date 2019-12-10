package graphtheory;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {
	
	static Graph g = new Graph(8);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void getNumVerticesTest() {
		boolean answer = (g.getNumVertices() == 8);
		assertTrue("The number of vertices in the graph is 8!", answer);
	}
	
	@Test
	public void containsCycleTest() {
		boolean answer = g.containsCycle();
		assertTrue("The following graph does not contain a Cycle!", answer);
	}

}
