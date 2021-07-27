package Stacks;

import java.util.Stack;

public class B1_PrefixToPostfix {
	public static void main(String... strings) {

		String s1="+x*yz";
		System.out.println(convert(s1));
		
	}
	
	private static String convert(String s) {
		StringBuilder sb=new StringBuilder();
		Stack<String> st=new Stack<>();
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
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
				
				st.push(s1+s2+c);
				
			}
		}
		
		return st.peek();
	}
}
