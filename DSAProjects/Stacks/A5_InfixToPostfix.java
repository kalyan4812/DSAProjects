package Stacks;

import java.util.Stack;

public class A5_InfixToPostfix {

	public static void main(String...strings) {
		
		String s1="2+3*4";
		String s2= "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(convert(s1));
		System.out.println(convert(s2));
		
	}
	//working on gfg.

	private static String convert(String s) {
		StringBuilder sb=new StringBuilder();
		Stack<Character> st=new Stack<>();
		for(char c:s.toCharArray()) {
			if(Character.isLetterOrDigit(c)) {
				sb.append(c);
			}
			else if(c=='(') {
				st.push(c);
			}
			else if(c==')') {
				while(!st.isEmpty() && st.peek()!='(') {
					sb.append(st.pop());
				}
				st.pop();
				
				
			}
			else {
				while(!st.isEmpty() && getPriority(c)<=getPriority(st.peek())) {
					 sb.append(st.pop());
				}
				st.push(c);
			}
			
		}
		while (!st.isEmpty()){
            if(st.peek() == '(')
                return "Invalid Expression";
               sb.append(st.pop());
         }
		
		return sb.toString();
	}

	private static int getPriority(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
			
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
}
