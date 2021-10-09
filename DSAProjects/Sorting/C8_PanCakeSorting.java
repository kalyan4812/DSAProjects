package Sorting;

import java.util.ArrayList;
import java.util.List;

public class C8_PanCakeSorting {

	/*
	 * In one pancake flip we do the following steps:
	 * 
	 * Choose an integer k where 1 <= k <= arr.length. Reverse the sub-array
	 * arr[0...k-1] (0-indexed).
	 */
	// return k values so that array gets sorted.

	public static void main(String[] args) {
		int a[] = { 3, 2, 4, 1 };
		System.out.print(pancakeSort(a).toString()); // any valid answer.

	}

	public static List<Integer> pancakeSort(int[] a) {

		ArrayList<Integer> ans = new ArrayList<>();

		int n = a.length;

		for (int i = n - 1; i >= 0; i--) {
			int max = i;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] > a[max]) {
					max = j;
				}
			}

			if (max != i) {

				reverse(a, 0, max);
				ans.add(max + 1);

				reverse(a, 0, i);
				ans.add(i + 1);
			}

		}
		return ans;
	}

	public static void reverse(int a[], int i, int j) {

		while (i <= j) {

			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;

			i++;
			j--;
		}

	}
}
