package PracticeQuestions;

import java.util.Arrays;

public class B5_MinimumJumpsToReachEnd {

	public static void main(String... strings) {
		int arr[] = { 2, 3, 0, 1, 4 }; // from a[i] you can make at max a[i] jumps.

		// int arr[] = { 4,1,5,3,1,3,2,1,8};
		int n = arr.length;

		int ans = go(arr, n, 0);
		System.out.println(ans);

		int s = go2(arr, n);
		System.out.println(s);

		int a = dpSol(arr, n);
		System.out.println(a);

		int b = dpSol2(arr, n);
		System.out.println(b);
		
		
		fun(30);
		System.out.println("count :"+count);
	}
	static int count=0;
	static int fun(int n) {
		count++;
		if(n==2) {
			return 2;
		}
		return n+fun(n-2);
	}

	private static int go2(int[] a, int n) {
		if (n == 1) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		for (int j = 0; j <= n - 2; j++) {
			if (j + a[j] >= n - 1) {
				int subres = go2(a, j + 1);
				if (subres != Integer.MAX_VALUE) {
					res = Math.min(res, 1 + subres);
				}
			}
		}
		return res;
	}

	private static int dpSol2(int[] a, int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + a[j] >= i && dp[j] != Integer.MAX_VALUE) {

					dp[i] = Math.min(dp[i], 1 + dp[j]);
				}
			}
		}

		return dp[n - 1];
	}

	private static int dpSol(int[] a, int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n - 1] = 0;
		dp[n] = 0;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 1; j <= a[i]; j++) {
				if (i + j > n || dp[i + j] == Integer.MAX_VALUE) {
					continue;
				}
				dp[i] = Math.min(dp[i], 1 + dp[i + j]);
			}
		}

		return dp[0];
	}

	private static int go(int[] a, int n, int i) {
		if (i >= n - 1) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int j = 1; j <= a[i]; j++) {

			if (go(a, n, i + j) != Integer.MAX_VALUE)
				min = Math.min(min, 1 + go(a, n, i + j));
		}
		return min;
	}
}
