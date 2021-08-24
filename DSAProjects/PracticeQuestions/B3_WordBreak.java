package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class B3_WordBreak {

	public static void main(String... strings) {

		String str = "heaven";

		ArrayList<String> al = new ArrayList<>(Arrays.asList("he", "a", "ab", "ven"));

		boolean b = wordBreak(str, str.length(), al, 0, str.length() - 1);
		System.out.print(b);

		boolean d = wordBreakDp(str, str.length(), al);
		System.out.print(d);

	}

	private static boolean wordBreakDp(String str, int len, ArrayList<String> al) {

		boolean dp[] = new boolean[len + 1];
		dp[0] = true;
		int i, j;

		for (i = 1; i <= len; i++) {
			for (j = 1; j <= i; j++) {
				if (al.contains(str.substring(i-j,i )) && dp[i - j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}

	private static boolean wordBreak(String str, int n, ArrayList<String> al, int i, int j) {

		if (i > j) {
			return true;
		}

		if (al.contains(str.substring(i, j + 1))) {

			return true;
		}

		boolean flag = false;

		for (int k = i + 1; k <= j; k++) {
			boolean b1 = wordBreak(str, n, al, i, k - 1);
			boolean b2 = wordBreak(str, n, al, k, j);

			if (b1 && b2) {
				flag = true;
				break;
			}
		}

		return flag;
	}
}
