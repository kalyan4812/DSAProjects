package Recursion;

import java.util.Scanner;

public class B6_LetterCaseChange {
	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		fun(s, "");

		

		sc.close();

	}

	private static void fun(String input, String output) {
		if(input.isEmpty()) {
			System.out.println(output);
			return;
		}
		Character c=input.charAt(0);
		input=input.substring(1);
		
		if(Character.isDigit(c)) {
			String ans2=output+c.toString();
			fun(input,ans2);
		}
		else {
			String ans1=output+c.toString().toLowerCase();
			String ans2=output+c.toString().toUpperCase();
			fun(input,ans1);
			fun(input,ans2);
		}
		
		
		
		
	}
}
