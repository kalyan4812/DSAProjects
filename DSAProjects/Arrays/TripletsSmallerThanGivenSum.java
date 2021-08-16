package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TripletsSmallerThanGivenSum {

	public static void main(String... strings) {
		int[] a = { 1, 2, -3, 4, -2 };
		int sum = 1;
		fun(a, a.length, sum);
		countTriplets(a, a.length, sum);

		int b[] = { 1, 1, 1, 0 };
		tripletsCloserToGivenSum(b, b.length, 100);
		tripletsCloserToGivenSumOneTraversal(b, b.length, 100);
	}

	// O(n2) ,O(n)-space
	private static void tripletsCloserToGivenSumOneTraversal(int[] a, int n, int sum) {
		Arrays.sort(a);
		int mindiff = Integer.MAX_VALUE;

		boolean minchanged = false;
		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {

			int s = i + 1, e = n - 1;
			while (s < e) {

				if (Math.abs(a[i] + a[s] + a[e] - sum) < mindiff) {

					for (int k = s + 1; k <= e; k++) {

						if (Math.abs(a[s] + a[k] + a[i] - sum) < mindiff) {
							mindiff = Math.min(Math.abs(a[s] + a[k] + a[i] - sum), mindiff);
							minchanged = true;
						} else if (Math.abs(a[s] + a[k] + a[i] - sum) == mindiff) {
							al.add(a[s] + " " + a[k] + " " + a[i]);
						}
						if (minchanged) {

							if (!al.isEmpty()) {
								al.clear();
								al.add(a[s] + " " + a[k] + " " + a[i]);
							} else if (al.isEmpty()) {
								al.add(a[s] + " " + a[k] + " " + a[i]);
							}
							minchanged = false;
						}

					}

					s++;
				}

				else {
					e--;
				}

			}
		}
		System.out.println(al.toString());

	}

	// O(n2) two traversals
	private static void tripletsCloserToGivenSum(int[] a, int n, int sum) {
		System.out.println("neww");
//

		// 0,1,2,3,4
		// 0,1,2
		// 0,1,3
		// 0,1,4

		// 0,2,3
		// 0,2,4
		// 0,3,4
		Arrays.sort(a);
		int mindiff = Integer.MAX_VALUE;

		for (int i = 0; i < n - 1; i++) {

			int s = i + 1, e = n - 1;
			while (s < e) {

				if (Math.abs(a[i] + a[s] + a[e] - sum) <= Math.abs(sum - mindiff)) {

					for (int k = s + 1; k <= e; k++) {

						mindiff = Math.min(Math.abs((a[s] + a[k] + a[i]) - sum), mindiff);
						System.out.println(Math.abs((a[s] + a[k] + a[i]) - sum));

					}

					s++;
				}

				else {
					e--;
				}

			}
		}
		System.out.println(mindiff);

		if (mindiff == 0) {
			tripletEqualtoGivenSum(a, a.length, sum);
		} else {
			tripletEqualtoGivenSum(a, a.length, sum - mindiff);
		}

	}

	private static void tripletEqualtoGivenSum(int[] a, int n, int sum) {
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			int newsum = sum - a[i];
			int s = i + 1, e = n - 1;
			while (s < e) {
				int curr_sum = a[s] + a[e];
				if (curr_sum == newsum) {
					System.out.println(a[i] + " " + a[s] + " " + a[e]);
					s++;
					e--;
				} else if (curr_sum < newsum) {
					s++;
				} else {
					e--;
				}
			}
		}

	}

	// O(n2)
	private static void countTriplets(int[] a, int n, int sum) {
		Arrays.sort(a);
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int newsum = sum - a[i];
			int s = i + 1, e = n - 1;
			while (s < e) {
				int curr_sum = a[s] + a[e];
				if (curr_sum < newsum) {

					count = count + e - s;
					s++;
				}

				else {
					e--;
				}

			}
		}
		System.out.println(count);

	}

	// O(n2)-doubt time complexity
	private static void fun(int[] a, int n, int sum) {
		Arrays.sort(a);
		for (int i = 0; i < n - 1; i++) {
			int newsum = sum - a[i];
			int s = i + 1, e = n - 1;
			while (s < e) {
				int curr_sum = a[s] + a[e];
				if (curr_sum < newsum) {

					for (int k = s + 1; k <= e; k++) {
						System.out.println(a[i] + " " + a[s] + " " + a[k]);

					}
					s++;

				} else {
					e--;
				}

			}
		}
	}

	/// correct code
	public int correctcode(int[] a, int gs) {
		int n = a.length;
		Arrays.sort(a);
		int mindiff = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = 0; i < n - 2; i++) {

			int s = i + 1, e = n - 1;
			while (s < e) {
				int x = a[s] + a[e] + a[i];
				if (x - gs == 0) {

					mindiff = 0;
					sum = x;
					return x;
				} else if (x - gs < 0) {

					if (Math.abs(a[s] + a[e] + a[i] - gs) < mindiff) {
						mindiff = Math.abs(a[s] + a[e] + a[i] - gs);
						sum = a[s] + a[e] + a[i];
						if (sum == gs) {
							return gs;
						}
					}
					s++;

				} else {

					if (Math.abs(a[s] + a[e] + a[i] - gs) < mindiff) {
						mindiff = Math.abs(a[s] + a[e] + a[i] - gs);
						sum = a[s] + a[e] + a[i];
						if (sum == gs) {
							return gs;
						}
					}
					e--;
				}

			}
		}

		return sum;
	}
}
