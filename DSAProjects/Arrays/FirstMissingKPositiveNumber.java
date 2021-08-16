package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FirstMissingKPositiveNumber {
	public static void main(String... strings) {
		int[] a = { -2, 11, 1, -3, 2, 8, 4 };
		int k = 5;
		funUsingSort(a, a.length, k);
		System.out.println();
		fun(a, a.length, k);
	}

	// O(max)-space,O(Nlogn)-time
	private static void funUsingSort(int[] a, int n, int num) {
		Arrays.sort(a);
		int i = 0;
		int count[] = new int[a[n - 1] + 1];
		while (a[i] < 0) {
			i++;
		}
		for (int k = i; k < n; k++) {

			count[a[k]]++;

		}
		int printcount = 0;
		for (int p = 1; p < count.length; p++) {
			if (count[p] == 0 && printcount < num) {
				System.out.print(p + " ");
				printcount++;
			}
		}

	}

	//O(n),O(n)-space
	private static void fun(int[] a, int n, int k) {

		int min = 1;
		int i = 0;
		ArrayList<Integer> al = new ArrayList<>();
		HashSet<Integer> othernum = new HashSet<>();
		while (i < n) {
			int index = a[i] - min;
			if (a[i] > 0 && a[i] <= n && a[i] != a[index]) {

				int temp = a[i];
				a[i] = a[index];
				a[index] = temp;

			} else {
				i++;
			}
		}
		int j;
		for (j = 0; j < n & al.size() < k; j++) {
			if (a[j] != j + 1) {
				al.add(j + 1);
				othernum.add(a[j]);
			}
		}
		for (int p = j; al.size() < k; p++) {
			if (!othernum.contains(p + 1)) {
				al.add(p + 1);
			}
		}
		System.out.print(al.toString());

	}
}
