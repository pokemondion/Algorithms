package graphtheory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Searches for the value in the specified array graph.
 * @author diont
 *
 */
public class DFS {

	// performs DFS on the graph g starting at the vertice indexed
	public static int[] dfs(Graph g, int vertice) {
		Stack<Integer> stack = new Stack();
		LinkedList<Integer>[] adj = g.getAdjList();
		int numVertices = g.getNumVertices();
		
		boolean[] visited = new boolean[numVertices];
		for (int i = 0; i < numVertices; i ++) {
			visited[i] = false;
		}
		
		// the dfsHelper returns the results in reverse order, thus we have to 
		// reverse its order to obtain the dfs 
		dfsHelper(adj, visited, vertice, stack);

		int [] dfsArr = new int[numVertices];
		for (int i = numVertices - 1; i >= 0; i --) {
			dfsArr[i] = stack.pop();
		}
		return dfsArr;
	}
	
	// recursive implementation
	private static void dfsHelper(LinkedList<Integer>[] adj, boolean[] visited, int vertice, Stack stack) {
		visited[vertice] = true;
		Iterator<Integer> iter = adj[vertice].iterator();
		stack.push(vertice);
		while (iter.hasNext()) {
			int nextVertice = iter.next();
			if (!visited[nextVertice]) {
				dfsHelper(adj, visited, nextVertice, stack);
			}
		}
	}

}
