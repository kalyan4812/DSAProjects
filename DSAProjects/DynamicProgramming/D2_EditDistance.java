package DynamicProgramming;

public class D2_EditDistance {

	public static void main(String... strings) {

		String s1 = "saturday"; // minimum insert,delete,replace to make s1 to s2.
		String s2 = "sunday";

		int a = recurSol(s1, s2, s1.length(), s2.length());
		System.out.println(a);
		
		
		int b = tabSol(s1, s2, s1.length(), s2.length());
		System.out.println(b);

	}

	
	//t(mn)
	private static int tabSol(String s1, String s2, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];

		// Initialization.
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0) {
					dp[i][j] =j ;
				}
				if(j==0) {
					dp[i][j]=i;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j]=dp[i-1][j-1];
				} else {
					dp[i][j] =1+ Math.min(dp[i-1][j-1],Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}
		return dp[m][n];
	}

	private static int recurSol(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0) {
			return (m==0)?n:m;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return recurSol(s1, s2, m - 1, n - 1);
		} else {
			int insert = recurSol(s1, s2, m, n - 1); // saturn ,sun => satur,su
			int del = recurSol(s1, s2, m - 1, n);  // satu,sun
			int replace = recurSol(s1, s2, m - 1, n - 1); // satun ,sun=> satu,su

			return 1+Math.min(Math.min(insert, del), replace);
		}

	}
}
