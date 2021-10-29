package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A3_ColoredShortestPath {

	// gievn a graph with n nodes and m edges,edge can be of either red or black
	// color.

	// given a src and destination,find shortest path such that it starts with red
	// edge and ends with blue edge.
	// you can swicth the color only once.that is from src to switch node one red
	// edge and from
	// switch node to dest all blue edges.

	// idea:
	// 1 : shortest path from src to x,with red edge O(V+E).

	// 2: shortest path from dest to x,having all blue edges. O(V+E).

	public static void main(String... strings) {
		ArrayList<ArrayList<Pair>> adj = setUpGraph();

		// src =1,dest=5.

		int[] p1 = shortestPath(adj, adj.size(), 1, 0); // src to x having red edge.

		int p2[] = shortestPath(adj, adj.size(), 5, 1); // dest to x having blue edges.

		int src = 1, dest = 5;
		int ans = Integer.MAX_VALUE;

		for (int k : p1) {
			System.out.print(k + " ");
		}
		System.out.println();
		for (int k : p2) {
			System.out.print(k + " ");
		}
		System.out.println();

		for (int i = 1; i <= adj.size(); i++) {
			if (i == src || i == dest || p1[i] == -1 || p2[i] == -1 || p2[dest] == -1 || p1[src]==-1) {
				continue;
			}
			ans = Math.min(ans, p1[i] + p2[i]);
		}
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);

	}

	private static int[] shortestPath(ArrayList<ArrayList<Pair>> adj, int n, int src, int col) {

		Queue<Integer> q = new LinkedList<>();
		
		int dist[] = new int[n + 1];
		Arrays.fill(dist, -1);

		q.add(src);
		dist[src] = 0;

		while (!q.isEmpty()) {

			int node = q.poll();

			for (Pair p : adj.get(node)) {

				if (dist[p.val] != -1) {

					continue;
				}
				if (p.wt != col) {
					continue;
				}
				q.add(p.val);

				dist[p.val] = dist[node] + 1;
			}

		}

		return dist;
	}

	private static ArrayList<ArrayList<Pair>> setUpGraph() {
		int vertices = 6;

		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		for (int i = 1; i <= vertices; i++) {
			adj.add(new ArrayList<Pair>());
		}

		addEdge(adj, 1, 2, 1);
		addEdge(adj, 2, 4, 1);
		addEdge(adj, 2, 3, 0);
		addEdge(adj, 1, 3, 0);
		addEdge(adj, 3, 5, 1);
		addEdge(adj, 4, 5, 0);
		addEdge(adj, 3, 4, 1);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int wt) {

		adj.get(u).add(new Pair(v, wt));
		adj.get(v).add(new Pair(u, wt));

	}

	static class Pair {
		int val, wt;

		Pair(int val, int wt) {
			this.val = val;
			this.wt = wt;
		}
	}
}
