package DPProblems;

import java.util.Scanner;

public class A7_Frog1 {

	
	// There are N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone i is hi.
	
	// If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2 require cost=hi-hj.
	
	// Find the minimum possible total cost incurred before the frog reaches Stone N.
	public static void main(String... strings) {
     
		int a[] = { 30 ,10, 60, 10, 60, 50 };

		int ans = dpSol(a, a.length);
		System.out.println(ans);
	}

	private static int dpSol(int[] a, int n) {
     
		int dp[]=new int[n];
		dp[0]=0;
		
		if(n>=2) {
			dp[1]=Math.abs(a[1]-a[0]);
		}
		for(int i=2;i<n;i++) {
			dp[i]=Math.min(dp[i-1]+Math.abs(a[i]-a[i-1]), dp[i-2]+Math.abs(a[i]-a[i-2]));
		}
		
		return dp[n-1];
	}
}
