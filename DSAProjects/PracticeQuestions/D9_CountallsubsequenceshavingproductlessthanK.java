package PracticeQuestions;

public class D9_CountallsubsequenceshavingproductlessthanK {

	public static void main(String...strings) {
		
		int a[]= {1, 2, 3, 4};
		int k=10;
		
		int ans=fun(a,a.length,k);
		System.out.println(ans);
		
	}

	private static int fun(int[] a, int n, int k) {
		int dp[][]=new int[n+1][k+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j]=dp[i-1][j];
				
				if(a[i-1]<=j && a[i-1]>0) {
					dp[i][j]+=dp[i-1][j/a[i-1]]+1;
				}
			}
		}
		return dp[n][k];
	}
	
	
}
