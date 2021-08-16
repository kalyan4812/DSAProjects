package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A9_ShortestPathInDAG {

	public static void main(String... strings) {

		ArrayList<ArrayList<Node>> adj = setUpGraph();

		int s = 0; // source.
		bfsTraversal(adj, adj.size(), s);
		System.out.println();

		System.out.println("Topo Sort");
		Stack<Integer> tops = topologicalSortUsingDfs(adj);

		System.out.println("Shortest Path");

		shortestPath(tops, adj.size(), s, adj);
	}

	//O(V+E)
	private static void shortestPath(Stack<Integer> tops, int v, int s, ArrayList<ArrayList<Node>> adj) {
		int dist[] = new int[v];

		for (int i = 0; i < v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;

		while (!tops.isEmpty()) {
			int val = tops.pop();

			// if the node has been reached previously.
			if (dist[val] != Integer.MAX_VALUE) {

				for (Node k : adj.get(val)) {
					if (dist[val] + k.weight < dist[k.val]) {
						dist[k.val] = dist[val] + k.weight;
					}
				}
			}
		}

		for (int k : dist) {
			if (k == Integer.MAX_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(k + " ");
			}
		}

	}

//----------------------------------------------topological sort--------------------------------------------------------------------

	// O(V+E),O(V)-space.
	private static Stack<Integer> topologicalSortUsingDfs(ArrayList<ArrayList<Node>> adj) {
		int size = adj.size();

		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				sortUsingDfs(adj, visited, stack, i);
			}
		}
		ArrayList<Integer> res = new ArrayList<>();

		return stack;

	}

	private static void sortUsingDfs(ArrayList<ArrayList<Node>> adj, boolean[] visited, Stack<Integer> stack, int s) {
		visited[s] = true;

		for (Node k : adj.get(s)) {
			if (!visited[k.val]) {
				visited[k.val] = true;
				sortUsingDfs(adj, visited, stack, k.val);
			}
		}
		stack.push(s);
	}

//------------------------------------------------------------------------------------------------------------------------------------------
	// O(v+E)
	private static void bfsTraversal(ArrayList<ArrayList<Node>> adj, int size, int s) {

		boolean visited[] = new boolean[size + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u + " ");
			for (Node k : adj.get(u)) {
				if (!visited[k.val]) {
					visited[k.val] = true;
					q.add(k.val);
				}
			}
		}
	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Node>> setUpGraph() {
		int vertices = 6;

		ArrayList<ArrayList<Node>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Node>());
		}

		addEdge(adj, 0, 1, 2);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 2, 3, 6);
		addEdge(adj, 0, 4, 1);
		addEdge(adj, 4, 2, 2);
		addEdge(adj, 4, 5, 4);
		addEdge(adj, 5, 3, 1);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {

		adj.get(u).add(new Node(v, w));

	}

	static class Node {
		int val;
		int weight;

		Node(int val, int weight) {
			this.val = val;
			this.weight = weight;
		}
	}
}
