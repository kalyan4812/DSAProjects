package BinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class B8_AllocateMinimumNoOfPages {

	public static void main(String... strings) {
		int a[] = { 10, 20, 30, 40 };
		int k = 2;

		// elements in array represent no of pages in books.
		// k is no of students.
		// note array can be unsorted also then also you can apply binary search.
		int p = fun(a, k);
		System.out.println(p);
	}

	
	//O(nlogn)
	private static int fun(int[] a, int k) {
		if(a.length<k) {
			return -1;
		}
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			max = Math.max(max, a[i]);
		}
		int sum = IntStream.of(a).sum();
		
		int l=max,h=sum;
		int res=-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(isValid(a,a.length,k,m)) {
				res=m;
				h=m-1;
			}
			else {
				l=m+1;
			}
			
		}
		return res;
	}

	private static boolean isValid(int[] a, int n, int k,int max) {
		int student=1;
		int sum=0;
		for(int i=0;i<n;i++) {
			sum=sum+a[i];
			if(sum>max) {
				student++;
				sum=a[i];
			}
			if(student>k) {
				return false;
			}
		}
		return true;
	}
}
