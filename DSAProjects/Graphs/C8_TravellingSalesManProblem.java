package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class C8_TravellingSalesManProblem {

	static int min_cost = Integer.MAX_VALUE;
	static ArrayList<String> minpath = new ArrayList<>();

	public static void main(String... strings) {
		int graph[][] = { { 0, 1, 2, 3 }, { 1, 0, 4, 2 }, { 1, 2, 0, 5 }, { 3, 4, 1, 0 } };
		int count = 0;

		int curr_cost = 0;
		HashSet<Integer> vis = new HashSet<>();
		String path = "0";
		travellingSalesProb(graph, vis, 0, count, curr_cost, 4, path);
		System.out.println(min_cost);
		System.out.println("Min path : " + minpath.toString());

		ArrayList<String> al = new ArrayList<>(Arrays.asList("1", "2", "3"));

		int k = travellingSalesProbUsinfDp(graph, 0, 3, path, al, al);
		System.out.println(k);

	}

	// O(2^n*n)
	private static int travellingSalesProbUsinfDp(int[][] g, int s, int n, String path, ArrayList<String> al,
			ArrayList<String> al2) {

		if (n == 0) {
			return g[s][0];
		}
		int res = Integer.MAX_VALUE;
		for (String i : al2) {
			al2 = new ArrayList<>(al);
			al2.remove(i);

			res = Math.min(res,
					g[s][Integer.valueOf(i)] + travellingSalesProbUsinfDp(g, Integer.valueOf(i), n - 1, path, al, al2));
		}
		return res;
	}

	// O(n-1!)
	private static void travellingSalesProb(int[][] g, HashSet<Integer> vis, int s, int count, int curr_cost, int n,
			String path) {

		if (vis.size() == n - 1) {
			if (g[s][0] != 0 && curr_cost + g[s][0] < min_cost) { // checking if g[s][0] has edge.
				min_cost = curr_cost + g[s][0];
				minpath.clear();
				minpath.add(path);
			}
			// make the node unvisited and return from function call
			vis.remove(s);

			return;
		}
		vis.add(s);
		for (int v = 0; v < n; v++) {

			if (g[s][v] != 0 && !vis.contains(v)) {

				travellingSalesProb(g, vis, v, count, curr_cost + g[s][v], n, path + v);
			}

		}

		vis.remove(s);

		return;
	}

}
