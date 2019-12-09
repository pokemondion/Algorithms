package graphtheory;

import java.util.Iterator;
import java.util.LinkedList;

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

	public Graph PA(Graph G) {
		int size = G.getNumVertices();
		Graph newG = new Graph(size);
		LinkedList[] adj = G.getAdjList();
		
		// first 
		
		for (int i = 0; i < size; i ++) {
			Iterator iter = adj[i].iterator();
//			while () {
//				
//			}
		}

		return G;
	}
}
