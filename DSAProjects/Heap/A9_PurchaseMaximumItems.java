package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A9_PurchaseMaximumItems {

	public static void main(String...strings) {
		int a[]= {1,12,5,111,200};
		int sum=10;
		
		fun(a,sum);
		
		funUsingHeap(a,sum);
	}

	
	//O(n)+O(res*logn)-for delete.
	// if you are allowed to modify array then O(1)-space else O(n).
	private static void funUsingHeap(int[] a, int sum) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int k:a) {
			pq.add(k);
		}
		
		int res=0;
		while(pq.peek()<=sum) {
		   sum=sum-pq.poll();
			res++;
		}
		System.out.println(res);
	}


	//O(nlogn)+O(n)=O(logn)
	private static void fun(int[] a, int sum) {
		Arrays.sort(a);
		int res=0;
		for(int i=0;i<a.length;i++) {
			
			sum=sum-a[i];
			
			if(sum<=0) {
				System.out.println(res);
				break;
			}
			res++;
		}
	}
}
