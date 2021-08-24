package DynamicProgramming;

import java.util.Arrays;

public class A1_01KnapSack {

	public static void main(String... strings) {

		//int wt[] = { 1, 3, 4, 5 };
		//int val[] = { 1, 4, 5, 7 };
		//int cap = 7;
		
		int wt[] = { 4,8,5,3 };
		int val[] = { 5,12,8,1 };
		int cap = 10;

		int a = recursiveSol(wt, val, cap, wt.length);
		System.out.println(a);

		db = new int[cap + 1][wt.length + 1];
		for (int[] row : db) {
			Arrays.fill(row, -1);
		}

		int b = memozizationSol(wt, val, cap, wt.length);
		System.out.println(b);

		int c = tabulationSol(wt, val, cap, wt.length);
		System.out.println(c);
		
		// Both tabulation and memoi zation have same time complexity.
	}

// --------------------------------------------------Bottom up -------------------------------------------------
    
	//O(cap*n)
	private static int tabulationSol(int[] wt, int[] val, int cap, int n) {
        
		int dp[][]=new int[n+1][cap+1];
		
		//Initialization.
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<cap+1;j++) {
				if(i==0|| j==0) {
					dp[i][j]=0;
				}
			}
		}
		
		//conversion of recursion to iterative.
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<cap+1;j++) {
			  if(wt[i-1]<=j) {	
				  dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
			  }
			  else {
				  dp[i][j]=dp[i-1][j];
			  }
			}
		}
		
		return dp[n][cap];
	}

//--------------------------------------------------Top down -------------------------------------------------

	static int db[][];

	private static int memozizationSol(int[] wt, int[] val, int cap, int n) {
		if (n == 0 || cap == 0) {
			return 0;
		}
		if (db[cap][n] != -1) {
			return db[cap][n];
		}

		db[cap][n] = recursiveSol(wt, val, cap, n - 1);
		if (wt[n - 1] <= cap) {
			db[cap][n] = Math.max(db[cap][n], val[n - 1] + recursiveSol(wt, val, cap - wt[n - 1], n - 1));
		}
		return db[cap][n];
	}

	// ---------------------------------------------------Recursive---------------------------------------------
	
	//O(2^n)
	private static int recursiveSol(int[] wt, int[] val, int cap, int n) {
		if (n == 0 || cap == 0) {
			return 0;
		}

		int rem = recursiveSol(wt, val, cap, n - 1);
		if (wt[n - 1] <= cap) {
			return Math.max(rem, val[n - 1] + recursiveSol(wt, val, cap - wt[n - 1], n - 1));
		}
		return rem;
	}
}
