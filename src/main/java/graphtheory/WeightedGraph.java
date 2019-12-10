package graphtheory;

import java.util.LinkedList;

public class WeightedGraph {
	
	public class Edge{
		int source;
		int destination;
		int weight;
		
		public Edge (int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public int getSource() {
			return source;
		}
		
		public int getDestination() {
			return destination;
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
	
	public LinkedList<Edge>[] getAdjList() {
		return adj;
	}
	
	public void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adj[source].add(edge);
	}
	
	public int getNumVertices() {
		return numVertices;
	}
	
	public void removeEdge(int source, int destination) {
		adj[source].remove(destination);
	}
	
	// contains DFS approach
	public boolean containsCycle() {
		boolean[] visited = new boolean[numVertices];
		boolean[] recStack = new boolean[numVertices];
		
		for (int i = 0; i < numVertices; i ++) {
			if (containsCycleHelper(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean containsCycleHelper(int i, boolean[] visited, boolean[] recStack) {
		// indicate the current vertice is running with recStack
		if (recStack[i]) {
			return true;
		}
		if (visited[i]) {
			return false;
		}
		
		recStack[i] = true;
		visited[i] = true;
		LinkedList<Edge> children = adj[i];
		for (Edge e : children) {
			if (containsCycleHelper(e.getDestination(), visited, recStack)) {
				return true;
			}
		}
		recStack[i] = false;
		
		return false;
	}
	
}
