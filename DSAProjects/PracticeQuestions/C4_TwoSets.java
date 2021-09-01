package PracticeQuestions;

public class C4_TwoSets {

	// given 1 to  n ,count number of ways it can be divided to equal sums subets.
	public static void main(String...strings) {
		
		int n=7;
		
		int a[]=new int[n];
		for(int i=0;i<7;i++) {
			a[i]=i+1;
		}
		
		int sum=n*(n+1)/4; // sum/2.
		int ans=CountOfSubsetsWithGivenSum(a,a.length,sum);
		System.out.println(ans/2);
	}
	private static int CountOfSubsetsWithGivenSum(int[] a, int n, int sum) {
		int dp[][] = new int[n + 1][sum + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (a[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - a[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];

	}
}
