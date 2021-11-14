package GraphProblems;

import java.util.ArrayList;

public class A6_MaxNonAdajacentNodesSum {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();
		int w[] = {};
		boolean vis[] = new boolean[adj.size() + 2];
		int ans = Math.max(func(0, 0, w, adj, vis), func(0, 1, w, adj, vis));
		System.out.println(ans);
	}

	private static int func(int node, int taken, int[] w, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

		int ans = 0;
		vis[node] = true;
		if (taken == 1) {
			ans = w[node];
		}

		for (int k: adj.get(node)) {
			if (!vis[k]) {
				if (taken == 1)
					ans = ans + func(k, 1 - taken, w, adj, vis);
				else
					ans = ans + Math.max(func(k, 0, w, adj, vis),
							func(k, 1, w, adj, vis));
			}
		}

		return ans;

	}

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 1, 2);
		addEdge(adj, 2, 4);
		addEdge(adj, 4, 3);
		addEdge(adj, 1, 3);

		return adj;

	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
