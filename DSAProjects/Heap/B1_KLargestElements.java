package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class B1_KLargestElements {

	public static void main(String...strings) {
		int a[]= {5,15,10,20,8};
		int k=2;
		funUsingMaxHeap(a,k);
		System.out.println();
		funUsingMinHeap(a,k);
	}

	
	//O(k)+O(n-klogk)+O(k)--better for corner cases.
	private static void funUsingMinHeap(int[] a, int k) {
	  
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			pq.add(a[i]);
		}
		
		for(int j=k+1;j<a.length;j++) {
			if(a[j]>pq.peek()) {
				pq.poll();
				pq.add(a[j]);
			}
		}
		
		System.out.print(pq.toString());
	}

	//O(n)+O(klogn)
	private static void funUsingMaxHeap(int[] a,int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int j:a) {
			pq.add(j);
		}
		
		while(k!=0) {
			System.out.print(pq.poll()+" ");
			k--;
		}
	
	}
}
