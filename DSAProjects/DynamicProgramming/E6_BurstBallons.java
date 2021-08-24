package DynamicProgramming;

import java.util.Arrays;

public class E6_BurstBallons {

	public static void main(String... strings) {
		int a[] = { 3,1,5,8 };

		int k = recurSol(a,0, a.length-1);
		System.out.println(k);
		
		
		db=new int[a.length+1][a.length+1];
		for(int x[]:db) {
			Arrays.fill(x,-1);
		}
		int v = memoSol(a,0, a.length-1);
		System.out.println(v);

	}

	static int db[][];
	private static int memoSol(int[] a, int i, int j) {
		if(i>j) {
			return 0;
		}
		if(db[i][j]!=-1) {
			return db[i][j];
		}
		int max=0;
		
		for(int k=i;k<=j;k++) {
			int tempans=((k-1>0 && db[i][k-1]!=-1)?db[i][k-1]:memoSol(a,i,k-1))+((k+1<a.length && db[k+1][j]!=-1)?db[k+1][j]:memoSol(a,k+1,j))+(a[k]*((i-1<0)?1:a[i-1])*((j+1>=a.length)?1:a[j+1]));
			max=Math.max(max, tempans);
			db[i][j]=max;
		}
		return max;
	}

	private static int recurSol(int[] a, int i, int j) {
		if(i>j) {
			return 0;
		}
		
		int max=0;
		
		// bursting last balloon.k=last.
		for(int k=i;k<=j;k++) {
			int tempans=recurSol(a,i,k-1)+recurSol(a,k+1,j)+(a[k]*((i-1<0)?1:a[i-1])*((j+1>=a.length)?1:a[j+1]));
			max=Math.max(max, tempans);
		}
		return max;
	}
}
