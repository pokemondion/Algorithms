package graphtheory;

import java.util.LinkedList;

public class WeightedGraph {
	
	private class Edge{
		int source;
		int destination;
		int weight;
		
		Edge (int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	private int numVertices;
	private LinkedList<Edge>[] adj;

	public WeightedGraph(int vertices) {
		numVertices = vertices;
		adj = new LinkedList[vertices];
		for (int i = 0; i < vertices; i ++) {
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdge() {
		
	}
}
