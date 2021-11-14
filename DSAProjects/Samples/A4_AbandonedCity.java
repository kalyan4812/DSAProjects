package Samples;

public class A4_AbandonedCity {

	public static void main(String... strings) {

		int n = 5;
		int a[] = { 1, 2, 3, 4, 5 };
		int tar = 7;

		long ans = fun(n, a, tar);
		System.out.println(ans);

	}

	private static long fun(int n, int[] a, int tar) {

		long pre[] = new long[n+1];
		pre[0] = 0;

		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i - 1] + a[i-1];
		}
		if (pre[n] < tar) {
			return -1;
		} else {
			long ans = Long.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				int l = i;
				int r = n;
				int mid;
				while (l <= r) {

					mid = (l + r) / 2;
					if (pre[mid] - pre[i - 1] >= tar) {

						ans = Math.min(ans, mid - i + 1);
						r = mid - 1;
					} else
						l = mid + 1;
				}

			}
			return ans;
		}

	}
}
