package JavaTopics;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class D8_Queue {

	// interface.
	// LinkedList implements Queue interface.
	
	
	/*
	 * if we want to represent a group of individual objects prior to processing then we should go for Queue.
	 */
	
	
	
	public static void main(String...strings) {
		
		Queue q=new LinkedList();
		
		q.add(1);
		q.offer(2); // offer==add.
		q.add(3);
		q.offer(4);
		
		System.out.println(q); // [1, 2, 3, 4]
		
		q.remove(2);
		System.out.println(q); // [1, 3, 4]
		
		System.out.println(q.peek()); // 1
		System.out.println(q.poll()); // 1 --> poll==remove.
		
		System.out.println(q); // [3, 4]
		
		System.out.println(q.element()); // 3 return head of queue.
		
		
	//-----------------------------------------------------------------------------
		
		PriorityQueue pq=new PriorityQueue(); // can take capacity/capacity-comparator/sortedset/collection
		
		pq.add(1);
		pq.offer(2);
		pq.add(3);
		pq.add(4);
		
		System.out.println(pq); // [1, 2, 3, 4]

		
		
		
		
	}
}
