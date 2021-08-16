package Arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class A3_LongestSubArrayWithSumK {

	public static void main(String...strings) {
		int a[]= {4,1,1,1,2,3,5};
		int sum=5;
		fun(a,a.length,sum);
		
		fun2(a,a.length,sum);
	}

	
	
	//O(N),O(N)-space works for negative also.
	private static void fun2(int[] a, int n, int sum) {
		 int e = 0, curr_sum = 0,max=0;
		  int finalstart=0,finalend=0;
			Map<Integer, Integer> map = new HashMap<>();
			while (e < n) {
				curr_sum = curr_sum + a[e];
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
			System.out.println(max+" FROM "+finalstart+" to "+finalend);
		
	}


	//O(N)
	private static void fun(int[] a, int n, int sum) {
		int s=0,e=0,max=0;
		int curr_sum=0;
		int finalstart=0,finalend=0;
		while(e<n) {
			curr_sum=curr_sum+a[e];
			if(curr_sum==sum) {
				
				if(e-s+1>max) {
					max=e-s+1;
					finalstart=s;
					finalend=e;
				}
			}
			while(curr_sum>sum) {
				curr_sum=curr_sum-a[s];
				s++;
			}
			e++;
		}
		
		System.out.println(max+" FROM "+finalstart+" to "+finalend);
	}
}
