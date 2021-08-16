package Recursion;

import java.util.Scanner;

public class B5_PermuatationWithCaseChange {
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
		String c=input.charAt(0)+"";
		input=input.substring(1);
		
		String ans1=output+c.toLowerCase();
		String ans2=output+c.toUpperCase();
		
		fun(input,ans1);
		fun(input,ans2);
		
		
		
	}
}
