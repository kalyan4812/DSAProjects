package DynamicProgramming;

public class D3_LongestIncreasingSubsequence_LIS {
	public static void main(String... strings) {

		int a[] = { 3, 4, 2, 8, 10 };

		int k = getDpSol(a, a.length);
		System.out.println(k);

		int z = getBinarySearchSol(a, a.length);
		System.out.println(z);
	}

	// O(nlogn)
	private static int getBinarySearchSol(int[] a, int n) {
		int tail[] = new int[n]; // stores minimum possible tail value for lis of length (i+1).
		// we can use arraylist as tail to improve space complexity.
		int len = 1;
		tail[0] = a[0];

		for (int i = 1; i < n; i++) {

			if (a[i] > tail[len - 1]) {
				tail[len] = a[i];
				len++;
			} else {
				int ciel = getCiel(tail, 0, len - 1, a[i]);
				tail[ciel] = a[i];
			}
		}
		return len;
	}

	
	//O(logn)
	private static int getCiel(int[] tail, int l, int r, int val) {
		
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (tail[mid] >= val) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

	// t(n2)
	private static int getDpSol(int[] a, int n) {

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
