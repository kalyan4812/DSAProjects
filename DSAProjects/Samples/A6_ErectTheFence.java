package Samples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class A6_ErectTheFence {

	public static void main(String... strings) {

		int a[][] = { { 1, 1 }, { 2, 2 }, { 2, 0 }, { 2, 4 }, { 3, 3 }, { 4, 2 } };
	
		int ans[][] = fun(a);

		for (int k[] : ans) {
			for (int p : k) {
				System.out.print(p + " ");
			}
			System.out.println();
		}
	}

	private static int[][] fun(int[][] a) {
		if (a == null || a.length == 0)
			return new int[][] {};

		Arrays.sort(a, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);

		Stack<int[]> st = new Stack<>();

		// scan from left to right find first part
		for (int i = 0; i < a.length; i++) {
			while (st.size() >= 2 && cop(st.get(st.size() - 2), st.peek(), a[i]) > 0) {
				st.pop();
			}
			st.push(a[i]);
		}
		st.pop();

		// scan from right to left find second part
		for (int i = a.length - 1; i >= 0; i--) {
			while (st.size() >= 2 && cop(st.get(st.size() - 2), st.peek(), a[i]) > 0) {
				st.pop();
			}
			st.push(a[i]);
		}

		Set<int[]> hs = new HashSet<>(st);

		Iterator<int[]> iterator = hs.iterator();
		int[][] ans = new int[hs.size()][2];
		for (int i = 0; i < hs.size(); i++)
			ans[i] = iterator.next();
		return ans;

	}

	// if result >0 then q-o located in counterclockwise direction of p-0
	// cross product.
	private static int cop(int[] o, int[] p, int[] q) {
		return (p[1] - o[1]) * (q[0] - o[0]) - (q[1] - o[1]) * (p[0] - o[0]);
	}

}
