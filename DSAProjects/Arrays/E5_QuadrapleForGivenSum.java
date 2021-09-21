package Arrays;

import java.util.Arrays;

public class E5_QuadrapleForGivenSum {

	public static void main(String...strings) {
		int [] a= {1,2,-3,4,-2,-1,3};
		int sum=3;
		fun(a,a.length,sum);
	}

	//O(n3)+O(nlogn)=O(n3)
	private static void fun(int[] a, int n, int sum) {
		Arrays.sort(a);
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				 int newsum=sum-a[i]-a[j];
		    	 int  s=j+1,e=n-1;
		    	while(s<e) {
		    		int curr_sum=a[s]+a[e];
		    		if(curr_sum==newsum) {
		    			System.out.println(a[i]+" "+a[j]+" "+a[s]+" "+a[e]);
		    			s++;
		    			e--;
		    		}
		    		else if(curr_sum<newsum) {
		    			s++;
		    		}
		    		else {
		    			e--;
		    		}
		    	}
			}
		}
		
	}
}
