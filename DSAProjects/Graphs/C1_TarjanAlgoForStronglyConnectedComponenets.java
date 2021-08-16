package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class C1_TarjanAlgoForStronglyConnectedComponenets {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		tarjanAlgo(adj, 5);

	}

	//O(V+E)
	private static void tarjanAlgo(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean recst[] = new boolean[v + 1];
		int dis[] = new int[v + 1];
		int low[] = new int[v + 1];
		Arrays.fill(dis, -1);
		Arrays.fill(low, -1);

		int timer = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < v; i++) {
			if (dis[i] == -1) {
				dfs(i, st, recst, dis, low, adj, timer);
			}
		}
	}

	private static void dfs(int s, Stack<Integer> st, boolean[] recst, int[] dis, int[] low,
			ArrayList<ArrayList<Integer>> adj, int timer) {
		recst[s] = true;
		dis[s] = low[s] = timer++;
		st.push(s);

		for (int k : adj.get(s)) {

			if (dis[k] == -1) {
				dfs(k, st, recst, dis, low, adj, timer);
				low[s] = Math.min(low[s], low[k]);

			} else if (recst[k]) {
				low[s] = Math.min(low[s], dis[k]);
			}
		}

		int w = -1;
		if (low[s] == dis[s]) {
			while (w != s) {
				w = (int) st.pop();
				System.out.print(w + " ");
				recst[w] = false;
			}
			System.out.println();
		}

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
