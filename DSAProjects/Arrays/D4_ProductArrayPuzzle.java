package Arrays;

public class D4_ProductArrayPuzzle {

	// multiplication except that number.
	public static void main(String... strings) {
		int[] a = { 10, 3, 5, 6, 2 };
		fun(a, a.length);
	}

	private static void fun(int[] a, int n) {
		long[] ans = new long[n];
		long l[] = new long[n];
		l[0] = 1;

		long[] r = new long[n];
		r[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			l[i] = l[i - 1] * a[i - 1];
		}
		for (int j = n - 2; j >= 0; j--) {
			r[j] = r[j + 1] * a[j + 1];
		}
		for (int i = 0; i < n; i++) {
			ans[i] = l[i] * r[i];
			System.out.print(ans[i] + " ");
		}

	}
}
