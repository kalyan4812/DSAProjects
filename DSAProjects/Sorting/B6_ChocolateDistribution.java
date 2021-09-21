package Sorting;

import java.util.Arrays;

public class B6_ChocolateDistribution {

	public static void main(String...strings) {
		int a[]= {3,4,1,9,56,7,9,12};
		int m=5;
		fun(a,a.length,m);
	}
	///O(nlogn)

	private static void fun(int[] a, int n, int m) {
		if(m>n) {
			System.out.print("Not possible");
			return;
		}
		Arrays.sort(a);
		int min=a[m-1]-a[0];
		for(int i=1;i<n-m+1;i++) {
			min=Math.min(min, a[m+i-1]-a[i]);
		}
		System.out.print(min);
		
	}
}
