package PracticeQuestions;

public class A6_NCR {

	public static void main(String... strings) {

		int ans = nCr(4, 2);
		System.out.println(ans);
	}

	static int mod = 1000000000 + 7;

	static int nCr(int n, int r) {
		if (n < r)
			return 0;
		r = Math.min(r, n - r);

		int dp[] = new int[r + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--) {
				dp[j] = (dp[j - 1] + dp[j]) % mod;
			}
		}

		return dp[r];

	}
}
