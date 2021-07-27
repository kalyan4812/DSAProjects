package Stacks;

import java.util.Stack;

public class A7_InfixToPrefix {
	public static void main(String... strings) {

		String s1="2+3*4";
		String s2= "a+b*(c^d-e)^(f+g*h)-i";
		String s3="(A - B/C) * (A/K-L)";
		String s4="A * B + C / D";
		System.out.println(convert(s1));
		System.out.println(convert(s2));
		System.out.println(convert(s3));
		System.out.println(convert(s4));
		
		//Algo:
		/*
		 * 1)reverse given string ,and convert '(' to ')' and viceversa.
		 * 2)getPostfix for new String
		 * 3) ans is reverse of the new String.
		 */

	}

	private static String convert(String s1) {
		s1=s1.replace(" ", "");
		StringBuilder sb=new StringBuilder(s1);
		sb=sb.reverse();
		char c[]=sb.toString().toCharArray();
		for(int i=0;i<c.length;i++) {
			if(c[i]=='(') {
				c[i]=')';
			}
			else if(c[i]==')') {
				c[i]='(';
			}
		}
		String newString=new String(c);
		String res= convertToPostfix(newString);
		sb=new StringBuilder(res);
		
		
		return sb.reverse().toString();
	}
	
	private static String convertToPostfix(String s) {
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
