package Arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class A1_CountOccuranceOfAnagrams {

	public static void main(String...strings) {
		String text = "geeks for geeks";
		String pat = "egek";
		
		System.out.println(fun(text,text.length(),pat,pat.length()));
		
		System.out.println(fun2(text,text.length(),pat,pat.length()));
		
	}
	
	
	//O(N)
	private static int fun2(String text, int m, String pat, int n) {

		int counttext[] = new int[256];
		int countpat[] = new int[256];
		int count=0;
		for (int i = 0; i < n; i++) {
			counttext[text.charAt(i)]++;
			countpat[pat.charAt(i)]++;
		}
		for (int i = n; i < m; i++) {
			if (areSame(counttext, countpat)) {
			count++;
			}
			counttext[text.charAt(i)]++;
			counttext[text.charAt(i - n)]--;

		}

		return count;

	}

	private static boolean areSame(int[] counttext, int[] countpat) {
		for (int i = 0; i < 256; i++) {
			if (counttext[i] != countpat[i]) {
				return false;
			}
		}
		return true;
	}
	private static int fun(String str, int length, String pattern, int length2) {

		int count=0;
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
				count++;
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
		return count;

	}
}
