package PracticeQuestions;

public class B7_CountBSTWithNkeys {

	public static void main(String... strings) {
		int n = 5;
		System.out.println(recursiveSol(n));

		System.out.println(dpSol(n));

		/// or using catalan number formula : 1/n+1 *(2nCn).
	}

	
	//O(n2)
	private static int dpSol(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {

			for (int j = 0; j < i; j++) {
				dp[i] = dp[i] + (dp[j] * dp[i - j - 1]);
			}
		}
		return dp[n];
	}

	private static int recursiveSol(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = ans + recursiveSol(i) * recursiveSol(n - i - 1);
		}

		return ans;
	}
}
