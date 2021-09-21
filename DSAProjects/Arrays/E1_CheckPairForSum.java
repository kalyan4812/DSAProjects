package Arrays;

import java.util.Arrays;
import java.util.HashSet;


public class E1_CheckPairForSum {

	public static void main(String...strings) {
		int []a= {12,3,7,1,9};
		int sum=10;
		check(a,sum);
		System.out.println();
		checkSum(a,sum);
		System.out.println();
		checkSumUsingHashing(a,sum);
	}

	//O(n),O(n)-space
	private static void checkSumUsingHashing(int[] a, int gsum) {
		HashSet<Integer> h=new HashSet<>();
		for(int i=0;i<a.length;i++) {
			if(h.contains(gsum-a[i])) {
				System.out.println("Elements "+(gsum-a[i])+" and "+a[i]+" make the given sum");
			}
			else {
				h.add(a[i]);
			}
		}
		
		
	}

	//O(nlogn)-only for sorted condition.
	private static void checkSum(int[] a, int gsum) {
		Arrays.sort(a);
		int s=0,e=a.length-1;
		while(s<=e) {
			int sum=a[s]+a[e];
			if(sum==gsum) {
				System.out.println("Elements "+a[s]+" and "+a[e]+" make the given sum");
				e--;
				s++;
			}
			else if(sum>gsum) {
				e--;
			}
			else {
				s++;
			}
			
		}
		
	}

	//O(n2)
	private static void check(int[] a, int sum) {
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(a[i]+a[j]==sum) {
					System.out.println("Elements "+a[i]+" and "+a[j]+" make the given sum");
				}
			}
		}
		
	}
}
