package PracticeQuestions;

public class A6_NCR {

	public static void main(String... strings) {

		int ans = nCr(31, 10);
		System.out.println(ans);
		
		
		int ans2 = nPr(4, 2);
		System.out.println(ans2);
	}

	//O(N),O(1)
	private static int nPr(int n, int r) {
		
		int p=1;
		for(int i=0;i<r;i++) {
			p=p*(n-i);
		}
		
		return p;
	}

	static int mod = 1000000000 + 7;

	static int nCr(int n, int r) {
		if (n < r)
			return 0;
		r = Math.min(r, n - r);

		int dp[] = new int[r + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--) {
				dp[j] = (dp[j - 1] + dp[j]) % mod;
			}
		}

		return dp[r];

		
	}
}
