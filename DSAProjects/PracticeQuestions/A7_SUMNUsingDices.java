package PracticeQuestions;

public class A7_SUMNUsingDices {
	// no of ways sum can be obtained using dices.
	public static void main(String... strings) {
		int n = 4;
		System.out.println(recursiveSol(n));

		System.out.println(dpSol(n));
	}

	private static int dpSol(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= 6; j++) {
				if(j>i) {
					break;
				}
				dp[i] = dp[i] + dp[i - j];
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
		for (int i = 1; i <= 6; i++) {
			ans = ans + recursiveSol(n - i);
		}

		return ans;

	}
}
