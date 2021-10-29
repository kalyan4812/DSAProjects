package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class A1_ShortestPath {

	// given a source and destination ,find shortest path in unweighted graph.

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		ArrayList<Integer> path = shortestPath(0, 5, adj, adj.size());
		System.out.println(path); // 0 3 4 5

	}

	private static ArrayList<Integer> shortestPath(int src, int dest, ArrayList<ArrayList<Integer>> adj, int n) {

		boolean vis[] = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		vis[src] = true;

		int parent[] = new int[n];
		Arrays.fill(parent, -1);

		int dist[] = new int[n]; // stores shortest path from src to all other nodes.

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int neig : adj.get(node)) {
				if (!vis[neig]) {
					q.add(neig);
					vis[neig] = true;
					parent[neig] = node;
					dist[neig] = dist[node] + 1;
				}
			}
		}

		int temp = dest;
		ArrayList<Integer> res = new ArrayList<>();
		while (temp != -1) { // will stop,since parent of src is -1.
			res.add(temp);
			temp = parent[temp];
		}

		// in the above we added path dest to src,so we have to reverse the list.

		Collections.reverse(res);
		return res;
	}

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 7;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
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
