package DynamicProgramming;

public class D4_VariationOfLis {

	public static void main(String... strings) {

		int a[] = { 3, 4, 2, 8, 10 }; // --> lis :3,4,8,10.

		int k = minDeletionsToMakeArraySorted(a, a.length);
		System.out.println(k);

		int r = maximumSumIncreaingSubsequence(a, a.length);
		System.out.println(r);

		int z = maximumlengthBiotonicSubsequence(a, a.length); // first increasing then decreasing.
		System.out.println(z);

	}

//-----------------------------------------------------------------------------------------------------------	
	private static int maximumlengthBiotonicSubsequence(int[] a, int n) {
		int lis[] = new int[n]; // longest increasing subsequence ending with i.
		int lds[] = new int[n]; // longest decreasing subsequence starting with i.
		lis[0] = 1;
		lds[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = n - 1; j >= i; j--) {
				if (a[j] < a[i]) {
					lds[i] = Math.max(lds[i], lds[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		return max;
	}

//--------------------------------------------------------------------------------------------------------	
	private static int maximumSumIncreaingSubsequence(int[] a, int n) {
		int dp[] = new int[n]; // denote lis ending with i.
		dp[0] = a[0];

		for (int i = 1; i < n; i++) {
			dp[i] = a[i];
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + a[i]);
				}
			}
		}

		int res = dp[0];
		for (int p : dp) {
			res = Math.max(p, res);
		}

		return res;
	}

	/*
	 * 3,20,4,6,7,30. lis : 3,4,6,7,30 ,maximumSumIncreaingSubsequence : 3,20,30.
	 */

//------------------------------------------------------------------------------------------------	
	private static int minDeletionsToMakeArraySorted(int[] a, int n) {

		return n - lis(a, n);
	}

//-----------------------------------------LIS-------------------------------------------------------------------
	private static int lis(int[] a, int n) {

		int dp[] = new int[n]; // denote lis ending with i.
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int res = dp[0];
		for (int p : dp) {
			res = Math.max(p, res);
		}

		return res;
	}
}
