package BinarySearch;

import java.util.Scanner;

public class C9_ElementAppearOnceInSortedArray {

	public static void main(String[] args) {
		// input work
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int ans = findSingleElement(arr);
		System.out.println(ans);
	}

	public static int findSingleElement(int[] a) {
		// write your code here

		int l = 0, h = a.length - 1;
		int n = a.length;
		if (n >= 2 && a[0] != a[1]) {
			return a[0];
		}
		if (a[n - 1] != a[n - 2]) {
			return a[n - 1];
		}

		while (l <= h) {

			int m = l + (h - l) / 2;

			int len = 0;
			if (a[m] != a[m - 1] && a[m + 1] != a[m]) {
				return a[m];
			} else if (m - 1 >= 0 && a[m] == a[m - 1]) {
				len = m - l + 1;
				if (len % 2 == 0) {
					l = m + 1;
				} else {
					h = m - 2; // failing in leetcode for h=m-1. why?
				}

			} else if (m + 1 < a.length && a[m] == a[m + 1]) {
				len = h - m + 1;
				if (len % 2 == 0) {
					h = m - 1;
				} else {
					l = m + 2;
				}
			}
		}
		return -1;
	}
}
