package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class C7_LargestNumber {

	// Given a list of non-negative integers nums, arrange them such that they form
	// the largest number.

	// you cant use normal sort because for 32,3 it sorts like 32,3 so nuumber will
	// be 323 ,but we know large value
	// than this is 332.
	public static void main(String[] args) {
		int nums[] = { 3, 30, 34, 5, 9 };

		System.out.println(largestNumber(nums)); // "9534330"
	}

	public static String largestNumber(int[] a) {

		int n = a.length;
		String s[] = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = a[i] + "";
		}

		Arrays.sort(s, new MySort());

		StringBuilder sb = new StringBuilder("");

		for (int i = n - 1; i >= 0; i--) {
			sb.append(s[i]);
		}

		if (sb.charAt(0) == '0') {
			return "0";
		}

		return sb.toString();
	}

	public static class MySort implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			long n1 = Long.parseLong(a + b);
			long n2 = Long.parseLong(b + a);

			if (n1 > n2) {
				return 1;
			} else if (n1 < n2) {
				return -1;
			} else {
				return 0;
			}

		}

	}
}
