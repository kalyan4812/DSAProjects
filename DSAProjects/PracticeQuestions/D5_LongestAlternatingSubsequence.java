package PracticeQuestions;

public class D5_LongestAlternatingSubsequence {

	public static void main(String... strings) {

		int a[] = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		int ans = AlternatingaMaxLength(a);
		System.out.println(ans);

		int k = fun2(a);
		System.out.println(k);

	}

	//O(N)
	public static int fun2(int[] a) {
		int n = a.length;
		if (n == 1) {
			return 1;
		}

		int md = 1, mi = 1;
		for (int i = 1; i < n; i++) {

			if (a[i] < a[i - 1]) {
				md = mi + 1;
			} else if (a[i] > a[i - 1]) {
				mi = md + 1;
			} else {
				continue;
			}
		}

		return Math.max(mi, md);

	}

	//O(N2)
	public static int AlternatingaMaxLength(int[] a) {
		int n = a.length;
		if (n == 1) {
			return 1;
		}
		int dp1[] = new int[n];
		int dp2[] = new int[n];
		dp1[0] = 1;
		dp2[0] = 1;

		int max = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (a[i] > a[j]) {
					dp1[i] = Math.max(dp1[i], dp2[j] + 1);
				} else if (a[i] < a[j]) {
					dp2[i] = Math.max(dp2[i], dp1[j] + 1);
				}

				max = Math.max(max, Math.max(dp1[i], dp2[i]));
			}
		}

		return max;

	}
}
