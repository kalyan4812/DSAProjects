package BinarySearch;

public class A9_SearchInSortedRotatedArray {

	public static void main(String... strings) {
		int a[] = { 10, 20, 30, 40, 50, 8, 9 };
		int x = 30;

		int k = search(a, x);
		System.out.println(k);

		int p = searchUsingNoOfSortedArrayIdea(a, x);
		System.out.println(p);
	}

	// once we find the index where array is divided to two sorted parts,we can
	// search in both sorted parts,return whichever is not -1;
	// not applicable for repaeative elements.

	private static int searchUsingNoOfSortedArrayIdea(int[] a, int x) {
		int index = fun(a);
		int lefthalf = recursiveBs(a, 0, index - 1, x);
		int righthalf = recursiveBs(a, index, a.length - 1, x);
		if (lefthalf != -1) {
			return lefthalf;
		} else {
			return righthalf;
		}
	}

	// O(logn)
	private static int fun(int[] a) {
		int n = a.length;
		int l = 0, h = n - 1;
		while (l <= h) {
			if (a[l] <= a[h]) {
				return Math.min(l, n - l);
			}
			int m = l + (h - l) / 2;
			int next = (m + 1) % n;
			int prev = (m + n - 1) % n;
			if (a[m] <= a[next] && a[m] <= a[prev]) {
				return Math.min(m, n - m);
			}
			if (a[l] <= a[m]) {
				l = m + 1;
			} else if (a[m] <= a[h]) {
				h = m - 1;
			}
		}
		return 0;
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

	//////////////////////////////////////////////////

	// O(logn)
	private static int search(int[] a, int x) {
		int n = a.length;
		int l = 0, h = n - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a[m] == x) {
				return m;
			}

			// left half sorted
			else if (a[l] < a[m]) {
				if (x >= a[l] && x < a[m]) {
					h = m - 1;
				} else {
					l = m + 1;
				}
			}

			// right half sorted.
			else {
				if (x <= a[h] && x >= a[m]) {
					l = m + 1;
				} else {
					h = m - 1;
				}
			}
		}
		return -1;
	}
}
