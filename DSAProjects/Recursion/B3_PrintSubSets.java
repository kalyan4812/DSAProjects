package Recursion;

import java.util.Scanner;

public class B3_PrintSubSets {
	static int count = 1;

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		fun(s, "");

		count = 1;

		fun2(s);

		sc.close();

	}

	// IBH METHOD.??? Doubt how to solve??
	private static void fun2(String input) {
		if (input.length() == 0) {
			System.out.println((count++) + "" + input);
			return;
		}
		char c = input.charAt(0);
		String x=input.substring(1);
		System.out.println((count++) + " " +c+x);
		fun2(x);
		System.out.println((count++) + " "+c+x);
	}
	
	

	// O(2^n) IP-OP METHOD.
	private static void fun(String input, String ans) {

		if (input.isEmpty()) {
			System.out.println((count++) + " " + ans);
			return;
		}
		char p = input.charAt(0);

		input = input.substring(1);

		String s = ans + p;

		fun(input, s);
		fun(input, ans);

	}
}
