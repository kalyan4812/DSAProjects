package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class B8_ArticulationPoint { // or cut vertices.

	// point/ node if we remove them the graph will be broken into two/more
	// components.

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		articulationPoint(adj, 5);
		System.out.println();
		articulationPointOtherway(adj, 5);

	}

	// O(V+E),O(V+E)
	private static void articulationPoint(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean visited[] = new boolean[v + 1];
		int dis[] = new int[v + 1];
		int low[] = new int[v + 1];
		int isArt[] = new int[v];

		int timer = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, -1, visited, dis, low, adj, timer, isArt);
			}
		}

		for (int i = 0; i < v; i++) {
			if (isArt[i] == 1) {
				System.out.print(i+"  ");
			}
		}
		

	}

	private static void dfs(int s, int parent, boolean[] visited, int[] dis, int[] low,
			ArrayList<ArrayList<Integer>> adj, int timer, int[] isArt) {
		visited[s] = true;
		dis[s] = low[s] = timer++;
		int child = 0;
		for (int k : adj.get(s)) {
			if (k == parent) {
				continue;
			}
			if (!visited[k]) {
				dfs(k, s, visited, dis, low, adj, timer, isArt);
				low[s] = Math.min(low[s], low[k]);
				if (low[k] >= dis[s] && parent != -1) {
					isArt[s] = 1;
				}
				child++;
			} else {
				low[s] = Math.min(low[s], dis[k]);
			}
		}
		if (parent == -1 && child > 1) {
			isArt[s] = 1;
		}

	}

//------------------------------------------------------------------------------------------------------------------------------------------------
	static int parent[];
	static int disc[];
	static int low[];
	static boolean vis[];
	static boolean ap[];
	static int time;

	private static void articulationPointOtherway(ArrayList<ArrayList<Integer>> adj, int n) {
		parent = new int[n];
		disc = new int[n];
		low = new int[n];
		time = 0;
		vis = new boolean[n];
		ap = new boolean[n];

		parent[0] = -1;

		dfs(0, adj);

		int ans = 0;

		for (boolean b : ap) {
			if (b) {
				ans++;
			}
		}

		System.out.println("total : "+ans);
	}

	public static void dfs(int u, ArrayList<ArrayList<Integer>> al) {
		disc[u] = low[u] = time;
		time++;
		int count = 0;
		vis[u] = true;

		for (int nbr : al.get(u)) {

			if (parent[u] == nbr) {
				continue;
			} else if (vis[nbr]) {
				low[u] = Math.min(low[u], disc[nbr]);
			} else {
				parent[nbr] = u;
				count++;
				dfs(nbr, al);

				low[u] = Math.min(low[u], low[nbr]);

				if (parent[u] == -1) {
					if (count >= 2) {
						ap[u] = true;
					}
				} else {
					if (low[nbr] >= disc[u]) {
						ap[u] = true;
					}
				}
			}

		}

	}

//----------------------------------------------------------------------------------------------------------------	
	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 0);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 1, 2);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
