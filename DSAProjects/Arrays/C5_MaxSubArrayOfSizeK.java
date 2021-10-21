package Arrays;

public class C5_MaxSubArrayOfSizeK {
	public static void main(String... strings) {
		int[] a = { 2, 5, 4, 3, 1, 7 };
		int k = 3;
		fun(a, a.length, k);
	}
	// for nlength arary there will be n*(n+1)/2 subarrays.

	private static void fun(int[] a, int n, int k) {
		int max = Integer.MIN_VALUE;

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + a[i];

		}
		max = Math.max(max, sum);
		sum = 0;
		for (int i = k; i < n; i++) {
			sum = sum + a[i] - a[i - k];
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
