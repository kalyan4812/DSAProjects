package BinarySearchTree;

import java.util.TreeSet;

public class A6_CielingOnLeftSide {

	public static void main(String... strings) {
		int a[] = { 2, 8, 30, 15, 25, 12 };

		print(a);
		System.out.println();

		printUsingTree(a);

	}

	// O(nlogn)
	private static void printUsingTree(int[] a) {
		System.out.print(-1 + " ");
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(a[0]);
		for (int i = 1; i < a.length; i++) {// ->O(n)
			if (ts.ceiling(a[i]) != null && ts.contains(ts.ceiling(a[i]))) { // ->logn
				System.out.print(ts.ceiling(a[i]) + " ");
			} else {
				System.out.print(-1 + " ");
			}
			ts.add(a[i]);// ->logn
		}
	}

	// O(n2)
	private static void print(int[] a) {
		System.out.print(-1 + " ");
		for (int i = 1; i < a.length; i++) {
			int diff = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (a[j] >= a[i])
					diff = Math.min(diff, a[j] - a[i]);
			}

			if (diff == Integer.MAX_VALUE) {
				System.out.print(-1 + " ");
			} else {
				System.out.print(diff + a[i] + " ");
			}
		}
	}
}
