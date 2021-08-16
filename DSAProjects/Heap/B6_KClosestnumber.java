package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class B6_KClosestnumber {

	public static void main(String... strings) {
		int a[] = { 5, 6, 7, 8, 9 };
		int k = 3;
		int x = 7;
		 getNum(a, k, x); // k  closet num to x
	}

	
	//O(nlogk)
	private static void getNum(int[] a, int k, int x) {

		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<a.length;i++) {
			pq.add(new Pair(a[i],Math.abs(a[i]-x)));
			if(pq.size()>k) {
				pq.poll();
			}
		}
		

		while(!pq.isEmpty()) {
			System.out.print(pq.peek().num+" ");
			pq.poll();
		}
	}

	static class Pair  implements Comparable<Pair>{
		int num, diff;

		Pair(int num, int diff) {
			this.num = num;
			this.diff = diff;
		}

		@Override
		public int compareTo(Pair p) {
			if(diff<=p.diff) {
				return -1;
			}
			return 1;
		}
	}
}
