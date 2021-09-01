package PracticeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E1_MaxAreaSubGridWithSumZero {

	public static void main(String... strings) {

		// sub grid with maximum sum of elements.
		 int a[][] = { { 9, 7, 16, 5 }, { 1, -6, -7, 3 },
                 { 1, 8, 7, 9 }, { 7, -2, 0, 10 } };

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
				
				int sum =fun2(dp,dp.size(),0);
				int area=sum*(right-left+1);
				if (area> res) {
					res = area;
					tlc = left;
					brc = right;
					tlr = s;
					brr = e;
				}
			}
		}
		//System.out.println(tlr +" "+tlc+" "+brr+" "+brc);
		return res;
	}

	// maxlength subarray with sum 0.
	private static int fun2(ArrayList<Integer> dp, int n, int sum) {
		 int e = 0, curr_sum = 0,max=0;
		  int finalstart=0,finalend=0;
			Map<Integer, Integer> map = new HashMap<>();
			while (e < n) {
				curr_sum = curr_sum + dp.get(e);
				if (curr_sum == sum) {
					//System.out.println(" 0  to " + e);
					max=Math.max(max,e+1);
					if(e+1>max) {
						finalstart=0;
						finalend=e;
						max=e+1;
					}
				}
				
				if(!map.containsKey(curr_sum)){  
	                map.put(curr_sum,e);
	            }
				if (map.containsKey(curr_sum - sum)) {
					int index = map.get(curr_sum - sum);
				
				//	System.out.println(index + 1 + " to " + e);
					if(e-index>max) {
						finalstart=index+1;
						finalend=e;
						max=e-index;
					}
			
				}
	            
				e++;
			}
			
			//System.out.println(max+" FROM "+finalstart+" to "+finalend);
			return max;
		
	}
}
