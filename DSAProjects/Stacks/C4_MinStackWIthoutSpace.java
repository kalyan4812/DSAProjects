package Stacks;

import java.util.Stack;

public class C4_MinStackWIthoutSpace {
	static Stack<Integer> st = new Stack<>();
	static int min = -1;

	public static void main(String... strings) {

		push(6);
		push(3);
		push(1);
		push(2);
		System.out.println(getMin());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(getMin());

	}

	static void push(int val) {
		if (st.isEmpty()) {
			st.push(val);
			min = val;
		} else {
			if (val < min) {
				st.push(2 * val - min);
				min = val;
			} else {
				st.push(val);
			}

		}

	}

	static int pop() {

		if (st.isEmpty()) {
			return -1;
		}
		int res = -1;

		if (st.size() == 1) {
			return res;
		} else {
			if (st.peek() >= min) {
				res = st.pop();
				return res;
			} else {
				min = 2 * min - st.peek();
				res = st.pop();
				return (min + res) / 2;
			}

		}

	}

	static int getMin() {
		if (!st.isEmpty()) {
			return min;
		} else {
			return -1;
		}
	}
}
