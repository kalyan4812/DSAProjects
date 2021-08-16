package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class B8_StockSpan {

	// ex: 100 80 60 70 60 75 85
	// ans: 1 1 1 2 1 4 6 // consecutively smaller to left including it.

	// idea find use nearest greater to left.
	public static void main(String... strings) {

		int a[] = { 100, 80, 60, 70, 60, 75, 85 };
		fun(a);
	}

	private static void fun(int[] a) {
		if (a.length == 0) {
			return;
		}
		Stack<Pair> st = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			if (st.isEmpty()) {
				al.add(-1);
			} else if (!st.isEmpty() && st.peek().value > a[i]) {
				al.add(st.peek().index);
			} else if (!st.isEmpty() && st.peek().value <= a[i]) {
				while (!st.isEmpty() && st.peek().value <= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					al.add(-1);
				} else {
					al.add(st.peek().index);
				}
			}
			st.push(new Pair(a[i], i));
		}

		for (int i = 0; i < al.size(); i++) {
			System.out.print(i - al.get(i) + " ");
		}

	}

	static class Pair {
		int value, index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
