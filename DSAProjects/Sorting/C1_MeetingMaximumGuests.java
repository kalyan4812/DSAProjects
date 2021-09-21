package Sorting;

import java.util.Arrays;

public class C1_MeetingMaximumGuests {

	public static void main(String...strings) {
		int a[]= {800,700,600,500};
		int b[]= {840,820,830,530};
		fun(a,b,a.length);
		System.out.println();
		fun2(a,b,a.length);
	}

	
	//O(nlogn)
	private static void fun2(int[] a, int[] b, int n) {
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0,j=0,res=0,count=0;
		// same as merge function
		while(i<n && j<n) {
			if(a[i]<=b[j]) {
				count++;
				i++;
			}
			else {
				count--;
				j++;
			}
			res=Math.max(res, count);
		}
		System.out.println(res);
	}

	//O(n2)
	private static void fun(int[] a, int[] b, int n) {
		int res=0;
		for(int i=0;i<n;i++) {
			int count=1;
			for(int j=i+1;j<n;j++) {
				if(a[i]>=a[j] && a[i]<=b[j] || b[j]>=b[i] &&a[j]<=b[i] ) {
					count++;
				}
			}
			res=Math.max(res, count);
		}
		System.out.println(res);
	}
}
