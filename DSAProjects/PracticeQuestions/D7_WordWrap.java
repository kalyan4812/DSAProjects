package PracticeQuestions;

import java.util.Arrays;

public class D7_WordWrap {
	
	public static void main(String...strings) {
		
		int a[]={3,2,2,5};
		int k=6;
		int ans=solveWordWrap(a,k);
		System.out.println(ans);
	}

	public static int solveWordWrap(int[] a, int k) {

		int n = a.length;
		db = new int[n + 1][n + 1];
		for (int y[] : db) {
			Arrays.fill(y, -1);
		}
		int ans = helper(a, n, 0, n - 1, k, n);
		return ans;

	}
	/*
	 * 5 
	 * 6 6 7 4 4
	 * 9
	 */

	static int db[][];

	static int helper(int a[], int n, int i, int j, int z, int r) {
		if (i > j) {
			return 0;
		}
		if (db[i][r] != -1) {
			return db[i][r];
		}

		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			int cost = 0;
			int b = 0;
			for (int p = i; p <= k; p++) {
				cost = cost + a[p];
				b++;
			}

			if (b > 0) {
				cost = cost + b - 1;
			}

			int tempans = Integer.MAX_VALUE;
			if (cost <= z && b != r) {

				tempans = (z - cost) * (z - cost);
				int x = ((db[k + 1][r - b] != -1) ? db[k + 1][r - b] : helper(a, n, k + 1, j, z, r - b));
				if (x != Integer.MAX_VALUE) {
					tempans += x;
					min = Math.min(min, tempans);
				}
				//System.out.println(tempans);

			}
			min = Math.min(min, tempans);
			db[i][r] = min;

		}
		return min;
	}
}
