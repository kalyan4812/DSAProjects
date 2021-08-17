package DynamicProgramming;

import java.util.Arrays;

public class E3_Evaluate_Expression_to_True_Boolean_Parenthesization {

	public static void main(String... strings) {

		String s1 = "T^F|F";

		int c = recursiveSol(s1, 0, s1.length() - 1, true);

		System.out.println(c);

		db = new int[s1.length() + 1][s1.length() + 1][2];
		for (int y[][] : db) {
			for (int x[] : y) {
				Arrays.fill(x, -1);
			}
		}

		int p = memozationSol(s1, 0, s1.length() - 1, true);

		System.out.println(p);

	}

	// -------------------------------------- Top Down solution--------------------------------------------

	static int db[][][];

	private static int memozationSol(String s, int i, int j, boolean b) {
		if (i > j) {
			return 0;
		}

		if (i == j) {
			if (b) {
				db[i][j][1] = (s.charAt(i) == 'T') ? 1 : 0;
				return db[i][j][1];
			} else {
				db[i][j][0] = (s.charAt(i) == 'F') ? 1 : 0;
				return db[i][j][0];
			}
		}
		if (db[i][j][b ? 1 : 0] != -1) {
			return db[i][j][b ? 1 : 0];
		}

		int ans = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int lt = (db[i][k - 1][1] != -1) ? db[i][k - 1][1] : memozationSol(s, i, k - 1, true);
			int rt = (db[k + 1][j][1] != -1) ? db[k + 1][j][1] : memozationSol(s, k + 1, j, true);
			int lf = (db[i][k - 1][0] != -1) ? db[i][k - 1][0] : memozationSol(s, i, k - 1, false);
			int rf = (db[k + 1][j][0] != -1) ? db[k + 1][j][0] : memozationSol(s, k + 1, j, false);

			if (s.charAt(k) == '^') {
				if (b) {
					ans = ans + lt * rf + lf * rt;
				} else {
					ans = ans + lt * rt + lf * rf;
				}
			} else if (s.charAt(k) == '&') {
				if (b) {
					ans = ans + lt * rt;
				} else {

					ans = ans + lf * rt + lt * rf + lf * rf;
				}
			} else if (s.charAt(k) == '|') {
				if (b) {
					ans = ans + lt * rt + lt * rf + lf * rt;
				} else {

					ans = ans + lf * rf;
				}
			}
			db[i][j][b ? 1 : 0] = ans;
		}
		return db[i][j][b ? 1 : 0];
	}

// -------------------------------------- Recursive solution--------------------------------------------

	private static int recursiveSol(String s, int i, int j, boolean b) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			if (b) {
				return (s.charAt(i) == 'T') ? 1 : 0;
			} else {
				return (s.charAt(i) == 'F') ? 1 : 0;
			}
		}
		int ans = 0, lt = 0, rt = 0, lf = 0, rf = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			lt = recursiveSol(s, i, k - 1, true);
			rt = recursiveSol(s, k + 1, j, true);
			lf = recursiveSol(s, i, k - 1, false);
			rf = recursiveSol(s, k + 1, j, false);

			if (s.charAt(k) == '^') {
				if (b) {
					ans = ans + (lt * rf) + (lf * rt);
				} else {
					ans = ans + (lt * rt) + (lf * rf);
				}
			} else if (s.charAt(k) == '&') {
				if (b) {
					ans = ans + (lt * rt);
				} else {

					ans = ans + (lf * rt) + (lt * rf) + (lf * rf);
				}
			} else if (s.charAt(k) == '|') {
				if (b) {
					ans = ans + (lt * rt) + (lt * rf) + (lf * rt);
				} else {

					ans = ans + (lf * rf);
				}
			}
		}

		return ans;
	}

}
