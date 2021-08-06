package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A4_DepthFirstSearch {

	public static void main(String...strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();
		int s = 0;// source.
		dfsTraversal(adj, adj.size(), s);

	}

	
	//O(v+E)
	private static void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int size, int s) {

		boolean visited[] = new boolean[size + 1];
		dfs(adj,s,visited);
	
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s+" ");
		for (int k : adj.get(s)) {
			if (!visited[k]) {
				visited[k] = true;
				dfs(adj,k,visited);
			}
		}
		
		
	}


	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 7;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 4, 5);
		addEdge(adj, 4, 6);
		addEdge(adj, 5, 6);
		
		
		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
