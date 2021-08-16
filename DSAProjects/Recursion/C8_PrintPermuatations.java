package Recursion;

import java.util.HashSet;
import java.util.Set;

public class C8_PrintPermuatations {

	public static void main(String... strings) {
		String s = "abc";
		permu(s, "");

		String s2 = "aacc";
		permuWithoutReputation(s2, "");
	}

	static Set<Character> hs = new HashSet<>();
	private static void permuWithoutReputation(String s, String op) {
		if (s.length() == 0) {
			System.out.println(op);
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!hs.contains(c)) {
				String ros = s.substring(0, i) + s.substring(i + 1);
				permu(ros, op + c);
				hs.add(c);
			}
		}

	}

	private static void permu(String s, String op) {
		if (s.length() == 0) {
			System.out.println(op);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			String ros = s.substring(0, i) + s.substring(i + 1);
			permu(ros, op + c);
		}
	}
}
