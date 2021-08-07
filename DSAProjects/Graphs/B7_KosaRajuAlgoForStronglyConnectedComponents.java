package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

import Graphs.B1_ShortestPathInGraphUsingDijkstra.Node;

public class B7_KosaRajuAlgoForStronglyConnectedComponents {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		Stack<Integer> st = topologicalSortUsingDfs(adj);
		kosaRajuAlgo(adj, 5, st);

	}

	//O(V+E),o(v+E)
	private static void kosaRajuAlgo(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> st) {

		boolean visited[] = new boolean[v];

		// transpose graph =reverse edges.
		ArrayList<ArrayList<Integer>> tp = new ArrayList<>(v);

		for (int i = 0; i < v; i++) {
			tp.add(new ArrayList<Integer>());
		}

		for (int j = 0; j < v; j++) {

			for (int k : adj.get(j)) {
				tp.get(k).add(j);
			}
		}
		while (!st.isEmpty()) {
			int node = st.pop();
			if (!visited[node]) {
				System.out.print("SCC :");
				dfs(tp, node, visited);
				System.out.println();
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

//-----------------------------------------------------------------------DFS--------------------------------------------
	// O(V+E),O(V)-space.
	private static Stack<Integer> topologicalSortUsingDfs(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();

		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				sortUsingDfs(adj, visited, stack, i);
			}
		}
		return stack;
	}

	private static void sortUsingDfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack,
			int s) {
		visited[s] = true;

		for (int k : adj.get(s)) {
			if (!visited[k]) {
				visited[k] = true;
				sortUsingDfs(adj, visited, stack, k);
			}
		}
		stack.push(s);
	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 0);
		addEdge(adj, 1, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 1, 2);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);

	}
}
