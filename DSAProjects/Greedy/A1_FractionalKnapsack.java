package Greedy;

import java.util.Arrays;

public class A1_FractionalKnapsack {
	public static void main(String[] args) throws Exception {

		int n = 3;
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int cap = 50;
	

		double k = greedy(val, wt, cap, n);
		System.out.println(k);

	}

	private static double greedy(int[] val, int[] wt, int cap, int n) {

		Pair p[] = new Pair[n];

		for (int i = 0; i < n; i++) {
			p[i] = new Pair(val[i], wt[i]);

		}

		Arrays.sort(p, (c, d) -> Double.compare(d.vp, c.vp));

		double ans = 0.0;

		for (Pair h : p) {

			if (h.wt <= cap) {
				ans += h.val;
				cap = cap - h.wt;
			} else {

				double rem = (h.vp) * cap;
				ans += rem;
				break;
			}

		}

		return ans;
	}

	static class Pair {
		int val, wt;
		double vp;

		Pair(int val, int wt) {
			this.val = val;
			this.wt = wt;
			this.vp = val * 1.0 / wt;
		}
	}

	/*
	 * recursion fails,we have to find max by taking every fraction like 0 to 1 all
	 * small finite decimals. static double fun(int val[], int wt[], int cap, int n)
	 * {
	 * 
	 * if (n == 0 || cap == 0) { return 0; } if(cap<0) { return 0; }
	 * 
	 * double max = Integer.MIN_VALUE; int remwt=cap-wt[n-1]; double v = remwt*
	 * val[n - 1] / wt[n - 1]; max = Math.max(fun(val, wt, cap, n - 1), val[n - 1] +
	 * fun(val, wt, cap - wt[n - 1], n - 1)); if(v<val[n-1]) max = Math.max(max, v +
	 * fun(val, wt,remwt, n - 1)); if (wt[n - 1] <= cap) { int remwt=cap-wt[n-1];
	 * double v = remwt* val[n - 1] / wt[n - 1]; max = Math.max(fun(val, wt, cap, n
	 * - 1), val[n - 1] + fun(val, wt, cap - wt[n - 1], n - 1));
	 * 
	 * max = Math.max(max, v + fun(val, wt,remwt, n - 1)); }
	 * 
	 * else {
	 * 
	 * double v = cap* val[n - 1] / wt[n - 1]; max = Math.max(fun(val, wt, cap, n -
	 * 1), v + fun(val, wt,0, n - 1)); }
	 * 
	 * return max;
	 * 
	 * }
	 */
}
