package PracticeQuestions;

public class E3_DoubleHelix {

	/*
	 * You can ‘walk” over these two sequences in the following way:
	 * 
	 * You may start at the beginning of any of the two sequences. Now start moving
	 * forward. At each intersection point, you have the choice of either continuing
	 * with the same sequence you’re currently on, or switching to the other
	 * sequence.
	 */

	public static void main(String... strings) {

		int a[] = { 3, 5, 7, 9, 20, 25, 30, 40, 55, 56, 57, 60, 62 };
		int b[] = { 1, 4, 7, 11, 14, 25, 44, 47, 55, 57, 100 };

		int ans = fun(a, b);
		System.out.println(ans);

		int ans2 = pointerFun(a, b);
		System.out.println(ans2);

	}

	private static int pointerFun(int[] a, int[] b) {

		int n = a.length;
		int m = b.length;

		int s1 = 0, s2 = 0;
		int i = 0, j = 0;

		int ma = 0;
		while (i < n && j < n) {

			if (a[i] < b[j]) {
				s1 += a[i];
				i++;
			} else if (a[i] > b[j]) {
				s2 += b[j];
				j++;
			} else {
				ma += Math.max(s1, s2) + a[i];
				s1 = 0;
				s2 = 0;
				i++;
				j++;
			}
		}
		while (i < n) {
			s1 += a[i];
			i++;
		}
		while (j < m) {
			s2 += b[j];
			j++;
		}
		return Math.max(s1, s2) + ma;
	}

	//////////////////////////////////////
	private static int fun(int[] a, int[] b) {

		return Math.max(recur(a, b, a, 0), recur(a, b, b, 0));
	}

	private static int recur(int[] a, int[] b, int c[], int i) {
		if (i >= c.length) {
			return 0;
		}
		if (i >= a.length && i < b.length) {
			int s = 0;
			for (int j = i; j < b.length; j++) {
				s += b[j];
			}

			return s;
		} else if (i >= b.length && i < a.length) {
			int s = 0;
			for (int j = i; j < a.length; j++) {
				s += a[j];
			}

			return s;
		}
		if (a[i] == b[i]) {
			return Math.max(a[i] + recur(a, b, a, i + 1), b[i] + recur(a, b, b, i + 1));
		} else {
			return c[i] + recur(a, b, c, i + 1);
		}

	}
}
