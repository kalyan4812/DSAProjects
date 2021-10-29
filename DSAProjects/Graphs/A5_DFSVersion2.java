package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A5_DFSVersion2 {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		dfsTraversal(adj, adj.size());
		System.out.println();

		dfsTraversalIterative(adj, adj.size());
		System.out.println();

	}

	// O(v+2E)
	private static void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int size) {

		boolean visited[] = new boolean[size + 1];

		int count = 0;// no of connected components/islands.
		int lastdfs = 0;
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				dfs(adj, i, visited);
				count++;
				lastdfs = i;
			}
		}

		// other code not dfs
		getMotherVertex(adj, size, count, lastdfs);

	}

	private static void getMotherVertex(ArrayList<ArrayList<Integer>> adj, int size, int count, int lastdfs) {
		// other code for finding mother vertex:
		System.out.println("No of islands : " + count);

		boolean visit[] = new boolean[size + 1];
		dfs(adj, lastdfs, visit);
		for (boolean b : visit) {
			if (!b) {
				System.out.println("No Mother vertex ");
				return;
			}
		}
		System.out.println("Mother vertex : " + lastdfs);
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

	private static void dfsTraversalIterative(ArrayList<ArrayList<Integer>> adj, int vtces) {
		boolean vis[] = new boolean[vtces];
		for (int i = 0; i < vtces; i++) {

			if (!vis[i]) {

				Stack<Integer> st = new Stack<>();

				st.push(i);
				while (!st.isEmpty()) {

					int k = st.pop();
					if (vis[k]) {
						continue;
					}
					vis[k] = true;

					System.out.println(k);

					for (int e : adj.get(k)) {
						if (!vis[e]) {
							st.push(e);
						}
					}

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
