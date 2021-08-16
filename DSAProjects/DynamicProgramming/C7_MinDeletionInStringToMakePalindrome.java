package DynamicProgramming;

public class C7_MinDeletionInStringToMakePalindrome {

	public static void main(String... strings) {

		String s1 = "agbcba";
		

		
		// idea: make a new string s2 which reverse of s1 ,and find lcs.
		// ans is sl.length-lcs.

		String s2=new StringBuilder(s1).reverse().toString();
		int k=tabulationSol(s1, s2, s1.length(), s2.length());
         System.out.print(k);
	}

	private static int tabulationSol(String s1, String s2, int m, int n) {
		
		return m-lcs(s1,s2,m,n);
	}
	
	private static int lcs(String s1, String s2, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];

		// Initialization.
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];

				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
}
