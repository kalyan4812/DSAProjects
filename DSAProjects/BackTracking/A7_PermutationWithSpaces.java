package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class A7_PermutationWithSpaces {

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		fun(s.substring(1), s.charAt(0) + "");

		printUsingBackTracking(new StringBuilder(s), 0, new StringBuilder(""));
		System.out.println(al.toString());

		sc.close();

	}

	static ArrayList<String> al = new ArrayList<>();

	private static void printUsingBackTracking(StringBuilder s, int j, StringBuilder op) {
		if (j == s.length() - 1) {
			al.add(s.toString());
			return;
		}

		s.insert(j + 1, ' ');
		printUsingBackTracking(s, j + 2, op);
		s.deleteCharAt(j + 1);
		printUsingBackTracking(s, j + 1, op);

	}

	private static void fun(String input, String output) {

		if (input.isEmpty()) { // use empty instead of checking size==0,it is O(1) in most cases.
			System.out.println(output);
			return;
		}

		char c = input.charAt(0);
		input = input.substring(1);
		String ans = output + " " + c;
		String ans2 = output + c;
		fun(input, ans2);
		fun(input, ans);

	}
}
