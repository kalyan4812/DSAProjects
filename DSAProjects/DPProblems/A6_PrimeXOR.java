package DPProblems;

import java.util.Scanner;

public class A6_PrimeXOR {

	/*
	 * Penny has an array of integers, . She wants to find the number of unique
	 * multisets she can form using elements from the array such that the bitwise
	 * XOR of all the elements of the multiset is a prime number. Recall that a
	 * multiset is a set which can contain duplicate elements.
	 * 
	 * Given queries where each query consists of an array of integers, can you help
	 * Penny find and print the number of valid multisets for each array? As these
	 * values can be quite large, modulo each answer by before printing it on a new
	 * line.
	 */

	// given 3500<=a[i]<=4500.

	static int mod = (int) Math.pow(10, 9) + 7;

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();

		while (q > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			System.out.println(a[0]);
			int ans = fun(a, a.length);
			System.out.println(ans);

			q--;
		}
	}
// not correct.
	// dp[i][j] means till ith element,how many sets have bitwise xor as j.

	private static int fun(int[] a, int n) {

		int freq[] = new int[4505];

		for (int i = 0; i < n; i++) {
			freq[a[i]]++;
		}

		int max_xor = (1 << 13) - 1;
		int dp[][] = new int[4505][max_xor + 5];
		dp[0][0] = 1; // empty subset has xor 0.

		for (int i = 3500; i <= 4500; i++) {

			for (int j = 0; j <= max_xor; j++) {
				if (freq[i] == 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = (dp[i - 1][j] * (1 + freq[i] / 2)) + (dp[i - 1][j ^ i] * ((1 + freq[i]) / 2));
				}
			}
		}
		
		int ans = 0;

		for (int i = 0; i <= max_xor; i++) {
			if (isPrime(i)) {
				ans = ans + dp[n][i];
			}
		}

		return ans;
	}

	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;

	}

}
