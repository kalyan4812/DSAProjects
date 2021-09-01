package PracticeQuestions;

public class C6_EatFlowers {

	// given total n red,white flowers ,where white flowers only can be eaten in
	// groups of size k.
	public static void main(String... strings) {
		int n = 1;
		int m = 3; // numbers of flowers range from 4 to 7.
		int k = 2;

		int ways = fun(n, m, k);
		System.out.println(ways);
	}

	private static int fun(int n, int m, int k) {

		int dp[] = new int[100005];
		dp[0] = 1; // empty subset no choose -one way.

		for (int i = 1; i < 100005; i++) {

			if (i >= k) {
				dp[i] = dp[i - 1] + dp[i - k];
			} else {
				dp[i] = dp[i - 1];
			}
		}

		// compute prefix sum to answer queries between range n and m.
		for(int j=1;j<100005;j++) {
			dp[j]=dp[j]+dp[j-1];
		}
		return dp[m]-dp[n-1];
	}
}
