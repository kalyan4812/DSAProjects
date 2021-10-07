package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

import Heap.B8_KClosestPointsToOrigin.Pair;

public class B9_ConnectRopesToMinimiseCost {

	public static void main(String...strings) {
		int a[]= {3,2,6,4}; // length of ropes.
		
		int mincost=getMinCost(a);
		System.out.print(mincost);
	}

	
	//O(nlogn)
	private static int getMinCost(int[] a) {
		int cost=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<a.length;i++) {
			pq.add(a[i]);
		}
		while(pq.size()>=2) {
			int x=pq.poll();
			int y=pq.poll();
			cost=cost+x+y;
			pq.add(x+y);
		}
		return cost;
	}
}
