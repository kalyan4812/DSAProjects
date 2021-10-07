package BinarySearch;

public class C3_MedianOfTwoSortedArrays {

	public static void main(String... strings) {
		int a[] = { 1, 3, 4, 7, 10, 12 };
		int b[] = { 2, 3, 6, 15 };

		// always make first array smaller.
		double k = fun(b, a);
		System.out.println(k);

		// approach1-take other array,add two arrays to it,sort it find median.
		// approaach2 merge arrays using merge sort and store in some array,find median.
		// approaach3 merge arrays using merge sort and store middle elements in some
		// int
		// primitives ,find median.
		// approach 4 use binary search.
	}

	// O(logn1)
	private static double fun(int[] b, int[] a) {
		int n1 = b.length;
		int n2 = a.length;

		int s = 0, e = n1;
		while (s <= e) {
			int i1 = s + (e - s) / 2;
			int i2 = (n1 + n2 + 1) / 2 - i1;

			int min1 = (i1 == n1) ? (Integer.MAX_VALUE) : b[i1];
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : a[i2];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : b[i1 - 1];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : a[i2 - 1];

			if (max1 <= min2 && max2 <= min1) {
				if ((n1 + n2) % 2 == 0) {
					return (double) ((Math.max(max1, max2) + Math.min(min1, min2)) / 2);
				} else {
					return (double) Math.max(max1, max2);
				}
			} else if (max1 > min2) {
				e = i1 - 1;
			} else if (max2 > min1) {
				s = i1 + 1;
			}

		}

		return -1;
	}

	public static double find(int[] a, int[] b) {

		if (a.length < b.length) {
			int l = 0, h = a.length - 1; // on leetcode it need h=a.length why?
			int te = a.length + b.length;

			while (l <= h) {

				int aleft = l + (h - l) / 2;

				int bleft = (te + 1) / 2 - aleft;

				int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
				int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];

				int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];
				int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft];

				// valid segregation.
				if (alm1 <= bl && blm1 <= al) {

					int lmax = Math.max(alm1, blm1);
					int rmin = Math.min(al, bl);

					double median = 0.0;
					if (te % 2 == 0)
						median = (lmax + rmin) / 2.0;
					else
						median = (double) lmax;

					return median;
				} else if (alm1 > bl) {
					h = aleft - 1;
				} else if (blm1 > al) {
					l = aleft + 1;
				}

			}
			return -1;
		} else {
			return find(b, a);
		}

	}
}
