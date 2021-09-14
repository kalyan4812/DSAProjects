package DPProblems;

import java.util.Scanner;

public class B5_KStones {

	/*
	 * There is a set A={a1,a2,...an} consisting of N positive integers. Taro and
	 * Jiro will play the following game against each other.
	 * 
	 * Initially, we have a pile consisting of K stones. The two players perform the
	 * following operation alternately, starting from Taro:
	 * 
	 * Choose an element x in A, and remove exactly x stones from the pile.
	 * 
	 * A player loses when he becomes unable to play. Assuming that both players
	 * play optimally, determine the winner.
	 */

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		String ans = fun(a, k);
		System.out.println(ans);
	}

	private static String fun(int[] a, int k) {
       boolean dp[]=new boolean[k+1];
       dp[0]=false;
       
       for(int i=1;i<=k;i++) {
    	   for(int val:a) {
    		   if(val>i) {
    			   continue;
    		   }
    		   if(dp[i-val]==false) {
    			   dp[i]=true;
    		   }
    		   
    	   }
       }
		return dp[k]?"First":"Second";
	}
}
