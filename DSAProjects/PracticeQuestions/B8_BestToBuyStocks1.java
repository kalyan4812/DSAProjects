package PracticeQuestions;

public class B8_BestToBuyStocks1 {

	public static void main(String... strings) {
		int a[] = { 6, 2, 4, 3, 10, 7, 9 };
		// You want to maximize your profit by
		// choosing a single day to buy one stock and choosing a different day in the
		// future to sell that stock.

		int x = getMaxpProfit(a, a.length); // it is same as maximum difference problem of arrays.
		System.out.println(x);// one buy and one sell.

		int y = getMaxpProfitOfAnyNumberOfTranscations(a, a.length);
		System.out.println(y);// any number of buys and sells.

		int z = getMaxpProfitUsingTwoTranscations(a, a.length);
		System.out.println(z);// atmost 2 buys and sells.

		int w = getMaxpProfitUsingKTranscations(a, a.length, 2);
		System.out.println(w);// atmost k buys and sells.

	}

	private static int getMaxpProfitUsingKTranscations(int[] a, int n, int k) {
		int t, i, j, temp, d = a.length;
		if (d == 0 || k == 0)
			return 0;

		if (k > d / 2) {
			int maxProfit = 0;
			for (i = 0; i < d - 1; i++) {
				if (a[i + 1] - a[i] > 0)
					maxProfit += a[i + 1] - a[i];
			}
			return maxProfit;
		}

		int dp[][] = new int[k + 1][d];

		for (i = 1; i <= k; i++) {
			int maxTemp = -a[0];
			for (j = 1; j < d; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], maxTemp + a[j]);
				maxTemp = Math.max(maxTemp, dp[i - 1][j - 1] - a[j]);
			}
		}

		return dp[k][d-1];
	}

	// O(N)
	private static int getMaxpProfitUsingTwoTranscations(int[] a, int n) {
		int b1 = Integer.MIN_VALUE;
		int b2 = Integer.MIN_VALUE;
		int s1 = 0;
		int s2 = 0;

		for (int i = 0; i < n; i++) {

			s2 = Math.max(s2, a[i] + b2);
			b2 = Math.max(b2, s1 - a[i]);
			s1 = Math.max(s1, a[i] + b1);
			b1 = Math.max(b1, -a[i]);

		}

		return Math.max(s2, s1);
	}

	// O(N)
	private static int getMaxpProfitOfAnyNumberOfTranscations(int[] a, int n) {
		int maxprof = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] < a[i + 1]) {
				maxprof = maxprof + a[i + 1] - a[i];
			}
		}
		return maxprof;
	}

	// O(N)
	private static int getMaxpProfit(int[] a, int n) {

		int min = a[0]; // minimum buy from 0 to i.
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > min) { // so that you can sell.
				max = Math.max(max, a[i] - min);
			} else {
				min = a[i];
			}
		}
		return max;
	}

}
