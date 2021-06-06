package Strings;

import java.util.HashMap;
import java.util.Map;

public class A5_FindPermutaationOfPaatternExistInText {

	public static void main(String... strings) {
		String text = "geeks for geeks";
		String pat = "egek";
		boolean b = fun(text, text.length(), pat, pat.length());
		System.out.println(b);

		boolean b2 = fun2(text, text.length(), pat, pat.length());
		System.out.println(b2);

		
		//print index of all anagrams.
		fun3(text, text.length(), pat, pat.length());
	}

	private static void fun3(String str, int length, String pattern, int length2) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		int matchedElement = 0;
		int start = 0;

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);

			if (map.containsKey(currentChar)) {
				map.put(currentChar, map.get(currentChar) - 1);

				if (map.get(currentChar) == 0) {
					matchedElement++;
				}
			}

			if (matchedElement == map.size()) {
				System.out.print(start + " ");
			}

			if (i >= pattern.length() - 1) {
				char charAtStart = str.charAt(start++);

				if (map.containsKey(charAtStart)) {
					if (map.get(charAtStart) == 0) {
						matchedElement--;
					}

					map.put(charAtStart, map.get(charAtStart) + 1);
				}
			}

		}

	}

	// O(N+M),O(M)-space.
	private static boolean fun2(String str, int length, String pattern, int length2) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		int matchedElement = 0;
		int start = 0;

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);

			if (map.containsKey(currentChar)) {
				map.put(currentChar, map.get(currentChar) - 1);

				if (map.get(currentChar) == 0) {
					matchedElement++;
				}
			}

			if (matchedElement == map.size()) {
				return true;
			}

			if (i >= pattern.length() - 1) {
				char charAtStart = str.charAt(start++);

				if (map.containsKey(charAtStart)) {
					if (map.get(charAtStart) == 0) {
						matchedElement--;
					}

					map.put(charAtStart, map.get(charAtStart) + 1);
				}
			}

		}

		return false;
	}

	// O(N)-window method.
	private static boolean fun(String text, int m, String pat, int n) {

		int counttext[] = new int[256];
		int countpat[] = new int[256];
		for (int i = 0; i < n; i++) {
			counttext[text.charAt(i)]++;
			countpat[pat.charAt(i)]++;
		}
		for (int i = n; i < m; i++) {
			if (areSame(counttext, countpat)) {
				return true;
			}
			counttext[text.charAt(i)]++;
			counttext[text.charAt(i - n)]--;

		}

		return false;

	}

	private static boolean areSame(int[] counttext, int[] countpat) {
		for (int i = 0; i < 256; i++) {
			if (counttext[i] != countpat[i]) {
				return false;
			}
		}
		return true;
	}

}
