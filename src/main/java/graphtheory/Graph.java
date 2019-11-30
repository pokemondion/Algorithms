package graphtheory;

import java.util.LinkedList;

public class Graph {
	
	private int numVertices;
	private LinkedList<Integer>[] adj; // creates an array of linked lists
	
	public Graph(int numV) {
		numVertices = numV; // number of vertices
		adj = new LinkedList[numV]; // adjacency list, size = # number of vertices
		for (int i = 0; i < numV; i ++) {
			adj[i] = new LinkedList();
		}
	}
	
	/**
	 * Adds a connection between the two specified vertice through an adjacency list. 
	 * Adding the connection for vertice1 does not mean it has been added for vertice 2. 
	 * It is possible to add the same connection more than onece 
	 * @param vertice1
	 * @param vertice2
	 */
	public void addEdge(int vertice1, int vertice2) {
		adj[vertice1].add(vertice2);
	}
	
	public LinkedList<Integer>[] getAdjList() {
		return adj;
	}
	
	public int getNumVertices() {
		return numVertices;
	}
}
