package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

import Heap.B7_TopKFrequentNumbers.Pair;

public class B8_KClosestPointsToOrigin {

	public static void main(String... strings) {
		int a[][] = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
		int k = 2;
		print(a, k);
	}

	//O(nlogk)
	private static void print(int[][] a, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<a.length;i++) {
			pq.add(new Pair(a[i][0],a[i][1],a[i][0]*a[i][0]+a[i][1]*a[i][1]));
			if(pq.size()>k) {
				pq.poll();
			}
		}
		while(!pq.isEmpty()) {
			
			System.out.println(pq.peek().x+" "+pq.peek().y);
			pq.poll();
			
		}
		
	}
	
	static class Pair implements Comparable<Pair> {
		int x,y;
		int dist;

		Pair(int x,int y, int dist) {
			this.x=x;
			this.y=y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair p) {
			if (dist <= p.dist) {
				return -1;
			}
			return 1;
		}
	}
}
