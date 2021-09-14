package DPProblems;

import java.util.Arrays;
import java.util.Scanner;

public class B6_Deque {

	/*
	 * Initially, they are given a sequence a=(a1a2,..an ) Until a becomes empty,
	 * the two players perform the following operation alternately, starting from
	 * Taro:
	 * 
	 * Remove the element at the beginning or the end of a. The player earns x
	 * points, where x is the removed element.
	 * 
	 * Let X and Y be Taro's and Jiro's total score at the end of the game,
	 * respectively. Taro tries to maximize X−Y, while Jiro tries to minimize X−Y.
	 * 
	 * Assuming that the two players play optimally, find the resulting value of
	 * X−Y.
	 */

	public static void main(String...strings) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	
		long a[] = new long [n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		db=new long[n+1][n+1];
		for(long x[]:db) {
			Arrays.fill(x,-1);
		}

		long ans = fun(a, 0,n-1);
		System.out.println(ans);
		
		/*long ans2=fun(a,0,n-1,1);
		System.out.println(ans2);*/
	}
/* not finished
 * 
	private static long fun(long[] a, int i, int j, int turn) {

		if(i==j) {
			return (turn==1)?a[i]:0;
		}
		long p=0,q=0;
		if(turn==1) {
			p= Math.max(a[i]+fun(a,i+1,j,2), a[j]+fun(a,i,j-1,2));
			return p;
		}
		else {
			q= Math.min(fun(a,i+1,j,1),fun(a,i,j-1,1));
			return q;
		}
	//	return p-q;
		
	}
*/
	static long db[][];

	private static long fun(long[] a, int i, int j) {
		if (db[i][j] != -1) {
			return db[i][j];
		}
		if (i == j) {
			db[i][j] = a[i];
			return db[i][j];
		}
		return db[i][j] = Math.max(a[i] - fun(a, i + 1, j), a[j] - fun(a, i, j - 1));
	}
}
