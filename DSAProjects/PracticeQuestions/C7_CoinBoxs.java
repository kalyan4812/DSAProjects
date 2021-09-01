package PracticeQuestions;

import java.util.Scanner;

public class C7_CoinBoxs {

	static int[] start = new int[100005];
	static int[] end = new int[100005];
	static int[] dp = new int[100005];
	static int[] coins = new int[100005];

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); // test cases.

		while (m > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			start[l]++;
			end[r]++;
			m--;
		}

		dp[1] = start[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + start[i] - end[i - 1];
		}

		for (int j = 1; j <= n; j++) {
			coins[dp[j]]++;
		}

		// suffix array

		for (int k = n - 1; k >= 0; k--) {
			coins[k] = coins[k] + coins[k + 1];
		}

		int q = sc.nextInt();
		while (q > 0) {
			int r = sc.nextInt();
			System.out.println(coins[r]);
			q--;
		}

	}
}
