package Graphs;

import java.util.LinkedList;
import java.util.Queue;

import Graphs.C4_RottenOranges.Pair;

public class C5_StepsByKnight { // horse in chess.
	// minimum steps to reach from source to destination.

	public static void main(String... strings) {

		int knightPos[] = { 1, 1 };
		int targetPos[] = { 29,29 };
		int N = 30;
		int k = minStepToReachTarget(knightPos, targetPos, N);
		System.out.println("Min steps : " + k);
	}

	private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
		int count = 0, steps = 0;
		int s1 = knightPos[0] - 1;
		int s2 = knightPos[1] - 1;
		int d1 = targetPos[0] - 1;
		int d2 = targetPos[1] - 1;

		if (s1 == d1 && s2 == d2) {
			return 0;
		}

		Queue<Pair> q = new LinkedList<>();
		boolean vis[][] = new boolean[n][n];
		q.add(new Pair(s1, s2));
		vis[s1][s2] = true;

		boolean flag = false;
		while (!q.isEmpty()) {
			count = q.size();
			steps++;
			for (int i = 0; i < count; i++) {
				Pair p = q.poll();
				boolean b=exploreNeighbours(p, q, d1, d2, vis, flag, n);
				if (b) {
					return steps;
				}
			}

		}
		if(flag) {
			return steps;
		}
		  return -1;

	}

	private static boolean exploreNeighbours(Pair p, Queue<Pair> q, int d1, int d2, boolean[][] vis, boolean flag, int n) {
		int x = p.x;
		int y = p.y;

		int cx[]={-1,-1,1,1,2,2,-2,-2};
        int cy[]={2,-2,2,-2,1,-1,1,-1};

		for (int i = 0; i < 8; i++) {
			if (x + cx[i] < 0 || x + cx[i] >= n || y + cy[i] < 0 || y + cy[i] >= n || vis[x + cx[i]][y + cy[i]]) {
				continue;
			}
			if (x + cx[i] == d1 && y + cy[i] == d2) {
				flag = true;
				return flag;
			}
			q.add(new Pair(x + cx[i], y + cy[i]));
			vis[x + cx[i]][y + cy[i]] = true;
			
		}
		return false;
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
