package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class C7_HamiltonianPath {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		dfsTraversal(adj, 6);

	}

	// O(v+E)
	private static void dfsTraversal(ArrayList<ArrayList<Integer>> adj, int size) {

		HashSet<Integer> hs=new HashSet<>();

		for (int i = 1; i < size; i++) {

		   hs.clear();

			String path = i + "";

			boolean b = dfs(adj, i, hs, size, path,i);
			System.out.println();

			if (b) {
				System.out.println("Yes it has hamiltonian path");

			}

		}

		// * means cycle,. means path
	}

	// backtracking. 
	// osrc=original source.
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, HashSet<Integer> visited, int n, String path,int osrc) {

		if (visited.size() == n - 1) {
			System.out.print(path);
			boolean iscycle=false;
			for(int p:adj.get(s)) {
				if(p==osrc) {
					iscycle=true;
					break;
				}
			}
			if(iscycle) {
				System.out.println("*");
			}
			else {
				System.out.println(".");
			}
			return true;
		}
		visited.add(s);

		for (int k : adj.get(s)) {
			if (!visited.contains(k)) {

				if (dfs(adj, k, visited, n, path + k,osrc)) {
					return true;
				}

			}
		}

		visited.remove(s);

		return false;

	}

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 7;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 6);
		addEdge(adj, 6, 1);
		addEdge(adj, 3, 5);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
