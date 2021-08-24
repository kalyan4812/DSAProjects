package PracticeQuestions;

public class A4_TailingProblem {
	// No of ways to tail a floor.
	public static void main(String... strings) {

		int ans = go(4);
		System.out.println(ans);
	}

	// O(N)
	private static int go(int n) {

		int dp[] = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
