package Stacks;

import java.util.Stack;

public class A3_ReverseStringUsingStack {

	public static void main(String...strings) {
		String s="ABCD";
		System.out.println(reverse(s));
	}

	private static String reverse(String s) {
		Stack<Character> st=new Stack<>();
		for(char c:s.toCharArray()) {
			st.push(c);
		}
		StringBuilder sb=new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.toString();
	}
}
