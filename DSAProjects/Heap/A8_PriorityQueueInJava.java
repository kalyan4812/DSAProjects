package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class A8_PriorityQueueInJava {

	// implements minHeap data structure.
	
	public static void main(String...strings) {
		
		//MinHeap.
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		pq.add(10);
		pq.add(20);
		pq.add(5);
		
		System.out.println(pq.toString());
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq.peek());
		System.out.println(pq.toString());
		
		
		
		//MaxHeap.
        PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
		
		maxpq.add(10);
		maxpq.add(20);
		maxpq.add(5);
		
		System.out.println(maxpq.toString());
		System.out.println(maxpq.peek());
		System.out.println(maxpq.poll());
		System.out.println(maxpq.peek());
		System.out.println(maxpq.toString());
		
	}
}
