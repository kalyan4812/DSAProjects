package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A2_BreadthFirstSearch {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();
		int s = 0;// source.
		bfsTraversal(adj, adj.size(), s);

	}

	
	//O(v+E)
	private static void bfsTraversal(ArrayList<ArrayList<Integer>> adj, int size, int s) {

		boolean visited[] = new boolean[size + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");
			for (int k : adj.get(u)) {
				if (!visited[k]) {
					visited[k] = true;
					q.add(k);
				}
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		
		
		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
