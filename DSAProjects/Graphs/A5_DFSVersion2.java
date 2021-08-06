package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A5_DFSVersion2 {

	

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();
		
		dfsTraversal(adj, adj.size());

	}

	// O(v+2E)
	private static void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int size) {

		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				dfs(adj, i, visited);
				
			}
		}

	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		for (int k : adj.get(s)) {
			if (!visited[k]) {
				visited[k] = true;
				dfs(adj, k, visited);
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
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 3);

		// disconnected graphs.
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
