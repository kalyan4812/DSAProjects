package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class C9_MaxSumOfElementsIn2DGrid {

	public static void main(String... strings) {

		// sub grid with maximum sum of elements.
		int a[][] = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };

		int ans = maxSum(a, a.length, a[0].length);
		System.out.println(ans);
	}

	//O(m2*n)
	
	static int s=0,e=0;
	private static int maxSum(int[][] a, int n, int m) {

		int res = Integer.MIN_VALUE;

		ArrayList<Integer> dp=new ArrayList<>(n);
	    int  tlc = 0, tlr = 0, brc = 0, brr = 0;
		for (int left = 0; left < m; left++) {
			 dp.clear();
			for(int k=0;k<n;k++) {
				dp.add(0);
			}
			for (int right = left; right < m; right++) {

				for (int i = 0; i < n; i++) {
					
					dp.set(i, dp.get(i)+a[i][right]);
					
				}
				
				int sum = maxsumsubarray(dp);
				
				if (sum > res) {
					res = sum;
					tlc = left;
					brc = right;
					tlr = s;
					brr = e;
				}
			}
		}
		System.out.println(tlr +" "+tlc+" "+brr+" "+brc);
		return res;
	}

	private static int maxsumsubarray(ArrayList<Integer> dp) {
		int sum = 0;
		int maxsum = Integer.MIN_VALUE;
		e = -1;

		int n = dp.size();
		int tempstart = 0;

		int i = 0;
		for (i = 0; i < n; i++) {
			sum += dp.get(i);
			if (sum < 0) {
				sum = 0;
				tempstart = i + 1;
			} else if (sum > maxsum) {
				maxsum = sum;
				s = tempstart;
				e = i;
			}
		}

		if (e != -1)
			return maxsum;

		maxsum = dp.get(0);
		s = e = 0;
		for (i = 1; i < n; i++) {
			if (maxsum < dp.get(i)) {
				maxsum = dp.get(i);
				s = e = i;
			}
		}
		return maxsum;
	}
}
