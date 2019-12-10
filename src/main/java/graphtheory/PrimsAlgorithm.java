package graphtheory;

import java.util.Iterator;
import java.util.LinkedList;

import graphtheory.WeightedGraph.Edge;

/** (GREEDY METHOD)
 * Prim's algorithm suggests that we first select the edge with the most minimum weight. Then from that edge we
 * look at the adjacent weighted edges w/ respect to all selected edges except the edges that have already been 
 * chosen, and we choose the minimum edge within this. If the edge that we chose forms a cycle, then we choose the 
 * next minimum weighted edge.
 * 
 * For NON-CONNECTED Graphs G, Prim's algorithm cannot find the minimum spanning tree.
 * @author diont
 *
 */
public class PrimsAlgorithm {

	public WeightedGraph PA(WeightedGraph WG) {
		int size = WG.getNumVertices();
		WeightedGraph newG = new WeightedGraph(size);
		LinkedList<Edge>[] adj = WG.getAdjList();
		boolean[] visited = new boolean[size];
		
		// initialize variables
		int minSource = Integer.MAX_VALUE;
		int minDestination = Integer.MAX_VALUE;
		int minWeight = Integer.MAX_VALUE;
		
		// look for the smallest edge
		for (int i = 0; i < size; i ++) {
			LinkedList<Edge> vertice = adj[i];
			while (!vertice.isEmpty()) {
				Edge currEdge = vertice.poll();
				if (currEdge.getWeight() < minWeight) {
					minWeight = currEdge.getWeight();
					minSource = currEdge.getSource();
					minDestination = currEdge.getDestination();
					visited[minSource] = true;
					visited[minDestination] = true;
				}
			}
		}
		
		// perform the greedy method
		LinkedList<Integer> list = new LinkedList();
		LinkedList<Integer> cannotlist = new LinkedList();
		list.add(minSource);
		list.add(minDestination);
		boolean allConnected = false;
		while (!allConnected) {
			// search through all vertices for the smallest edge
			int minvertice1 = Integer.MAX_VALUE;
			int minvertice2 = Integer.MAX_VALUE;
			int minedge = Integer.MAX_VALUE;
			for (int i = 0; i < size; i ++) {
				if (visited[i]) {
					for (Edge e : adj[i]) {
						if (!list.contains(e.getDestination()) && !cannotlist.contains(e.getDestination())) {
							if (e.getWeight() < minedge) {
								minvertice1 = e.getSource();
								minvertice2 = e.getDestination();
								minedge = e.getWeight();
							}
						}
					}
				}
			}
			visited[minvertice2] = true;
			list.add(minvertice2);
			newG.addEdge(minvertice1, minvertice2, minedge);
			if (newG.containsCycle()) {
				list.remove(minvertice2);
				visited[minvertice2] = false;
				newG.removeEdge(minvertice1, minvertice2);
				cannotlist.add(minvertice2);
			}
			
			for (int i = 0; i < size; i ++) {
				if (!visited[i]) {
					continue;
				}
			}
			allConnected = true;
		}
		return newG;
	}
	
}
