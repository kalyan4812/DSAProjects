package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSort {

	public static void main(String... strings) {
		int a[] = { 1, 2, 4, 3 };
		int k = fun(a);
		System.out.print(k);
	}

	public static int fun(int a[]) {
		int n = a.length;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.put(a[i], i);
		}
		int[] temps = Arrays.copyOfRange(a, 0, n);
		Arrays.sort(temps);
		int count = 0;

		for (int i = 0; i < n; i++) {

			if (a[i] != temps[i]) {
				count++;
				int k = a[i];
				swap(a, i, m.get(temps[i]));
				m.put(k, m.get(temps[i]));
				m.put(temps[i], i);
			}

		}

		return count;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
