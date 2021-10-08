package PracticeQuestions;

import java.util.HashMap;
import java.util.Map;

public class E2_CountPairsWithGivenXOR {
	public static void main(String[] args) {
		int arr[] = { 5, 4, 10, 15, 7, 6 };
		int n = arr.length;
		int x = 5;
		System.out.print("Count of pairs with given XOR = " + countPair(n, arr, x));
	}

	static int countPair(int n, int arr[], int x) {
		int result = 0; // Initialize result

		// create empty map that stores counts of
		// individual elements of array.
		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int curr_xor = x ^ arr[i];

			// If there exist an element in map m
			// with XOR equals to x^arr[i], that means
			// there exist an element such that the
			// XOR of element with arr[i] is equal to
			// x, then increment count.
			if (m.containsKey(curr_xor))
				result += m.get(curr_xor);

			// Increment count of current element
			if (m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i]) + 1);
			} else {
				m.put(arr[i], 1);
			}
		}
		// return total count of pairs with XOR equal to x
		return result;
	}
}
