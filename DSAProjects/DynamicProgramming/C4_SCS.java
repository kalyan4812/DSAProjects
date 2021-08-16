package DynamicProgramming;

public class C4_SCS {

	// shortest common super sequence.
	public static void main(String... strings) {

		String s1 = "geek";
		String s2 = "eke";

		// sequence which contains both strings and should be short.

		// idea: it should not contain repetitive characters.

		int c = tabulationSol(s1, s2, s1.length(), s2.length());
		System.out.println(c);

	}

	private static int tabulationSol(String s1, String s2, int m, int n) {
		
		return m+n-lcs(s1,s2,m,n);
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
		String str = "";
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

				str = s1.charAt(i - 1) + str;
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					str = s2.charAt(j - 1) + str;
					j--;
				} else {
					str = s1.charAt(i - 1) + str;
					i--;
				} 
			}
			
			
		}
		
		while (i > 0)
        {
			str = s1.charAt(i - 1) + str;
            i--;
        }
 
        
        while (j > 0)
        {
        	str = s2.charAt(j - 1) + str;
            j--;
        }
        System.out.println("SCS : "+str);
		return dp[m][n];
	}
}
