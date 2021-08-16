package BinarySearch;

public class C4_KthElemenOfTwoSortedArrays {

	public static void main(String... strings) {
		int a[] = { 2, 3, 6, 7, 9 };
		int b[] = { 1, 4, 8, 10 };
		int k = 5;

		int p = fun(b, a, k);
		System.out.println(p);
	}

	// always first array should be smaller than second.
	private static int fun(int[] b, int[] a, int k) {
		int n1 = b.length;
		int n2 = a.length;

		if (n1 > n2) {
			return fun(a, b, k);
		}

		// if k<n1 then you can't have e=n1 e=min(n1,k).
		// if k>n2 then s should be max(0,k-n2);
		// to understand above think s=min elements to be picked from b,h=max elements to
		// be picked from b
		int s = Math.max(0, k - n2), e = Math.min(n1, k);
		while (s <= e) {
			int i1 = s + (e - s) / 2;
			int i2 = k - i1;

			int min1 = (i1 == n1) ? (Integer.MAX_VALUE) : b[i1];
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : a[i2];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : b[i1 - 1];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : a[i2 - 1];

			if (max1 <= min2 && max2 <= min1) {

				return Math.max(max1, max2);

			} else if (max1 > min2) {
				e = i1 - 1;
			} else if (max2 > min1) {
				s = i1 + 1;
			}

		}

		return -1;
	}
}
