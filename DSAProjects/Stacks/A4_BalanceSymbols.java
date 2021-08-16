package Stacks;

import java.util.Stack;

public class A4_BalanceSymbols {

	public static void main(String... strings) {
		String s1 = "([])";
		String s2 = "[{]}";
		System.out.println(isBalanced(s1));
		System.out.println(isBalanced(s2));

	}

	//perfect works for all cases in gfg.
	private static boolean isBalanced(String s) {
		if (s.isEmpty()) {
			return false;
		}
		Stack<Character> st = new Stack<>();
		for (char c : s.toCharArray()) {
			if ((c == '(') || (c == '[') || (c == '{')) {
				st.push(c);
			} else {
				if (st.isEmpty())
					return false;

				char k = st.pop();
				if (!isMatching(c, k)) {
					return false;
				}

			}
		}
		if(!st.isEmpty()) {
			return false;
		}
		return true;
	}

	private static boolean isMatching(char c, char k) {
		if (k == '(' && c == ')') {
			return true;
		} else if (k == '[' && c == ']') {
			return true;
		} else if (k == '{' && c == '}') {
			return true;
		} else {
			return false;
		}
	}
}
