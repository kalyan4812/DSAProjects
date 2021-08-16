package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class A6_SubsetsInSet {

	public static void main(String... strings) {
		int a[] = { 1, 2, 3 };

		subset(a, a.length);
		System.out.println(hs.toString());
	}

	static HashSet<ArrayList<Integer>> hs = new HashSet<>();

	//O(2^n)
	private static void subset(int[] a, int n) {
		ArrayList<Integer> currset = new ArrayList<>();
		helper(a, n, currset, 0);
	}

	private static void helper(int[] a, int n, ArrayList<Integer> currset, int i) {
		if (i == n) {

			hs.add(new ArrayList<>(currset));
			return;
		}
	//	currset.add(a[i]);

		helper(a, n, currset, i + 1);

		currset.add(a[i]);
		//currset.remove(currset.size() - 1);

		helper(a, n, currset, i + 1);

	}
}
