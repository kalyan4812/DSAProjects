package DynamicProgramming;

import java.util.Arrays;

public class J1_DPwithBits {

	// there are n workers,n jobs and one-one relation among them.
	// n*n cost matrix represents cost required for i th person to do j th job.
	// allocate jobs such that cost is minimum.
	public static void main(String... strings) {
		int cost[][] = { { 3, 2, 7, 4 }, { 5, 6, 1, 2 }, { 5, 3, 1, 5 }, { 4, 6, 11, 3 } }; // n<=20.

		int ans = fun(cost, cost.length);
		System.out.println(ans);

	}

	private static int fun(int[][] cost, int n) {
		int dp[] = new int[(1 << n)];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int mask = 0; mask < (1 << n); mask++) {
			int worker = numberOfSetBits(mask);

			// allocate job to worker.
			for (int i = 0; i < n; i++) {
				if (!checkIfIthBitIsSet(mask, i)) {

					int c = mask | (1 << i); // setting the ith bit.
					dp[c] = Math.min(dp[c], dp[mask] + cost[worker][i]);
				}
			}
		}

		return dp[(1 << n) - 1];
	}

	
	private static boolean checkIfIthBitIsSet(int n, int k) {
		if ((n & (1 << (k))) == 0) {
			return false;
		} else {
			return true;
		}

	}

	private static int numberOfSetBits(int n) {
		int res = 0;
		while (n > 0) {
			n = (n & (n - 1));// remove last set bit.
			res++;
		}
		return res;
	}
}
