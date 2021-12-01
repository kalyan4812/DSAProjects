package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class B4_NextGreaterToRight {

	public static void main(String... strings) {
		int a[] = { 1, 3, 5,2,1,3,1 };
		fun(a);
	}

	private static void fun(int[] a) {
		if (a.length == 0) {
			return;
		}
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = a.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				al.add(-1);
			} else if (!st.isEmpty() && st.peek() > a[i]) {
				al.add(st.peek());
			} else if (!st.isEmpty() && st.peek() <= a[i]) {
				while (!st.isEmpty() && st.peek() <= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					al.add(-1);
				} else {
					al.add(st.peek());
				}
			}
			st.push(a[i]);
		}
		Collections.reverse(al);

		for (int k : al) {
			System.out.print(k + " ");
		}

	}
}
