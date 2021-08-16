package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C6_BipartiteGraph {

	// the graph that can be colored using two colors such that adjacent nodes have
	// different color.

	// idea: graph which does not have odd length cycle.

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		boolean b = checkBipartiteUsingBfs(adj, 4);
		System.out.println(b);

		boolean k = checkBipartiteUsingDfs(adj, 4);
		System.out.print(k);

	}
//-------------------------------------------------------DFS APPROACH------------------------------------------
	//O(V+E)
	private static boolean checkBipartiteUsingDfs(ArrayList<ArrayList<Integer>> adj, int size) {
		int color[] = new int[size];
		Arrays.fill(color, -1);

		for (int i = 0; i < size; i++) {
			if (color[i] == -1) {
				boolean b = dfsTraversal(adj, i, color);

				if (!b) {

					return false;
				}

			}
		}
		return true;
	}

	private static boolean dfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, int[] color) {
		if (color[s] == -1)
			color[s] = 1;

		for (int k : adj.get(s)) {
			if (color[k] == -1) {
				color[k] = 1 - color[s];
				if (!dfsTraversal(adj, k, color)) {
					return false;
				}
			} else if (color[k] == color[s]) {

				return false;
			}
		}
		return true;
	}

//--------------------------------------------------------------------BFS APPROACH---------------------------------------------------------------	
	// O(v+E)
	private static boolean checkBipartiteUsingBfs(ArrayList<ArrayList<Integer>> adj, int size) {

		int color[] = new int[size];
		Arrays.fill(color, -1);

		for (int i = 0; i < size; i++) {
			if (color[i] == -1) {
				boolean b = bfsTraversal(adj, i, color);

				if (!b) {

					return false;
				}

			}
		}
		return true;
	}

	private static boolean bfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, int[] color) {

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		color[s] = 1;

		while (!q.isEmpty()) {
			int u = q.poll();

			for (int k : adj.get(u)) {
				if (color[k] == -1) {
					color[k] = 1 - color[u];
					q.add(k);
				} else if (color[k] == color[u]) {

					return false;
				}
			}
		}
		return true;
	}

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 4;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 3);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
