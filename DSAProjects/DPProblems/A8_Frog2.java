package DPProblems;

import java.util.Arrays;

public class A8_Frog2 {

	// There are N stones, numbered 1,2,…,N. For each i (1≤i≤N), the height of Stone i is hi.
	
		// If the frog is currently on Stone i, jump to Stone i+1,i+2 ...i+k require cost=hi-hj.
		
		// Find the minimum possible total cost incurred before the frog reaches Stone N.
	
	public static void main(String... strings) {
	     
		int a[] = { 30 ,10, 60, 10, 60, 50 };
        int k=3;
		int ans = dpSol(a, a.length,k);
		System.out.println(ans);
	}

	private static int dpSol(int[] a, int n, int k) {
     
		int dp[]=new int[n];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		
		if(n>=2) {
			dp[1]=Math.abs(a[1]-a[0]);
		}
		for(int i=2;i<n;i++) {
			for(int j=1;j<=k;j++) {
			if(i>=j)	
			dp[i]=Math.min(dp[i-j]+Math.abs(a[i]-a[i-j]), dp[i]);
			
			}
		}
		
		return dp[n-1];
	}
}
