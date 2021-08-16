package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class C4_RottenOranges { // BFS.

	// 0-wall
	// 1- fresh orange
	// 2-rotten orange

	// minimum time for all oranges to get rotten.
	// 2 can rotten 1 up in left,right,up,down.

	static int time = 0;
	static int rottenoranges = 0;

	public static void main(String... strings) {

		int a[][] = { { 0, 0, 0, 1 }, { 2, 1, 1, 1 }, { 2, 0, 2, 0 }, { 1, 1, 0, 2 } };
		int r = a.length;
		int c = a[0].length;

		timeToGetRotten(a, r, c);

	}

	//O(m*N*4) ,O(n*m)-space.
	private static void timeToGetRotten(int[][] a, int r, int c) {

		int freshorange = 0;
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == 2) {
					q.add(new Pair(i, j));
				} else if (a[i][j] == 1) {
					freshorange++;
				}
			}
		}
		if (freshorange == 0) {
			System.out.print(0);
			return;
		}

		while (!q.isEmpty()) {
			int count = q.size();
			rottenoranges = rottenoranges + q.size();
			for (int k = 0; k < count; k++) {
				Pair p = q.poll();
				pushNeighbours(p, a, q, r, c);
			}
			if (q.size() > 0) {
				time++;

			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == 1) {
					System.out.print("-1");
					return;
				}
			}
		}
		System.out.println("Min time :" + time);
		System.out.println("Rotten oranges :" + rottenoranges);
	}

	private static void pushNeighbours(Pair p, int[][] a, Queue<Pair> q, int r, int c) {
		int x = p.x;
		int y = p.y;

		int yc[] = { -1, 1, 0, 0 };
		int xc[] = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			if (x + xc[i] < 0 || x + xc[i] >= r || y + yc[i] < 0 || y + yc[i] >= c || a[x + xc[i]][y + yc[i]] != 1) {
				continue;
			}
			a[x + xc[i]][y + yc[i]] = 2;
			q.add(new Pair(x + xc[i], y + yc[i]));

		}
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
