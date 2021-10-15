package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class D2_SubsetSums {

	/*
	 * Given a sequence of N (1 ≤ N ≤ 34) numbers S1, ..., SN (-20,000,000 ≤ Si ≤
	 * 20,000,000), determine how many subsets of S (including the empty one) have a
	 * sum between A and B (-500,000,000 ≤ A ≤ B ≤ 500,000,000), inclusive.
	 */
	
 
    // Driver code
    public static void main(String[] args)
    {
        int n =3;
        int a=-1;
        int b=2;
        int arr[]= {1,-2,3};
        System.out.println(fun(arr,n,a,b));
    }

	private static int fun(int[] arr, int n, int a, int b) {
		ArrayList<Integer> a1=new ArrayList<>();
		ArrayList<Integer> a2=new ArrayList<>();
		
		solve(arr,0,n/2-1,a1);
		solve(arr,n/2,n-1,a2);
		
		Collections.sort(a2);
		int count=0;
		
		for(int i=0;i<a1.size();i++) {
			
			int low=lower_bound(a2,a2.size(),a-a1.get(i));
			int high=upper_bound(a2,a2.size(),b-a1.get(i));
			
			count+=high-low;
		}
		return count;
	}

	private static void solve(int[] arr, int st, int e, ArrayList<Integer> a1) {
		
		int sum=0;
		int n=e-st+1;
		
		for(int i=0;i<(1<<n);i++) {
			sum=0;
			int j=st;
			int x=i;
			while(x!=0) {
				int l=x&1;
				if(l!=0) {
					sum+=arr[j];
				}
				j++;
				x=x>>1;
			}
			a1.add(sum);
		}
	}
    
	static int upper_bound(ArrayList<Integer> a2, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value >= a2.get(mid)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int lower_bound(ArrayList<Integer> a2, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= a2.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}
