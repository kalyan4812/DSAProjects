package DPProblems;

import java.util.Scanner;

public class A9_Vacation {

	/*
	 * Taro's summer vacation starts tomorrow, and he has decided to make plans for
	 * it now.
	 * 
	 * The vacation consists of N days. For each i (1≤i≤N), Taro will choose one of
	 * the following activities and do it on the i-th day:
	 * 
	 * A: Swim in the sea. Gain ai points of happiness. B: Catch bugs in the
	 * mountains. Gain bi points of happiness. ​
	 * 
	 * C: Do homework at home. Gain ci points of happiness. ​
	 * 
	 * 
	 * As Taro gets bored easily, he cannot do the same activities for two or more
	 * consecutive days.
	 * 
	 * Find the maximum possible total points of happiness that Taro gains.
	 */

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		int c[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();

			System.out.print(a[i] + " " + b[i] + " " + c[i]);
			System.out.println();

		}

		// int ans=Math.max(a[0]+rec(a,b,c,0,1),
		// Math.max(b[0]+rec(a,b,c,1,1),c[0]+rec(a,b,c,2,1) ));
		int ans = rec(a, b, c, -1, 0);
		System.out.println(ans);

		int ans2 = dpSol(a, b, c, a.length);
		System.out.println(ans2);
	}

	private static int dpSol(int[] a, int[] b, int[] c, int n) {
   
		int dp[][]=new int[n][3];
		
		dp[0][0]=a[0];
		dp[0][1]=b[0];
		dp[0][2]=c[0];
		
		for(int i=1;i<n;i++) {
			
			dp[i][0]=a[i]+Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1]=b[i]+Math.max(dp[i-1][0], dp[i-1][2]);
			dp[i][2]=c[i]+Math.max(dp[i-1][1], dp[i-1][0]);
			
			
			
		}
		
		return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
	}

	private static int rec(int[] a, int[] b, int[] c, int t, int i) {
		if (i >= a.length) {
			return 0;
		}
		int p, q, r;
		p = q = r = Integer.MIN_VALUE;

		if (t == 0 || t == -1)
			p = a[i] + Math.max(rec(a, b, c, 1, i + 1), rec(a, b, c, 2, i + 1));

		if (t == 1 || t == -1)
			q = b[i] + Math.max(rec(a, b, c, 0, i + 1), rec(a, b, c, 2, i + 1));

		if (t == 2 || t == -1)
			r = c[i] + Math.max(rec(a, b, c, 0, i + 1), rec(a, b, c, 1, i + 1));

		return Math.max(p, Math.max(q, r));
	}
}
