package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class B2_BucketSort {

	
	public static void main(String...strings) {
		int [] a= {20,88,70,85,75,95,18,82,60};
		bucketSort(a,a.length,5);
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	private static void bucketSort(int[] a, int n,int k) {
		int max=a[0];
		for(int i=1;i<a.length;i++) {
			max=Math.max(max, a[i]);
		}
		max++;
		ArrayList<ArrayList<Integer>> al=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<k;i++) {
			al.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<n;i++) {
			int bi=k*a[i]/max;
			al.get(bi).add(a[i]);
		}
		for(int i=0;i<k;i++) {
			Collections.sort(al.get(i));
		}
		
		int index=0;
		for(int i=0;i<k;i++) {
			for(int j=0;j<al.get(i).size();j++) {
				a[index]=al.get(i).get(j);
				index++;
			}
		}
	}
}
