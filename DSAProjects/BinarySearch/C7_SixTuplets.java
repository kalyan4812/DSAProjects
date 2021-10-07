package BinarySearch;

import java.util.Arrays;

public class C7_SixTuplets {

	/*
	 * You are given a set S of integers between -30000 and 30000 (inclusive).
	 * 
	 * Find the total number of sextuples that satisfy:
	 * 
	 * a * b + c = (f + e) * d.
	 * 
	 */

	static int upper_bound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int lower_bound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	static int findSextuplets(int[] arr, int n) {
		// Generating possible values of RHS of the equation
		int index = 0;
		int[] RHS = new int[n * n * n + 1];
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) // Checking d should be non-zero.
			{
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						RHS[index++] = arr[i] * (arr[j] + arr[k]);
					}
				}
			}
		}

		// Sort RHS[] so that we can do binary search in it.
		Arrays.sort(RHS);

		// Generating all possible values of LHS of the equation
		// and finding the number of occurrences of the value in RHS.
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int val = arr[i] * arr[j] + arr[k];
					result += (upper_bound(RHS, index, val) - lower_bound(RHS, index, val));
				}
			}
		}

		return result;
	}

// Driven Program
	public static void main(String[] args) {
		int[] arr = { 2, 3 };
		int n = arr.length;

		System.out.println(findSextuplets(arr, n));

	}
}
