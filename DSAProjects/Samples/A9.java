package Samples;

import java.util.ArrayList;
import java.util.HashMap;

public class A9 {

	public static void main(String... strings) {

		int m = 2;
		int k = 5;

		int a[] = { 1, 4, 2, 3 };

		long ans = fun(a, m, k);
		System.out.println(ans);

	}

	private static long fun(int[] a, int m, int k) {
		int n = a.length;

		ArrayList<Integer> al = new ArrayList<>();

		for (int p : a) {
			al.add(p);
		}
		ArrayList<Integer> al2 = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			al2.addAll(al);
		}
		System.out.println(al2);
		return count(al2, n, k) + count2(al2, n, k);
	}

	private static long count2(ArrayList<Integer> al, int n, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			sum += al.get(i);
			if (sum == k) {
				count++;
			}
			if (hm.containsKey(sum - k)) {
				count += hm.get(sum - k);
			}

			hm.put(sum, hm.getOrDefault(sum, 0) + 1);

		}

		return count;
	}

	public static long count(ArrayList<Integer> al, int n, int k) {
		int start = 0, end = 0, sum = al.get(0), count = 0;
		while (start < n && end < n) {
			if (sum < k) {
				end++;
				if (end >= start)
					count += end - start;
				if (end < n)
					sum += al.get(end);
			} else {
				sum -= al.get(start);
				start++;
			}
		}
		return count;
	}

}
