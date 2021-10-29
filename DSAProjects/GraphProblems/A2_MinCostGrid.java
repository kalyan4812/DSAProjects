package GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class A2_MinCostGrid {

	// there is a grid with letters U,L,R,D up,left,right,down.you can change any
	// character at a cost of
	// 1 unit.find minimum cost to reach from top left to bottom right.

	public static void main(String... strings) {
		char c[][] = { { 'R', 'R', 'L' }, { 'D', 'R', 'U' }, { 'D', 'U', 'R' } };

		int a[][] = new int[c.length][c[0].length];
		int n = c.length;
		int m = c[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (c[i][j] == 'R') {
					a[i][j] = 2;
				} else if (c[i][j] == 'L') {
					a[i][j] = 1;
				} else if (c[i][j] == 'U') {
					a[i][j] = 3;
				} else {
					a[i][j] = 4;
				}
			}
		}

		ArrayList<ArrayList<Pair>> adj = setUpGraph(a);

		int cost = zeroOneBfs(adj, 0, (n - 1) * n + m - 1, n, m);

		System.out.println(cost);

	}

	private static int zeroOneBfs(ArrayList<ArrayList<Pair>> adj, int src, int dest, int n, int m) {

		int dist[] = new int[n * n + m];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Deque<Integer> dq = new LinkedList<>();
		dist[src] = 0;
		dq.add(src);

		while (!dq.isEmpty()) {

			int node = dq.pollFirst();

			for (Pair p : adj.get(node)) {

				if (dist[p.val] > dist[node] + p.wt) {
					dist[p.val] = dist[node] + p.wt;

					if (p.wt == 0) {
						dq.addFirst(p.val);
					} else {
						dq.addLast(p.val);
					}
				}

			}

		}

		return dist[dest];
	}

	private static ArrayList<ArrayList<Pair>> setUpGraph(int[][] c) {
		int n = c.length;
		int m = c[0].length;

		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

		for (int i = 0; i < n * n + m; i++) {
			adj.add(new ArrayList<Pair>());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				int nodeVal = n * i + j;

				for (int d = 1; d <= 4; d++) {
					int next = nextNode(i, j, d, n, m);

					if (next != -1) {
						if (d == c[i][j]) {
							adj.get(nodeVal).add(new Pair(next, 0));
						} else {

							adj.get(nodeVal).add(new Pair(next, 1));

						}
					}
				}

			}
		}

		return adj;
	}

	private static int nextNode(int i, int j, int d, int n, int m) {
		if (d == 1) {
			// left
			j--;

		} else if (d == 2) {
			// right
			j++;
		} else if (d == 3) {
			// up
			i--;
		} else {
			// down
			i++;
		}

		if (i < 0 || j < 0 || j >= m || i >= n) {
			return -1;
		}

		return i * n + j;
	}

	static class Pair {
		int val, wt;

		Pair(int val, int wt) {
			this.val = val;
			this.wt = wt;
		}
	}
}
