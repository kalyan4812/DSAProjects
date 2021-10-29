package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import Graphs.B1_ShortestPathInGraphUsingDijkstra.Node;

public class B2_ShortestPathUsingBellmanFord {

	// works for negative edges.

	public static void main(String... strings) {

		ArrayList<Node> adj = setUpGraph();

		shortestPath(adj, 0);
		System.out.println();
		shortestPathOtherWay(adj, 0);

	}

	// O(VE)
	private static void shortestPath(ArrayList<Node> adj, int s) {
		int v = 4;
		int dist[] = new int[v]; // no of vertices should be passed not v.
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;

		int parent[] = new int[v]; // for printing negative weight cycle if exists.
		Arrays.fill(parent, -1);

		for (int i = 0; i < v - 1; i++) {
			for (Node node : adj) {
				if (dist[node.u] + node.weight < dist[node.v]) {
					dist[node.v] = dist[node.u] + node.weight;
					parent[node.v] = node.u;
				}
			}
		}

		boolean hasNegativeCycle = false;
		int z = -1;
		for (Node node : adj) {
			if (dist[node.u] + node.weight < dist[node.v]) {
				hasNegativeCycle = true;
				System.out.println("Graph has negative cycle");
				z = node.v;
				break;
			}
		}
		if (z != -1) {
		/*	for (int i = 0; i < v; i++)
				z = parent[z];*/

			// To store the cycle vertex
			ArrayList<Integer> cycle = new ArrayList<>();
			for (int i = z;; i = parent[i]) {

				if (i == z && cycle.size() > 1)
					break;

				cycle.add(i);
			}

			Collections.reverse(cycle);
			System.out.println("Negative cycle : " + cycle);

		}

		if (!hasNegativeCycle) {
			for (int k : dist) {

				System.out.print(k + " ");

			}
		}

	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static void shortestPathOtherWay(ArrayList<Node> adj, int s) {
		int m = adj.size();
		int n = m;
		int path[] = new int[n];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[0] = 0;

		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < m; j++) {
				int u = adj.get(j).u;
				int v = adj.get(j).v;
				int wt = adj.get(j).weight;

				if (path[u] == Integer.MAX_VALUE) {
					continue;
				}

				if (path[u] + wt < path[v]) {
					path[v] = path[u] + wt;
				}

			}
		}

		for (int i = 0; i < n; i++) {
			if (path[i] != Integer.MAX_VALUE)
				System.out.print(path[i] + " ");
			else
				System.out.print("1000000000 ");
		}
	}

//-------------------------------------------------------------------------------------------------------	

	private static ArrayList<Node> setUpGraph() {
		int vertices = 4;

		ArrayList<Node> adj = new ArrayList<>(vertices); // edge list no need of adj list.

		addEdge(adj, 0, 1, 1);
		addEdge(adj, 1, 3, 2);
		addEdge(adj, 0, 2, 4);
		addEdge(adj, 2, 1, -3);
		addEdge(adj, 3, 2, -3);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<Node> adj, int u, int v, int w) {

		adj.add(new Node(u, v, w));
		// adj.add(new Node(u,v, w));

	}

	static class Node {
		int u;
		int v;
		int weight;

		Node() {

		}

		Node(int u, int val, int weight) {
			this.u = u;
			this.v = val;
			this.weight = weight;
		}

	}

}
