package Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class B1_LongestConsecutiveSubsequence {

	public static void main(String... strings) {
		int a[] = { 1, 9, 3, 4, 2, 20 };

		fun(a);

		fun2(a);
	}

	// O(n),O(n)-space.
	private static void fun2(int[] a) {

		HashSet<Integer> h = new HashSet<>();

		int n = a.length;
		for (int i = 0; i < n; i++) {
			h.add(a[i]);
		}

		int curr = 1, max = 1;
		for (int i = 0; i < n; i++) {
			if (h.contains(a[i] - 1)) { // its the starting point of new consecutive subsequence
				curr = 1;
			}
			while (h.contains(a[i] + curr)) { // after knowing start we search for next elements if we find we keep
												// updating the count.
				curr++;
			}
			max = Math.max(max, curr);
		}

		System.out.println(max);
	}

	// O(Nlogn+N)
	private static void fun(int[] a) {

		int n = a.length;
		Arrays.sort(a);
		int curr_max = 1, max = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] == a[i - 1] + 1) {
				curr_max++;
			} else {
				max = Math.max(max, curr_max);
				curr_max = 1;
			}
		}
		max = Math.max(curr_max, max);
		System.out.println(max);

	}
}
