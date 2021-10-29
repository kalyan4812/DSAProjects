package GraphProblems;

import java.util.LinkedList;
import java.util.Queue;

public class A4_ShortestPathBetweenTwoCellsInMatrix {

	public static void main(String... args) {

		int a[][] = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

		int src[] = { 0, 0 };

		int dest[] = { 3, 4 };

		boolean vis[][] = new boolean[a.length][a[0].length];

		bfs(a, vis, src[0], src[1], dest[0], dest[1]);
	}

	static int x[] = { -1, 0, 0, 1 };
	static int y[] = { 0, -1, 1, 0 };

	// use bfs approach.
	public static void bfs(int a[][], boolean vis[][], int i, int j, int dx, int dy) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, j, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int ix = p.i;
			int jy = p.j;

			if (ix == dx && jy == dy) {
				System.out.println(p.lev);

				break;
			}

			if (vis[ix][jy]) {
				continue;
			}
			vis[ix][jy] = true;

			for (int d = 0; d < 4; d++) {

				if (ix + x[d] >= 0 && jy + y[d] >= 0 && ix + x[d] < a.length && jy + y[d] < a[0].length
						&& !vis[ix + x[d]][jy + y[d]] && a[ix + x[d]][jy + y[d]] == 1) {

					q.add(new Pair(ix + x[d], jy + y[d], p.lev + 1));
				}

			}

		}
		StringBuilder sb=new StringBuilder("123450");
		
		int ind=sb.indexOf("0");
		
		

	}

	private static class Pair {
		int i;
		int j, lev;

		Pair(int x, int y, int lev) {
			this.i = x;
			this.j = y;
			this.lev = lev;
		}
	}
//-----------------------------------------------------------------------------------------------------------------
	// other problem,where you have to upadte values to distance between cell and
	// nearest zero.
	
	// idea: instead of calling bfs from 1 to nearest 0,call bfs from 0 to 1.
	// same as rotten orange question whenever you hit one ,change it to corresponding distance it is from
	// zero.
	
	// change  all 1s to -1,so that we don't need a visted array.
	
	// multi source bfs(add all zeroes to queue first).
	// we are taaking help of previous bfs calls so time decreases.

	public static int[][] updateMatrix(int[][] a) {

		int n = a.length;
		int m = a[0].length;

		boolean vis[][] = new boolean[n][m];

		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0) {
					q.add(new Pair(i, j, 0));
				} else {
					a[i][j] = -1;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int ix = p.i;
			int jy = p.j;
			for (int d = 0; d < 4; d++) {

				if (ix + x[d] >= 0 && jy + y[d] >= 0 && ix + x[d] < a.length && jy + y[d] < a[0].length
						&& a[ix + x[d]][jy + y[d]] < 0) {
					q.add(new Pair(ix + x[d], jy + y[d], p.lev + 1));
					a[ix + x[d]][jy + y[d]] = p.lev + 1;
				}
			}

		}

		return a;

	}
}
