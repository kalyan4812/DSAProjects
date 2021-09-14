package DPProblems;

import java.util.Arrays;
import java.util.Scanner;

public class B9_Matching {

	/*
	 * There are N men and N women, both numbered 1,2,…,N.
	 * 
	 * For each i,j (1≤i,j≤N), the compatibility of Man i and Woman j is given as an
	 * integer ai,j. If a i,j=1, Man i and Woman j are compatible; if ai,j=0, they
	 * are not.
	 * 
	 * Taro is trying to make N pairs, each consisting of a man and a woman who are
	 * compatible. Here, each man and each woman must belong to exactly one pair.
	 * 
	 * Find the number of ways in which Taro can make N pairs, modulo 10 9+7.
	 */

	// idea:

	// f(i,x)-number of ways to pair men from (i,n) with women left in set x.
	// f(i,x)=f(i+1,X-{x}),x is from array.

	static int mod = (int) Math.pow(10, 9) + 7;

	static int db[][];

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		db = new int[22][(1 << 22)];
		for (int x[] : db) {
			Arrays.fill(x, -1);
		}
		int ans = fun(a, 1, (1 << n) - 1, n);
		System.out.println(ans);
	}

	private static int fun(int[][] a, int i, int mask, int n) {
		if (i == n + 1) {
			if (mask == 0) {
				return 1;
			}
		}
		if (db[i][mask] != -1) {
			return db[i][mask];
		}
		int ans = 0;
		for (int j = 0; j < n; j++) {
			boolean avaialble = (((1 << j) & (mask)) == 0) ? false : true;
			if (avaialble && a[i][j + 1] == 1) {
				ans = ans + fun(a, i + 1, mask ^ (1 << j), n); // unset the bit.
				ans = ans % mod;
			}
		}
		db[i][mask] = ans;
		return ans;
	}
}
