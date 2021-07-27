package Stacks;

import java.util.Stack;

public class A9_PostfixToPrefix {
	public static void main(String... strings) {

		String s1 = "xyz*+";
		
		System.out.println(convert(s1));
	

	}

	private static String convert(String s) {
		StringBuilder sb=new StringBuilder();
		Stack<String> st=new Stack<>();
		for(char c:s.toCharArray()) {
			if(Character.isLetterOrDigit(c)) {
				st.push(c+"");
			}
			else {
				String s1="",s2="";
				if(!st.isEmpty()) {
				 s1=st.pop()+"";
				
				}
				else {
					System.out.println("Invalid");
					return null;
				}
				if(!st.isEmpty()) {
					s2=st.pop()+"";
				}
				else {
					System.out.println("Invalid");
					return null;
				}
				st.push(c+s2+s1+"");
				
			}
		}
		
		return st.peek();
	}
}
