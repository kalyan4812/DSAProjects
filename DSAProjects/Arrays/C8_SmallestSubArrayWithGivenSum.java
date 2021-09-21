package Arrays;

import java.util.HashMap;
import java.util.Map;

public class C8_SmallestSubArrayWithGivenSum {
	public static void main(String... strings) {
		int[] a = {4,2,5,3,1,8};
		int sum=9;
		fun(a,a.length,sum);
		fun2(a,a.length,sum);
	}

	
	//O(n),only for +ve numbers.
	private static void fun2(int[] a, int n, int s) {
		int i=0,j=0,curr_sum=0;
		int min=Integer.MAX_VALUE;
		while(j<n) {
			curr_sum=curr_sum+a[j];
			if(curr_sum==s) {
				min=Math.min(min, j-i+1);
			}
			while(curr_sum>s && i<=j) {
				curr_sum=curr_sum-a[i];
				i++;
				if(curr_sum==s) {
					min=Math.min(min, j-i+1);
				}
			}
			j++;
			
		}
		if(min!=Integer.MAX_VALUE) {
			System.out.println(min);
		}
		else {
			System.out.println("NO subarry with given sum");
		}
		
		
	}


	//O(n) ,O(n)-space
	private static void fun(int[] a, int n, int s) {
		int e=0,curr_sum=0;
		int min=Integer.MAX_VALUE;
		Map<Integer,Integer> m=new HashMap<>();
		while(e<n) {
			curr_sum=curr_sum+a[e];
			if(curr_sum==s) {
				min=Math.min(e+1, min);
			}
			if(m.containsKey(curr_sum-s)) {
				int index=m.get(curr_sum-s);
				min=Math.min(min,e-(index+1)+1);
			}
			m.put(curr_sum, e);
			e++;
		}
		if(min!=Integer.MAX_VALUE) {
			System.out.println(min);
		}
		else {
			System.out.println("NO subarry with given sum");
		}
		
	}
}
