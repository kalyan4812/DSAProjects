package PracticeQuestions;

import java.util.Arrays;

public class A8_RemovingDigits {

	// on each step you can subtract it from any one digit number appears in it.
	// minimum number of steps to reach 0.

	public static void main(String... strings) {
		int n = 144;

		System.out.println(recursiveSol(n));

		System.out.println(dpSol2(n));
	}

	private static int dpSol2(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= 9; i++) {
			dp[i] = 1;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 10; i <= n; i++) {
			String temp = Integer.toString(i);
			for (int j = 0; j < temp.length(); j++) {
				int k = temp.charAt(j) - '0';
				dp[i] = Math.min(1 + dp[i - k], dp[i]);
			}
		}
		return dp[n];
	}

	private static int recursiveSol(int n) {

		if (n <= 0) {
			return 0;
		}
		if (n <= 9) {
			return 1;
		}

		int min = Integer.MAX_VALUE;
		String temp = Integer.toString(n);
		for (int i = 0; i < temp.length(); i++) {
			int k = temp.charAt(i) - '0';

			if (k != 0)
				min = Math.min(1 + recursiveSol(n - k), min);
		}

		return min;
	}
}
