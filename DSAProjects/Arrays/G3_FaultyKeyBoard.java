package Arrays;

public class G3_FaultyKeyBoard {

	// on some keyboard ,when a character is pressed it will be printed multiple
	// number of times.
	// check given string can be possibly typed word.

	public static void main(String... strings) {

		String s1 = "mannu";
		String s2 = "mmannu"; // printed word.

		boolean b = fun(s1, s2);
		System.out.println(b);

	}

	private static boolean fun(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		if (m > n) {
			return false;
		}

		int i = 0, j = 0;

		while (i < m && j < n) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else if (i > 0 && s1.charAt(i - 1) == s2.charAt(j)) {
				j++;
			} else {
				return false;
			}
		}

		while (j < n) {
			if (s1.charAt(i - 1) != s2.charAt(j)) {
				return false;
			}
			j++;
		}
		return i < m ? false : true;
	}
}
