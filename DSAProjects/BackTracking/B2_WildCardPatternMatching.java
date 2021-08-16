package BackTracking;

public class B2_WildCardPatternMatching {

	public static void main(String... strings) {
		// ?- any character
		// *- any length string including empty string.

		String s = "summer";
		String pattern = "s*e";

		// corner case s="sum",pat="sum***";

		boolean b = patternMatching(s, pattern, s.length(), pattern.length());
		System.out.print(b);
	}

	private static boolean patternMatching(String s, String pattern, int n, int m) {

		return helper(s, pattern, n, m, 0, 0);

	}

	private static boolean helper(String s, String pat, int n, int m, int i, int j) {
		if (i == n && j == m) {
			return true;
		}
		if (i == n) {

			while (j < m) {
				if (pat.charAt(j) != '*') {
					return false;
				}
				j++;

			}
			return true;
		}
		if (j == m) {
			return false;
		}

		if (pat.charAt(j) == '?') {
			return helper(s, pat, n, m, i + 1, j + 1);
		}
		if (pat.charAt(j) == '*') {
			return helper(s, pat, n, m, i + 1, j) || helper(s, pat, n, m, i, j + 1);
		}
		if (pat.charAt(j) != s.charAt(i)) {
			return false;
		}
		return helper(s, pat, n, m, i + 1, j + 1);
	}
}
