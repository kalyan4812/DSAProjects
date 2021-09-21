package Sorting;

import java.util.Arrays;

public class A4_MergeSortedArrays {

	public static void main(String...strings) {
		int[] a= {10,15,20,40};
		int[] b= {5,6,6,10,15};
		int m=a.length;
		int n=b.length;
		merge(a,b,m,n);
		System.out.println();
		mergeFunction(a,b,m,n);
		System.out.println();
		mergeFunctionWithoutDuplicates(a,b,m,n);
		
		
	}
	//O(m+n) ,no space ,no duplicates
	private static void mergeFunctionWithoutDuplicates(int[] a, int[] b, int m, int n) {
		int i=0,j=0;
		while(i<m && j<n) {
			if(a[i]<b[j] ) {
				if(i!=0 && a[i]==a[i-1] || a[i]==b[j]) {
					
				}
				else {
				System.out.print(a[i]+" ");
				}
				i++;
			}
			else {
                if(j!=0 && b[j]==b[j-1] || b[j]==a[i]) {
					
				}
				else {
				System.out.print(b[j]+" ");
				}
				j++;
			}
		}
		while(i<m) {
			if(i==0 ||a[i]!=a[i-1] ) {
			System.out.print(a[i]+" ");
			}
			i++;
		}
		while(j<n) {
			if(j==0 || b[j]!=b[j-1]) {
			System.out.print(b[j]+" ");
			}
			j++;	
		}
		
	}

	//O(m+n) ,no space
	private static void mergeFunction(int[] a, int[] b, int m, int n) {
		int i=0,j=0;
		while(i<m && j<n) {
			if(a[i]<b[j]) {
				System.out.print(a[i]+" ");
				i++;
			}
			else {
				System.out.print(b[j]+" ");
				j++;
			}
		}
		while(i<m) {
			System.out.print(a[i]+" ");
			i++;
		}
		while(j<n) {
			System.out.print(b[j]+" ");
			j++;	
		}
		
	}

	//O((n+m)*log(m+n)) ,space=t(m+n)
	private static void merge(int[] a, int[] b, int m, int n) {
		int c[]=new int[m+n];
		for(int i=0;i<m;i++) {
			c[i]=a[i];
		}
		for(int i=0;i<n;i++) {
			c[m+i]=b[i];
		}
		Arrays.sort(c);// time complexity nlogn
		
		for(int i=0;i<m+n;i++) {
			if(i!=0 && c[i]==c[i-1]) {
				//this condition to avoid duplicates
			}
			else {
			System.out.print(c[i]+" ");
			}
		}
		
	}
}
