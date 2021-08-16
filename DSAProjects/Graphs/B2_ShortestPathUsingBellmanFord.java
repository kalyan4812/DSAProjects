package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import Graphs.B1_ShortestPathInGraphUsingDijkstra.Node;

public class B2_ShortestPathUsingBellmanFord {


	// works for negative edges.

	public static void main(String... strings) {

		ArrayList<Node> adj = setUpGraph();

		shortestPath(adj,  0);

	}

	//O(VE)
	private static void shortestPath(ArrayList<Node> adj,int s) {
		int v=4;
		int dist[]=new int[v]; // no of vertices should be passed not v.
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s]=0;
		
	    for(int i=0;i<v-1;i++) {
	    	for(Node node:adj) {
	    		if(dist[node.u]+node.weight<dist[node.v]) {
	    			dist[node.v]=dist[node.u]+node.weight;
	    		}
	    	}
	    }
	    
	    boolean hasNegativeCycle=false;
	    for(Node node:adj) {
    		if(dist[node.u]+node.weight<dist[node.v]) {
    		   System.out.println("Graph has negative cycle");
    		   break;
    		}
    	}
	    if(!hasNegativeCycle) {
	    	for (int k : dist) {
				
					System.out.print(k + " ");
				
			}
	    }
	    
	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<Node> setUpGraph() {
		int vertices = 4;

		ArrayList<Node> adj = new ArrayList<>(vertices); // edge list no need of adj list.

		
		addEdge(adj, 0, 1, 1);
		addEdge(adj, 1, 3, 2);
		addEdge(adj, 0, 2, 4);
		addEdge(adj, 1, 2, -3);
		addEdge(adj, 2, 3, 3);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<Node> adj, int u, int v, int w) {

		adj.add(new Node(u,v, w));
		//adj.add(new Node(u,v, w));

	}

	static class Node  {
		int u;
		int v;
		int weight;

		Node() {

		}

		Node(int u,int val, int weight) {
			this.u=u;
			this.v = val;
			this.weight = weight;
		}

		
	}

}
