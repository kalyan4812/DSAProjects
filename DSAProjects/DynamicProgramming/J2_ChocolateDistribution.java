package DynamicProgramming;

public class J2_ChocolateDistribution {

	// a[i][j]=0,i th kid don't like j th chocolate and vice versa.
	// number of ways you can distribute chocolates.

	public static void main(String... strings) {
		int a[][] = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 1, 0, 1, 0 } }; // n<=20.

		int ans = fun(a, a.length); // n<=22.
		System.out.println(ans);

	}

	// 1100 Represents chocolate1,2 are allocated.
	// dp[i] represents total number of ways.
	private static int fun(int[][] a, int n) {
		int dp[] = new int[(1 << n)];
		dp[(1 << n) - 1] = 1;
		for (int mask = (1 << n) - 2; mask >= 0; mask--) {
			int k = numberOfSetBits(mask); // set bits. 

			// give chocolate to kth kid.
			for (int i = 0; i < n; i++) {
				if (a[k][i] == 1 && !checkIfIthBitIsSet(mask, i)) {

					dp[mask] += dp[mask | (1 << i)];
				}
			}
		}
		return dp[0];
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
