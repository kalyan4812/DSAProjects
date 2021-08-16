package BinarySearch;

public class B6_MaxElementInBiotinicArray {

	// bitonic array means monotincally increasing the decreasing.
	// so its same as finding peak element.
	public static void main(String... strings) {
		int a[] = { 1, 3, 8, 12, 4, 2 };
		int k = fun(a);
		System.out.println(k);

		int p = search(a, 4);
		System.out.println(p);
	}

	// dont confuse with rotated sorted array with bitonic array,in bitonic array
	// right half is descending array.
	private static int search(int[] a, int i) {
		int index = fun(a); // find peak
		int lefthalf = recursiveBs(a, 0, index, i);
		int righthalf = reverseBs(a, index+1, a.length - 1, i);
		if (lefthalf != -1) {
			return lefthalf;
		} else {
			return righthalf;
		}

	}

	// O(logn)+ space for storing functions in stack.
	private static int recursiveBs(int[] a, int low, int high, int ele) {

		int l = low, h = high;
		if (l > h) {
			return -1;
		}
		int m = l + (h - l) / 2; // to avoid overflow of int size.
		if (a[m] == ele) {
			return m;
		} else if (ele < a[m]) {
			return recursiveBs(a, l, m - 1, ele);
		} else {
			return recursiveBs(a, m + 1, h, ele);
		}

	}

	private static int reverseBs(int[] a, int low, int high, int ele) {

		int l = low, h = high;
		if (l > h) {
			return -1;
		}
		int m = l + (h - l) / 2; // to avoid overflow of int size.
		if (a[m] == ele) {
			return m;
		} else if (ele < a[m]) {
			return recursiveBs(a, m + 1, h, ele);
		} else {
			return recursiveBs(a, l, m - 1, ele);

		}

	}

	// O(logn)
	private static int fun(int[] a) {
		int n = a.length;
		int l = 0, h = n - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if ((m == 0 || a[m - 1] <= a[m]) && (m == n - 1 || a[m + 1] <= a[m])) {
				return m;
			} else if (m >= 0 && a[m - 1] >= a[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}
}
