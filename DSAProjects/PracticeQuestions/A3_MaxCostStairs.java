package PracticeQuestions;

public class A3_MaxCostStairs {

	public static void main(String... strings) {
		int arr[] = { 1,7,-1,3,-2,-4,6,10 };

		int n = arr.length;

		

		int ans = go(arr);
		System.out.println(ans);
	}

	//O(N)
	private static int go(int[] a) {
		int n=a.length;
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=a[0];
		dp[2]=a[0]+a[1];
		
		for(int i=3;i<n;i++) {
			dp[i]=Math.max(dp[i-1]+a[i-1], dp[i-2]+a[i-1]);
		}
		dp[n]=Math.max(dp[n-1]+a[n-1], dp[n-2]+a[n-1]);
		return dp[n];
	}
}
