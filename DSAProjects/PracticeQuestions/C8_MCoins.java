package PracticeQuestions;

import java.util.Scanner;

public class C8_MCoins {

	/*
	 * Asen and Boyan are playing the following game. They choose two different
	 * positive integers K and L, and start the game with a tower of N coins. Asen
	 * always plays first, Boyan – second, after that – Asen again, then Boyan, and
	 * so on. The boy in turn can take 1, K or L coins from the tower. The winner is
	 * the boy, who takes the last coin (or coins). After a long, long playing, Asen
	 * realizes that there are cases in which he could win, no matter how Boyan
	 * plays. And in all other cases Boyan being careful can win, no matter how Asen
	 * plays.
	 * 
	 * So, before the start of the game Asen is eager to know what game case they
	 * have. Write a program coins which help Asen to predict the game result for
	 * given K, L and N.
	 */

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int l = sc.nextInt();
		int m = sc.nextInt();

		while (m > 0) {
			int n = sc.nextInt();
			System.out.print(winnerDp(k, l, n) == true ? "A" : "B");
			m--;
		}

	}
	// x = 3, y = 4, n = 5;

	private static boolean winnerDp(int k, int l, int n) {
		boolean dp[] = new boolean[n + 1];
		dp[1] = true;
		if (n >= k)
			dp[k] = true;
		if (n >= l)
			dp[l] = true;

		for (int i = 2; i <= n; i++) {
			if (i == k || i == l) {
				continue;
			}
			if (i - 1 >= 0 && dp[i - 1] == false)
				dp[i] = true;
			else if (i - k >= 0 && dp[i - k] == false)
				dp[i] = true;
			else if (i - l >= 0 && dp[i - l] == false)
				dp[i] = true;
			else {
				dp[i] = false;
			}

		}

		return dp[n];
	}

	private static boolean winner(int k, int l, int n) {
		if (n == 1) {
			return true;
		}
		boolean x = winner(k, l, n - 1);

		boolean y = false, z = false;
		if (n - k >= 1) {
			y = winner(k, l, n - k);
		}

		if (n - l >= 1) {
			z = winner(k, l, n - l);
		}
		if (y == false || x == false || z == false) {
			return true;
		}
		return false;
	}
}
