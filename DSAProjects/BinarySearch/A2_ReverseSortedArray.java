package BinarySearch;

import java.util.Scanner;

public class A2_ReverseSortedArray {
	public static void main(String...strings) {
		int a[]= {10,8,5,4,3,1};
		Scanner sc=new Scanner(System.in);
		int ele=sc.nextInt();
		
		fun(a,ele);
		
		
	}

	
	//O(logn)
	private static void fun(int[] a, int ele) {
	
		int n=a.length;
		int l=0,h=n-1;
		while(l<=h) {
			int m=l+(h-l)/2;  // to avoid overflow of int size.
			if(a[m]==ele) {
				System.out.println(m);
				break;
			}
			else if(ele<a[m]) {
				l=m+1;
			}
			else {
				h=m-1;
			}
		}
	}
}
