package DynamicProgramming;

import java.util.Arrays;

public class E2_PalindromePartition {

	// minimum no of partitions ,so that all substrings will be palin drome.
	public static void main(String... strings) {

		String s1 = "aracecarb";

		int c = recursiveSol(s1, 0, s1.length() - 1);

		System.out.println(c);

		db = new int[s1.length()+1][s1.length()+1];
		for (int y[] : db) {
			Arrays.fill(y, -1);
		}

		int p = memozationSol(s1, 0, s1.length() - 1);

		System.out.println(p);

	}

	// -------------------------------------- Top Down solution--------------------------------------------

	static int db[][];

	private static int memozationSol(String s1, int i, int j) {
		if (i >= j) {
			return 0;
		}

		if (db[i][j] != -1) {
			return db[i][j];
		}

		if (isPalindrome(s1.substring(i, j + 1))) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			
			int tempans = ((db[i][k] != -1) ? db[i][k] : memozationSol(s1, i, k))
					+ ((db[k + 1][j] != -1) ? db[k + 1][j] : memozationSol(s1, k + 1, j)) + 1;
			min = Math.min(tempans, min);
			
			db[i][j] = min;
		}
		return db[i][j];
	}

	// -------------------------------------- Recursive solution--------------------------------------------
	private static int recursiveSol(String s1, int i, int j) {
		if (i >= j) {
			return 0;
		}

		if (isPalindrome(s1.substring(i, j + 1))) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int tempans = recursiveSol(s1, i, k) + recursiveSol(s1, k + 1, j) + 1;
			min = Math.min(tempans, min);
		}
		return min;
	}

	private static boolean isPalindrome(String s1) {

		return new StringBuilder(s1).reverse().toString().equals(s1);
	}
}
