package PracticeQuestions;

import java.util.Arrays;

public class B1_IntegerBreak {

	// break number into sum of digits such that product of digits is maximum.

	public static void main(String... strings) {
		int n = 10;
		System.out.println(recursiveSol(n));

		System.out.println(dpSol(n));
	}

	private static int dpSol(int n) {

		int dp[] = new int[n + 1];
		Arrays.fill(dp,Integer.MIN_VALUE);
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] =Math.max(dp[i], j*Math.max( dp[i - j], i - j));
			}
		}

		return dp[n];
	}

	private static int recursiveSol(int n) {
		if (n <= 1) {
			return n;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			max = Math.max(max,i* Math.max( recursiveSol(n - i), n - i));
		}

		return max;
	}
}
