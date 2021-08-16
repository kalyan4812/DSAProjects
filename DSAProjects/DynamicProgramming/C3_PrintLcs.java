package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class C3_PrintLcs {

	public static void main(String... strings) {

		String s1 = "abcdgh";
		String s2 = "abedfhr";

		tabulationSol(s1, s2, s1.length(), s2.length()); // print one lcs.

		printAllLcs(s1, s2, s1.length(), s2.length());

	}
	
	//////////////////////////////////////////////////////////

	private static void printAllLcs(String s1, String s2, int m, int n) {
		StringBox dp[][] = new StringBox [m + 1][n + 1];
		
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j]=new StringBox();
					dp[i][j].addString("");
				}
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					
					dp[i][j]=new StringBox();
					for(String p:dp[i-1][j-1].getAllStrings()) {
						String k=p+s1.charAt(i-1);
						dp[i][j].addString(k);
					}

					
				} else {
					dp[i][j]=new StringBox();
					int a=0;
					for(String x:dp[i-1][j].getAllStrings()) {
						a=x.length();
						break;
					}
					int b=0;
					for(String x:dp[i][j-1].getAllStrings()) {
						b=x.length();
						break;
					}
					if(a>b) {
						for(String p:dp[i-1][j].getAllStrings()) {
							dp[i][j].addString(p);
						}
					}
					else if(a<b){
						for(String p:dp[i][j-1].getAllStrings()) {
							dp[i][j].addString(p);
						}
					}
					else {
						for(String p:dp[i-1][j].getAllStrings()) {
							dp[i][j].addString(p);
						}
						for(String k:dp[i][j-1].getAllStrings()) {
							dp[i][j].addString(k);
						}
					}
					
				}
			}
		}
		
		
		
	}
	
	static class StringBox{
		 HashSet<String> al;
		public StringBox() {
			al=new HashSet<>();
			
		
		}
		void addString(String s){
			al.add(s);
		}
		HashSet<String> getAllStrings(){
			return al;
		}
		
	}

//--------------------------------------------------Bottom up-------------------------------------------------
	private static void tabulationSol(String s1, String s2, int m, int n) {
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
		String lcs = "";
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

				lcs = s1.charAt(i - 1) + lcs;
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					j--;
				} else if (dp[i][j - 1] < dp[i - 1][j]) {
					i--;
				} else {
					i--;
				}
			}
		}
		System.out.println(lcs);
	}
}
