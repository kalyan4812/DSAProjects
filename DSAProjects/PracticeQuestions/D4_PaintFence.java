package PracticeQuestions;

import java.util.Scanner;

public class D4_PaintFence {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		long ans = fun(n, k);
		System.out.println(ans);
	}

	static long mod = 1000000000 + 7;

	static long fun(int n, int k) {
		long dp[] = new long[n + 1];
		dp[0] = 0;

		if (n >= 1)
			dp[1] = k % mod;
		if (n >= 2)
			dp[2] = (k * k) % mod;

		if (n >= 3) {
			dp[3] = (k * (dp[2] % mod) - k) % mod;
		}

		for (int i = 4; i <= n; i++) {
			dp[i] = k * (dp[i - 1]) - (k - 1) * (dp[i - 3]);
			dp[i] = dp[i] % mod;
			if (dp[i] < 0) {

				dp[i] = (dp[i] + mod) % mod;
			}

			dp[i] = dp[i] % mod;
		}

		return dp[n] % mod;

	}
}
