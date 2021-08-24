package DynamicProgramming;

public class A3_EqulaSumPartition {

	public static void main(String... strings) {

		int a[] = { 1, 5, 11, 5 }; // item array.

		// check whether array can be divided into two subsets with equal sum.

		// idea: subset1sum+subset2sum2=total sum.
		// since subset1sum=subset2sum, subset1sum=sum/2;
		// so we have to check whether we can form sum of array-sum/2 from given array.

		int sum = 0;
		for (int k : a) {
			sum = sum + k;
		}

		boolean b =false;
		if (sum % 2 != 0) {
			b= false;
		}
		else {
			b= tabulationSol(a, a.length, sum/2);
		}
		System.out.println(b);
	}

	// O(sum*n)
	private static boolean tabulationSol(int[] a, int n, int sum) {
		
		boolean dp[][] = new boolean[n + 1][sum + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (a[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];
	}
}
