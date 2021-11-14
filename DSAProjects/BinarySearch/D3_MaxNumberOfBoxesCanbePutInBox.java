package BinarySearch;

import java.util.Arrays;

public class D3_MaxNumberOfBoxesCanbePutInBox {

	public static void main(String...strings) {
		int a[][]= {{12,12},{10,10},{6,6},{5,10}};
		
		int n=a.length;
		int m=a[0].length;
		
		int ans= solve(a,n,m);
		System.out.print(ans);
	}

	private static int solve(int[][] a, int n, int m) {
		Arrays.sort(a,(c,d)->(c[0]==d[0])?c[1]-d[1]:c[0]-d[0]);
		
		int heights[]=new int[n+1];
		Arrays.fill(heights, Integer.MAX_VALUE);
		heights[0]=Integer.MIN_VALUE;
		int res=0;
		for(int b[]:a) {
			int index=fun(heights,b[1]);
			if (heights[index] >= b[1]) {
	            heights[index] = b[1];
			}
	         res = Math.max(res, index);
		}
		return res;
	}

	private static int fun(int[] a,  int h) {
		         int l = 0;
			     int  r = a.length - 1;
			    int  res = 0;
			      while( l <= r) {
			       int  m = l + (r - l)/2;
			       int  cur_h = a[m];
			         if (cur_h < h) {
			            res = m;
			            l = m + 1;
			         }
			         else {
			            r = m - 1;
			         }
			      }
			      return res + 1;
	}
}
