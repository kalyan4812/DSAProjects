package Strings;

public class B5_ReverseVowelsOrderInString {

	public static void main(String... strings) {
		String s = "equation";
		fun(s, s.length());

		System.out.println(reverseVowels(s));
	}

	// O(N/2)
	private static void fun(String str, int n) {

		int s = 0, e = n - 1;
		char[] ch = str.toCharArray();
		while (s < e) {
			Character c1 = ch[s];
			Character c2 = ch[e];

			if (!checkVowel(c1)) {
				s++;
				continue;
			}
			if (!checkVowel(c2)) {
				e--;
				continue;
			}

			char temp = ch[s];
			ch[s] = ch[e];
			ch[e] = temp;

			s++;
			e--;

		}
		System.out.println(String.valueOf(ch));
	}

	private static boolean checkVowel(Character c) {
		if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U') {
			return true;
		}
		return false;
	}

	// other way.
	public  static String reverseVowels(String s) {
		int n = s.length();
		if (n == 0 || n == 1) {
			return s;
		}
		// make vowels pointer.

		StringBuilder s1 = new StringBuilder(s);

		int i = -1, j = n;
		while (i <= j) {

			do {
				i++;
				if (i >= j) {
					break;
				}
			}

			while (!checkVowel(s1.charAt(i)));

			do {
				j--;
				if (i >= j) {
					break;
				}
			}

			while (!checkVowel(s1.charAt(j)));

			if (i >= j) {
				break;
			}
			char c1 = s1.charAt(i);
			char c2 = s1.charAt(j);

			s1.setCharAt(i, c2);
			s1.setCharAt(j, c1);

		}

		return s1.toString();
	}

}
