package graphtheory;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public static int[] bfs(Graph g, int vertice) {
		int sizeG = g.getNumVertices();
		LinkedList<Integer>[] adj = g.getAdjList();
		boolean[] visited = new boolean[sizeG];
		Queue<LinkedList<Integer>> queue = new LinkedList();

		for (int i = 0; i < sizeG; i ++) {
			visited[i] = false;
		}
		
		int[] bfsArr = new int[sizeG];
		
		queue.add(adj[vertice]);
		visited[vertice] = true;
		bfsArr[0] = vertice;
		int i = 1;
		
		while (!queue.isEmpty()) {
			LinkedList<Integer> currNode = queue.poll();
			while (!currNode.isEmpty()) {
				int nextVerticeIndex = currNode.poll();
				queue.add(adj[nextVerticeIndex]);
				if (!visited[nextVerticeIndex]) {
					visited[nextVerticeIndex] = true;
					bfsArr[i] = nextVerticeIndex;
					i ++;
				}
			}
		}
		return bfsArr;
	}
	
}
