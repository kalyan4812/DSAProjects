package Graphs;

import java.util.ArrayList;

public class A1_RepresentationOfGraph {

	// Undirected-graph.
	public static void main(String... strings) {

		setUpGraph();
		
		

	}

	private static void setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		
		printTheGraph(adj);

	}

	
	//O(v^2)
	private static void printTheGraph(ArrayList<ArrayList<Integer>> adj) {
	
		for(int i=0;i<adj.size();i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(adj.get(i).get(j)+"  ");
			}
			System.out.println();
		}
		
	}

	//t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
