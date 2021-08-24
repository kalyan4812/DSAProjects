package PracticeQuestions;

public class A2_MinCostToClimbStairs {

	public static void main(String... strings) {
		int arr[] = { 10, 15, 20 };

		int n = arr.length;

		int a = minCostClimbingStairs(arr);
		System.out.println(a);

		int ans = go(arr);
		System.out.println(ans);
	}

	public static int go(int[] a) {

		int n = a.length;
		int dp[] = new int[n + 2];
		dp[n] = 0;
		dp[n + 1] = 0;

		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Math.min(dp[i + 1], dp[i + 2]) + a[i];
		}

		return Math.min(dp[0], dp[1]);

	}

	public static int minCostClimbingStairs(int[] a) {

		return Math.min(gos(a, 0), gos(a, 1));

	}

	static int gos(int a[], int i) {

		if (i >= a.length) {
			return 0;
		}
		return Math.min(gos(a, i + 1) + a[i], gos(a, i + 2) + a[i]);
	}
}

