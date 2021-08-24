package PracticeQuestions;

public class A1_MaxSumSuchNoTwoAreAdjacent {

	public static void main(String... strings) {
		int arr[] = { 2, 7, 9, 3, 1 };

		int n = arr.length;

		int ans = go(arr, 0, n - 1);
		System.out.println(ans);

		int a = dpSol(arr);
		System.out.println(a);
	}

	
	//O(N)
	private static int dpSol(int[] a) {

		int n = a.length;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = a[0];
		dp[2] = Math.max(a[0], a[1]);
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i - 1]);

		}
		dp[n] = Math.max(dp[n - 1], dp[n - 2] + a[n - 1]);
		return dp[n];
	}

//-------------------------------------------------------- Recursive solution using mcm pattern--------------------------------------	

	public static int go(int a[], int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return a[i];
		}

		int max = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {

			int tempans = go(a, i, k - 2) + go(a, k + 2, j) + a[k];
			max = Math.max(max, tempans);

		}
		return max;
	}
}
