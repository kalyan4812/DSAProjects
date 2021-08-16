package Strings;

public class B5_ReverseVowelsOrderInString {

	public static void main(String... strings) {
		String s = "equation";
		fun(s, s.length());
	}

	
	//O(N/2)
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
}
