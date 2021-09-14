package DPProblems;

import java.util.Arrays;
import java.util.Scanner;

public class B3_Coins {

	/*
	 * There are N coins, numbered 1,2,…,N. For each i (1≤i≤N), when Coin i is
	 * tossed, it comes up heads with probability pi ​ and tails with probability
	 * 1−pi.
	 * 
	 * 
	 * Taro has tossed all the N coins. Find the probability of having more heads
	 * than tails.
	 */

	// idea: it is same as probability of having atleast (n+1)/2 heads.

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double prob[] = new double[n+1];

		for (int i = 1; i <= n; i++) {
			prob[i] = sc.nextDouble();
		}
		
		db=new double[n+1][n+1];
		for(double x[]:db) {
			Arrays.fill(x,-1);
		}
		double ans=recur(prob,n,(n+1)/2);
		 System.out.println(
			      String.format("%.10f", ans));

	}

	static double db[][];
	private static double recur(double[] prob, int i, int x) {
		if(x==0) {
			return 1; // no head needed.
		}
		if(i==0) {
			return 0;
		}
		if(db[i][x]>-0.9) {
			return db[i][x];
		}
		db[i][x]= recur(prob,i-1,x-1)*prob[i]+recur(prob,i-1,x)*(1-prob[i]);
		return db[i][x];
	}
}
