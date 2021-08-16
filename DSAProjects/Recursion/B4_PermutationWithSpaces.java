package Recursion;

import java.util.Scanner;

public class B4_PermutationWithSpaces {
	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		fun(s.substring(1), s.charAt(0)+"");

		

		sc.close();

	}

	private static void fun(String input, String output) {
		
		if(input.isEmpty()) {  // use empty instead of checking size==0,it is O(1) in most cases.
			System.out.println(output);
			return;
		}
		
		char c=input.charAt(0);
		input=input.substring(1);
		String ans=output+" "+c;
		String ans2=output+c;
		fun(input,ans2);
		fun(input,ans);
		
				
		
	}
}
