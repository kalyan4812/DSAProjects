package DynamicProgramming;

public class H1_KadanesAlgorithm {

	// kadanes algo-maximum subarray sum.

	public static void main(String... strings) {
		int a[] = { -1, 4, 2, -5, 3 };

		int k = getmaxsum(a, a.length);
		System.out.println(k);

		int p = getmaxsum2(a, a.length);
		System.out.println(p);

		int x = getMaxSubarrayProduct(a, a.length);
		System.out.println(x);

		int y = maxSubarrayWithOneDeletion(a, a.length);
		System.out.println(y);

		int z = maxSubarrayWithOneDeletion2(a, a.length);
		System.out.println(z);

		int u = maxsubarraywithatmostkdeletions(a, a.length);
		System.out.println(u);

		int b[] = { 1, 2, 6, 4, 8, 3, 2 };
		int r = longestTurbulanceSubarray(b, b.length); // increase-decrease alternatively. 2,6,4,8,3
		System.out.println(r);
	}

	private static int longestTurbulanceSubarray(int[] nums, int n) {

		int dp[][] = new int[n][2]; // stores up and down trend.

		dp[0][0] = dp[0][1] = 1;

		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[i - 1]) {
				dp[i][0] = dp[i][1] = 1;
			} else if (nums[i] > nums[i - 1]) {
				dp[i][0] = dp[i - 1][1] + 1;
				dp[i][1] = 1;
			} else {
				dp[i][0] = 1;
				dp[i][1] = dp[i - 1][0] + 1;
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i][0] > ans)
				ans = dp[i][0];

			if (dp[i][1] > ans)
				ans = dp[i][1];
		}
		return ans;
	}

	private static int maxsubarraywithatmostkdeletions(int[] a, int n) {
		int K = 1;
		if (n == 0) {
			return 0;
		}

		int[][] dp = new int[n + 1][K + 1];
		for (int i = 0; i <= K; i++) {
			dp[0][i] = Integer.MIN_VALUE;
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int k = 0; k <= K; k++) {
				if (dp[i - 1][k] >= 0) {
					dp[i][k] = Math.max((k - 1 >= 0 ? dp[i - 1][k - 1] : Integer.MIN_VALUE), dp[i - 1][k] + a[i - 1]);
				} else {
					dp[i][k] = a[i - 1];
				}
				answer = Math.max(answer, dp[i][k]);
			}
		}
		return answer;
	}

	// O(N)
	private static int maxSubarrayWithOneDeletion2(int[] arr, int len) {

		int preNotDeleted = arr[0];
		int preWithDeleted = 0;
		int max = arr[0];

		for (int i = 1; i < len; i++) {
			preWithDeleted = Math.max(preNotDeleted, preWithDeleted + arr[i]);
			preNotDeleted = Math.max(preNotDeleted + arr[i], arr[i]);
			int current = Math.max(preWithDeleted, preNotDeleted);
			max = Math.max(max, current);
		}
		return max;
	}

	// o(n*n)
	private static int maxSubarrayWithOneDeletion(int[] a, int n) {

		int ans = a[0];
		boolean hasneg = false;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] < 0) {
				hasneg = true;
				int right = maxsumsubarray(a, 0, n, i);
				ans = Math.max(ans, right);
			}
			sum = sum + a[i];
		}
		if (!hasneg) {
			return sum;
		}

		return ans;
	}

	private static int maxsumsubarray(int[] a, int s, int e, int ind) {
		if (a.length <= 0) {
			return 0;
		}
		if (a.length == 1) {
			return a[0];
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = s + 1; i <= e; i++) {
			if (i == ind + 1) {
				continue;
			}
			int curr_sum = Math.max(sum + a[i - 1], a[i - 1]);
			sum = curr_sum;
			max = Math.max(max, curr_sum);
		}
		return max;
	}

	// O(N)
	private static int getMaxSubarrayProduct(int[] a, int n) {

		int mnp = a[0]; // max negative product.
		int mpp = a[0]; // max positive product.

		int max = a[0];

		for (int i = 2; i <= n; i++) {
			int curr_product = Math.max(mpp * a[i - 1], mnp * a[i - 1]);
			curr_product = Math.max(curr_product, a[i - 1]);
			mnp = Math.min(Math.min(mnp * a[i - 1], mpp * a[i - 1]), a[i - 1]);
			mpp = curr_product;
			max = Math.max(max, curr_product);
		}
		return max;
	}

	// O(N)
	private static int getmaxsum2(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int curr_sum = Math.max(sum + a[i - 1], a[i - 1]);
			sum = curr_sum;
			max = Math.max(max, curr_sum);
		}
		return max;
	}

	// O(N),O(N)
	private static int getmaxsum(int[] a, int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1] + a[i - 1], a[i - 1]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
