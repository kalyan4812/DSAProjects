package Arrays;

public class C6_MaxProductSubArray {

	public static void main(String... strings) {
		int[] a = { 6, -3, -10, 0, 2 };
		long ans = maxProduct(a, a.length);
		System.out.print(ans);

	}

	static long maxProduct(int[] a, int n) {
		long prev_min = a[0];
		long prev_max = a[0];
		long curr_max = a[0];
		long curr_min = a[0];
		long res = a[0];
		for (int i = 1; i < n; i++) {
			curr_min = Math.min(Math.min(prev_min * a[i], prev_max * a[i]), a[i]);
			curr_max = Math.max(Math.max(prev_min * a[i], prev_max * a[i]), a[i]);
			res = Math.max(res, curr_max);
			prev_min = curr_min;
			prev_max = curr_max;
		}
		return res;
	}
}
