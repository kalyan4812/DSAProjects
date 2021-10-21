package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class B9_MergeOverlappingIntervals {

	public static void main(String... strings) {
		int a[][] = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		System.out.println(a.length);// 4
		fun(a, a.length);
		System.out.println();
		fun2(a, a.length);
		System.out.println();
		fun3(a, a.length);

	}

	// other code-O(nlogn).
	public static int[][] mergeIntervals(int a[][]) {

		Arrays.sort(a, (c, d) -> c[0] - d[0]);

		ArrayList<int[]> al = new ArrayList<>();

		for (int k[] : a) {

			if (al.size() == 0) {
				al.add(k);
			} else {
				int prev[] = al.get(al.size() - 1);

				if (prev[1] > k[0]) {
					int max = Math.max(k[1], prev[1]);
					prev[1] = max;

				} else {
					al.add(k);
				}
			}

		}

		int[][] ans = new int[al.size()][2];
		for (int i = 0; i < al.size(); i++) {
			ans[i] = al.get(i);
		}

		return ans;

	}

	// O(nlogn)
	private static void fun3(int[][] a, int n) {
		Arrays.sort(a, new MyComparator());
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (a[index][1] >= a[i][0]) {
				a[index][1] = Math.max(a[index][1], a[i][1]);
				a[index][0] = Math.min(a[index][0], a[i][0]);
			} else {
				index++;
				a[index] = a[i];
			}
		}
		for (int i = 0; i <= index; i++) {
			for (int s : a[i]) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

	}

	public static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {

			return o1[0] - o2[0];
		}

	}

	public class Point {
		int start, end;

		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	// O(n3)
	private static void fun2(int[][] a, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (checkMerge(a[i], a[j])) {
					for (int k = 0; k < n; k++) {
						if (k == i) {
							if (k == n - 1) {
								n--;
							} else {
								while (k < n - 1) {
									a[k] = a[k + 1];
									k++;
								}
								n--;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	// O(n2) ,O(n)-space
	private static void fun(int[][] a, int n) {
		int index = 0;
		int[][] res = new int[n][];
		boolean[] merged = new boolean[n];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (checkMerge(a[i], a[j])) {
					merged[i] = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (!merged[i]) {

				res[index] = a[i];

				index++;
			}
		}

		for (int i = 0; i < index; i++) {
			for (int s : res[i]) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	private static boolean checkMerge(int[] A, int[] B) {
		if (A[1] < B[0] || B[1] < A[0]) {
			return false;
		}
		B[0] = Math.min(A[0], B[0]);
		B[1] = Math.max(A[1], B[1]);
		return true;
	}

}
