package BackTracking;

import java.util.ArrayList;

public class A1_PrintPermutations { // which does not contain ab as substring.

	public static void main(String... strings) {
		String str = "abc";

		ArrayList<String> s = printUsingRecusrion(str);
		System.out.print(s.toString());

		printUsingBackTracking(new StringBuilder(str), 0);

	}

	private static void printUsingBackTracking(StringBuilder s, int j) {
		if (j == s.length() - 1) {
			System.out.println(s);
			return;
		}
		for (int i = j; i < s.length(); i++) {
			if(isSafe(s,i,j)) {
			swap(s, i, j);
			printUsingBackTracking(s, j + 1);
			swap(s, i, j);
			}

		}

	}

	private static boolean isSafe(StringBuilder s, int i, int j) {
		if(s.isEmpty()) return false;
		
		if(i!=0 && s.charAt(i-1)=='a' && s.charAt(j)=='b') {
			return false;
		}
		
		if(s.length()-1==i && s.charAt(i)=='a' && s.charAt(i-1)=='b') {
			return false;
		}
		
		
		return true;
	}

	private static void swap(StringBuilder s, int i, int j) {
		char c = s.charAt(i);
		s.setCharAt(i, s.charAt(j));
		s.setCharAt(j, c);

	}

	private static ArrayList<String> printUsingRecusrion(String str) {

		if (str.length() <= 1) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add(str);
			return ans;
		}
		char ch = str.charAt(0);
		ArrayList<String> rem = printUsingRecusrion(str.substring(1));

		ArrayList<String> ans = new ArrayList<>();
		for (String st : rem) {
			for (int i = 0; i <= st.length(); i++) {

				String sb = st.substring(0, i) + ch + st.substring(i);
				if (sb.indexOf("ab") < 0) {
					ans.add(sb);
				}

			}
		}

		return ans;
	}
}
