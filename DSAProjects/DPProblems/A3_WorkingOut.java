package DPProblems;

public class A3_WorkingOut {
	/*Summer is coming! It's time for Iahub and Iahubina to work out, as they both want to look hot at the beach.
	The gym where they go is a matrix a with n lines and m columns. 
	Let number a[i][j] represents the calories burned by 
	performing workout at the cell of gym in the i-th line and the j-th column.

	Iahub starts with workout located at line 1 and column 1. 
	He needs to finish with workout a[n][m]. After finishing workout a[i][j], he can go to workout a[i + 1][j] or a[i][j + 1]. Similarly, Iahubina starts with workout a[n][1] and she needs to finish with workout a[1][m]. After finishing workout from cell a[i][j], she goes to either a[i][j + 1] or a[i - 1][j].

	There is one additional condition for their training. 
	They have to meet in exactly one cell of gym. 
	At that cell, none of them will work out. 
	They will talk about fast exponentiation (pretty odd small talk) and then both of them will move to the next workout.

	If a workout was done by either Iahub or Iahubina, it counts as total gain. 
	Please plan a workout for Iahub and Iahubina such as total gain to be as big as possible.
	Note, that Iahub and Iahubina can perform workouts with different speed, 
	so the number of cells that they use to reach meet cell may differs.*/
	
	public static void main(String...strings) {
		int a[][]= {{100,100,100},{100,1,100},{100,100,100}};
		int ans=fun(a,a.length,a[0].length);
		System.out.print(ans);
	}

	// dp1 claories gained when you reach to i,j.
	// dp2  claories gained when you reach to i,j.
	
	// O(NM)
	private static int fun(int[][] a, int n, int m) {
		int dp1[][]=new int[n+1][m+1];
		int dp2[][]=new int[n+1][m+1];
		int dp3[][]=new int[n+1][m+1];
		int dp4[][]=new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				dp1[i][j]=a[i-1][j-1]+Math.max((i-1>=0)?dp1[i-1][j]:0, (j-1>=0)?dp1[i][j-1]:0);
			}
		}
		
		for(int i=n;i>=1;i--) {
			for(int j=m;j>=1;j--) {
				dp2[i][j]=a[i-1][j-1]+Math.max((i+1<=n)?dp2[i+1][j]:0, (j+1<=m)?dp2[i][j+1]:0);
			}
		}
		
		for(int i=n;i>=1;i--) {
			for(int j=1;j<=m;j++) {
				dp3[i][j]=a[i-1][j-1]+Math.max((i+1<n)?dp3[i+1][j]:0,dp3[i][j-1]);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=m;j>=1;j--) {
				dp4[i][j]=a[i-1][j-1]+Math.max((i+1<=n)?dp4[i-1][j]:0, (j+1<=m)?dp4[i][j+1]:0);
			}
		}
		
		// consider all i,j as intersection point,take maximum.
		int ans=0;
		for(int i=2;i<n;i++) {
			for(int j=2;j<m;j++) {
				// 2 cases.
				int ans1=dp1[i-1][j]+dp2[i+1][j]+dp3[i][j-1]+dp4[i][j+1];
				int ans2=dp1[i][j-1]+dp2[i][j+1]+dp3[i+1][j]+dp4[i-1][j];
				ans=Math.max(ans, Math.max(ans2, ans1));
			}
		}
		
		
		return ans;
	}
}
