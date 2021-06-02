package Strings;

import java.util.Stack;

public class A9_ReverseWordsInString {

	public static void main(String...strings) {
		String s="Hello World";
		reverse(s,s.length());
		
		System.out.println();
		fun(s,s.length());
		
		
		// to get output like (world Hello)
		System.out.println();
		fun2(s,s.length());
	}

	
	
	//O(N)
	private static void fun2(String s, int n) {
		StringBuilder finalString=new StringBuilder(s);
		finalString.reverse();
		reverse(finalString.toString(),n);
		
	}



	//O(N),O(N)-space
	private static void fun(String s, int n) {
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
			if(c==' ') {
			   while(!stack.isEmpty()) {
				   System.out.print(stack.pop());
			   }
			   System.out.print(" ");
			}
			else {
				stack.push(c);
			}
		}
		 while(!stack.isEmpty()) {
			   System.out.print(stack.pop());
		   }
		
	}


	//O(N)
	private static void reverse(String s, int n) {
	 
		StringBuilder temp=new StringBuilder();
		StringBuilder finalString=new StringBuilder();
		
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
			if(c==' ') {
			   finalString=finalString.append(temp).append(' ');
			   temp.setLength(0);;
			}
			else {
				temp.insert(0, c);
			}
		}
		finalString=finalString.append(temp);
		System.out.println(finalString);
		
	}
}
