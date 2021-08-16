package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A8_TopologicalSort {
	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		topologicalSortUsingDfs(adj);
		topologicalSortUsingBfs(adj, adj.size());

	}

//-----------------------------------------------------------------------DFS--------------------------------------------
	// O(V+E),O(V)-space.
	private static void topologicalSortUsingDfs(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();

		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				sortUsingDfs(adj, visited, stack, i);
			}
		}
		while (stack.empty() == false) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
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

//-----------------------------------------BFS APPROACH USING KAHNS ALGORITHM ------------------------------------------------------------

// O(V+E),O(V),work only for directed acyclic graph.
	private static boolean topologicalSortUsingBfs(ArrayList<ArrayList<Integer>> adj, int size) {
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (sortUsingBfs(adj, i, visited)) {
					return true;
				}

			}
		}
		return false;
	}

	private static boolean sortUsingBfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		int V = adj.size();

		// array to store in degrees.
		int[] in_degree = new int[V];

		// add in degrees.
		for (int u = 0; u < V; u++) {
			for (int v : adj.get(u)) {
				in_degree[v]++;
			}
		}

		// adding vertices with 0 in degrees into queue.
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (in_degree[i] == 0) {
				q.add(i);
			}
		}

		ArrayList<Integer> al = new ArrayList<>();
		int cnt = 0;

		while (!q.isEmpty()) {

			// Extract front of queue (or perform dequeue)

			int u = q.poll();
			al.add(u);
			// Iterate through all its neighboring nodes
			// of dequeued node u and decrease their in-degree
			// by 1
			for (int itr : adj.get(u)) {
				visited[itr] = true;
				in_degree[itr]--;
				if (in_degree[itr] == 0) {
					q.add(itr);
				}
			}
			cnt++;
		}

		for (int p : al) {
			System.out.print(p + " ");
		}
		return (cnt != V);
	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 4;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 2);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);

	}
}
