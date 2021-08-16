package BinarySearch;

import java.util.Scanner;

public class A4_CountOccuranceInSortedArray {
	public static void main(String...strings) {
		int a[]= {1,10,10,10,20,20,40};
		Scanner sc=new Scanner(System.in);
		int ele=sc.nextInt();
		
		int k=count(a,ele);
		System.out.println(k);
		
		
	
	}

	//O(logn)
	private static int count(int[] a, int ele) {
		
		int fo=firstOccurance(a,ele);
		if(fo==-1) {
			return 0;
		}
		else {
			return lastOccurance(a,ele)-fo+1;
		}
		
	}
	
	//O(logn)
		private static int lastOccurance(int[] a, int ele) {
			int n=a.length;
			int l=0,h=n-1;
			while(l<=h) {
				int m=l+(h-l)/2;  // to avoid overflow of int size.
				if(a[m]==ele) {
					if(m!=n-1 && a[m+1]==a[m]) {
						l=m+1;
					}
					else {
						return m;
					}
				}
				else if(ele<a[m]) {
					h=m-1;
				}
				else {
					l=m+1;
				}
			}
			return -1;
		}


		//O(logn)
		private static int firstOccurance(int[] a, int ele) {
			int n=a.length;
			int l=0,h=n-1;
			while(l<=h) {
				int m=l+(h-l)/2;  // to avoid overflow of int size.
				if(a[m]==ele) {
					if(m!=0 && a[m-1]==a[m]) {
						h=m-1;
					}
					else {
						return m;
					}
				}
				else if(ele<a[m]) {
					h=m-1;
				}
				else {
					l=m+1;
				}
			}
			return -1;
		}
}
