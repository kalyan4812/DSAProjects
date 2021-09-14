package DPProblems;

import java.util.Arrays;
import java.util.Scanner;

public class B8_Slimes {

	/*
	 * There are N slimes lining up in a row. Initially, the i-th slime from the
	 * left has a size of ai.
	 * 
	 * 
	 * Taro is trying to combine all the slimes into a larger slime. He will perform
	 * the following operation repeatedly until there is only one slime:
	 * 
	 * Choose two adjacent slimes, and combine them into a new slime. The new slime
	 * has a size of x+y, where x and y are the sizes of the slimes before combining
	 * them. Here, a cost of x+y is incurred. The positional relationship of the
	 * slimes does not change while combining slimes.
	 * 
	 * Find the minimum possible total cost incurred.
	 */
	
	public static void main(String...strings) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long a[] = new long[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		db=new long[n+1][n+1];
		for(long x[]:db) {
			Arrays.fill(x,-1);
		}
		
		sum=new long[n+1][n+1]; // sum from i to j.
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
			 sum[i][j]=a[j]+((i==j)?0:sum[i][j-1]);	
			}
		}
		long ans=fun(a,0,n-1);
		System.out.println(ans);
		
	}

	static long db[][],sum[][];
	
	private static long fun(long[] a, int i, int j) {
		if(i==j) {
			return 0;
		}
		if(db[i][j]!=-1) {
			return db[i][j];
		}
		long min=Long.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			long tempans=fun(a,i,k)+fun(a,k+1,j)+sum[i][j];
			min=Math.min(min, tempans);
			db[i][j]=min;
		}
		return min;
	}
}
