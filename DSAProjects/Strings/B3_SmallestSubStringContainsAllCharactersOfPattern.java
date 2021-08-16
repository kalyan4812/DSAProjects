package Strings;

import java.util.HashMap;
import java.util.Map;

public class B3_SmallestSubStringContainsAllCharactersOfPattern {

	public static void main(String... strings) {
		String s1 = "badeabcaae";
		String s2 = "aabc";

		fun(s1, s1.length(), s2, s2.length());
	}

	private static void fun(String str, int m, String pattern, int n) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		int matchedElement = 0;
		int start = 0;
		int minlen = Integer.MAX_VALUE;
		int minsubstringstart = 0;

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);

			if (map.containsKey(currentChar)) {
				map.put(currentChar, map.get(currentChar) - 1);

				if (map.get(currentChar) == 0) {
					matchedElement++;
				}
			}

			while (matchedElement == map.size()) {
				if ((i - start + 1) < minlen) {
					minlen = (i - start + 1);
					minsubstringstart = start;
				}

				char charAtStart = str.charAt(start++);

				if (map.containsKey(charAtStart)) {
					if (map.get(charAtStart) == 0) {
						matchedElement--;
					}

					map.put(charAtStart, map.get(charAtStart) + 1);
				}
			}
		}

		if (minlen > m) {
			System.out.print("");
		} else {
			System.out.println(minlen);
			System.out.print(str.substring(minsubstringstart, minsubstringstart + minlen));
		}

	}
}
