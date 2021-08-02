package Stacks;

import java.util.Stack;

public class C3_MinStackUsingSpace {

	static Stack<Integer> st = new Stack<>();
	static Stack<Integer> ss = new Stack<>();

	public static void main(String... strings) {
         push(10);
         push(20);
         push(2);
         push(36);
         System.out.print(getMin());
	}

	static void push(int val) {
		st.push(val);

		if (ss.isEmpty() || val <= ss.peek()) {
			ss.push(val);
		}
	}

	static int pop() {
		int res = st.pop();
		if (ss.peek() == res) {
			ss.pop();
		}
		return res;
	}
	
	static int getMin() {
		if(!ss.isEmpty()) {
			return ss.peek();
		}
		else {
			return -1;
		}
	}
}
