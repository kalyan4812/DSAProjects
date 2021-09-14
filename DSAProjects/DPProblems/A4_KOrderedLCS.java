package DPProblems;

public class A4_KOrderedLCS {

	/*
	 * In addition to the two sequences, an additional parameter k was introduced. A
	 * k-ordered LCS is defined to be the LCS of two sequences if you are allowed to
	 * change at most k elements in the first sequence to any value you wish to.
	 */

	public static void main(String... strings) {
		String s1 = "abcdgh";
		String s2 = "abedfhr";

		int k = 3;
		int a = recursiveSol(s1, s2, s1.length(), s2.length(), k);
		System.out.println(a);
	}

	private static int recursiveSol(String s1, String s2, int n, int m, int k) {
		if (m == 0 || n == 0) {

			return 0;
		}
		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + recursiveSol(s1, s2, n - 1, m - 1, k);
		} else {
			if (k > 0) {
				return 1 + recursiveSol(s1, s2, n - 1, m - 1, k - 1);
			} else {
				return 1 + Math.max(recursiveSol(s1, s2, n, m - 1, k), recursiveSol(s1, s2, n - 1, m, k));
			}
		}

	}
}
