package DPProblems;

public class A2_SubsequencesWithGCDone {

	// increasing subsequences with gcd one.
	public static void main(String...strings) {
		int a[]= {1,2,3};
		
		int ans=fun(a,a.length);
		System.out.println(ans);
	}
	// dp[i][j] count of subsequences ending at i with gcd=j.
	
	//O(n3)
	private static int fun(int[] a, int n) {
		int dp[][]=new int[n][101];  // gcd based on question constraint.
		dp[0][a[0]]=1;
		
		int res=dp[0][1];
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(a[j]<a[i]) {
					for(int g=1;g<=100;g++) {
						int newgcd=gcd(g,a[i]);
						dp[i][newgcd]+=dp[j][g];
					}
				}
			}
			dp[i][a[i]]+=1;
			res+=dp[i][1];
		}
		return res;
	}
	private static int gcd(int n1, int n2) {
		if(n1<n2) {
			return gcd(n2,n1);
		}
		if(n2==0) {
			return n1;
		}
		return gcd(n2,n1%n2);
	}
	
	
	
}
