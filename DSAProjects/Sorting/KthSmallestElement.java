package Sorting;

import java.util.Arrays;

public class KthSmallestElement {

	public static void main(String...strings) {
		int a[]= {10,5,30,1,2};
		int k=3;
		//2nd smallest element.
		smallest(a,a.length,k);
		smallestUsingLaumutoPartition(a,a.length,k);
	}

	private static void smallestUsingLaumutoPartition(int[] a, int n, int k) {
		int l=0,r=n-1;
		while(l<=r) {
			int p=laumutoPartition(a,l,r);
			if(p==k-1) {
					System.out.print(a[p]);
					return;
			}
			else if(p>k-1) {
				r=p-1;
			}
			else {
				r=p+1;
			}
		}
	}

	private static int laumutoPartition(int[] a, int l, int h) {
		int i=l-1;
		for(int j=l;j<=h-1;j++) {
			if(a[j]<a[h]) {
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp=a[i+1];
		a[i+1]=a[h];
		a[h]=temp;
		return i+1;
	}

	//O(nlogn)
	private static void smallest(int[] a, int length, int k) {
		Arrays.sort(a);
		System.out.println(a[k-1]);
		
	}
}
