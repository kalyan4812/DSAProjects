package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A6_DetectCycleInGraph {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		boolean b = detectUsingDfs(adj, adj.size());
		System.out.println(b);

		boolean d = detectUsingBfs(adj, adj.size());
		System.out.println(d);

	}
//------------------------------------------------------------------------BFS------------------------------------------------------------
	//O(V+E)
	private static boolean detectUsingBfs(ArrayList<ArrayList<Integer>> adj, int size) {
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (checkUsingBfs(adj, i, visited)) {
					return true;
				}

			}
		}
		return false;
	}

	private static boolean checkUsingBfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		int parent[] = new int[adj.size()];
		Arrays.fill(parent, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			int u = q.poll();

			for (int k : adj.get(u)) {
				if (!visited[k]) {
					visited[k] = true;
					q.add(k);
					parent[k] = u;
				} else if (parent[u] != k)
					return true;
			}

		}

		return false;
	}

//------------------------------------------------------------------ DFS------------------------------------------------------------------
	// O(v+e)
	private static boolean detectUsingDfs(ArrayList<ArrayList<Integer>> adj, int size) {
		boolean visited[] = new boolean[size + 1];

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (checkUsingDfs(adj, visited, i, -1)) {
					return true;
				}

			}
		}
		return false;

	}

	private static boolean checkUsingDfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, int parent) {
		visited[s] = true;

		for (int k : adj.get(s)) {
			if (!visited[k]) {
				if (checkUsingDfs(adj, visited, k, s)) {
					return true;
				} else if (k != parent) {
					return true;
				}
			}

		}
		return false;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 3);
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
