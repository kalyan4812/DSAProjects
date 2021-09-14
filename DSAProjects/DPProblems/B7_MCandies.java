package DPProblems;

import java.util.Arrays;
import java.util.Scanner;

public class B7_MCandies {

	/*
	 * There are N children, numbered 1,2,…,N.
	 * 
	 * They have decided to share K candies among themselves. Here, for each i
	 * (1≤i≤N), Child i must receive between 0 and ai candies (inclusive). Also, no
	 * candies should be left over.
	 * 
	 * Find the number of ways for them to share candies, modulo 109+7. Here, two
	 * ways are said to be different when there exists a child who receives a
	 * different number of candies.
	 */

	// idea:
	
	// c1,c2,c3..cn , f(i,k)=f(i-1,k)+f(i-1,k-1)+..f(i-1,k-a[i]).
	// base case f(1,j)=1 if j<=ai ,0 if j>ai.
	// but this gives tle.
	
	// other relation:
	
	//  f(i,k)=f(i-1,k)+f(i-1,k-1)+....f(i-1,k-ai).
	// f(i,k-1)=f(i-1,k-1)+f(i-1,k-20+....f(i-1,k-ai-1).
	
	// from both relations we can see f(i,k)=f(i,k-1)+f(i-1,k)-f(i-1,k-ai-1).
	
	
	
	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
       db=new int[n+1][n+1];
       for(int x[]:db) {
    	   Arrays.fill(x,-1);
       }
		int ans = fun(a, n,k);
		System.out.println(ans);
	}

	static int mod = (int) Math.pow(10, 9) + 7;

	static int db[][];
	private static int fun(int[] a, int n, int k) {
	
		int dp[][]=new int[n][k+1];
		for(int i=0;i<=k;i++) {
			dp[0][i]=(i>a[0])?0:1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=k;j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=dp[i][j-1]+dp[i-1][j]-((j-a[i]-1>=0)?dp[i-1][j-a[i]-1]:0);
					
				}
				if(dp[i][j]<0) {
				dp[i][j]=(dp[i][j]+mod)%mod;
				}
				else {
					dp[i][j]=dp[i][j]%mod;
				}
			}
		}
		return dp[n-1][k];
	}

}
