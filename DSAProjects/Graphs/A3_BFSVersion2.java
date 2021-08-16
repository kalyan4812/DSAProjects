package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A3_BFSVersion2 {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();
		// No source given
		bfsDisconnectedTraversal(adj, adj.size());

	}

	// O(v+2E) v because in case if every component/ node is disconnected.
	private static void bfsDisconnectedTraversal(ArrayList<ArrayList<Integer>> adj, int size) {
		int count = 0;
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				bfsTraversal(adj, i, visited);
				count++;
			}
		}
		System.out.println();
		System.out.println("No of components/Islands : " + count);
	}

	private static void bfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]) {

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
