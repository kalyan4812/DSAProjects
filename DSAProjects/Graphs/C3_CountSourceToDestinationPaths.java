package Graphs;

import java.util.ArrayList;

public class C3_CountSourceToDestinationPaths {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		dfsTraversal(adj, 4);
		System.out.println();

	}
	
	static int count=0;

	// O(v+2E)
	private static void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int size) {

		boolean visited[] = new boolean[size + 1];

		/*for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				

			}
		}*/
		dfs(adj, 0,3, visited);
		System.out.println("paths :"+count);

	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, int dest, boolean[] visited) {
		
		
		if(s==dest) {
			count++;
			System.out.println(s + " ");
			return;
		}
		visited[s] = true;
		System.out.print(s + " ");
		
		
		
		for (int k : adj.get(s)) {
			if (!visited[k]) {
				//visited[k] = true;
				dfs(adj, k, dest,visited);
			}
		}
		System.out.println();
		visited[s]=false;

	}

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 4;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 0, 3);
		addEdge(adj, 0, 2);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);

	}
}
