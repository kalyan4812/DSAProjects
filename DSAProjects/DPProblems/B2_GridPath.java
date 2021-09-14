package DPProblems;

import java.util.Scanner;

public class B2_GridPath {

	// . is empty square,# is wall ,total paths from 0,0 to n-1,m-1.
	
	public static void main(String...strings) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int a[][]=new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s=sc.next();
			for(int j=0;j<m;j++) {
				a[i][j]=(s.charAt(j)=='.'?1:0);
			//System.out.println(a[i][j]);		
			}
			
		}
		
		int ans=fun(a,n,m);
		System.out.println(ans);
		
	}

	static int mod=(int)Math.pow(10, 9)+7;
	private static int fun(int[][] a, int n, int m) {
		int dp[][]=new int[n][m];
		dp[n-1][m-1]=1; // empty subset.
		
		
		for(int i=n-1;i>=0;i--) {
			
			for(int j=m-1;j>=0;j--) {
				if(i==n-1 && j==m-1) {
					continue;
				}
				
				else if(a[i][j]==0) {
					dp[i][j]=0;
					continue;
				}
				dp[i][j]=((i==n-1)?0:dp[i+1][j])+((j==m-1)?0:dp[i][j+1]);
				dp[i][j]=dp[i][j]%mod;
			}
			
		}
		return dp[0][0];
	}
}
