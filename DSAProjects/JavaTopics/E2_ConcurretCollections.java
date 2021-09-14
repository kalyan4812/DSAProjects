package JavaTopics;

import java.util.concurrent.ConcurrentHashMap;

public class E2_ConcurretCollections {

	/*
	 * Arraylist,linkedlist,hashset,treeset... etc are Not thread safe.
	 * 
	 * Vector,Hashtable,SynchronizedList,SynchronizedSet,SynchronizedMap are thread safe ,but they 
	 * provide low performance,since only one thread can operate.
	 * 
	 * while one thread is iterating a collection,if other thread modifies collection ,then
	 * we get ConcurrentModification Exception.
	 * 
	 */
	
	
	// ConcurrentCollections- ConcurrentHashMap,CopyOnWriteArrayList,CopyOnWriteArraySet.
	
    // Map-ConcurrentMap(interface)-ConcurrentHashMap.
	
	// methods of concurrentmap- putIfAbsent,put,remove,replace.
	
	
	/*
	 * ConcurrentHashMap-underlying datastructure is hashtable.
	 * 
	 * chm allows concurrent read and thread-safe update operations.
	 * 
	 * to perform read operations,thread won't require any lock,but to perform update operation thread requires lock
	 * ,but it is lock of only a particular part of map(segment lock/Bucket lock) instead of total map.
	 * Incase of hashtable,totalmap will be locked to achieve thread safety,so more time ,low performance.
	 * Incase of chm,only part of map will be locked ,so relatively high performance.
	 * 
	 * concurrent update is achieved by internally dividing map into smaller portions,which is defined by
	 * concurrency level.(By default-16).
	 * 
	 * chm allows any number of read operations but only 16 update operations at a time.while one thread iterating
	 * other thread can perform update operations.
	 * 
	 * for 16 size table,if first thread is operating on first bucket,other threads allow to perform in remaining buckets.
	 * so waiting time of threads is reduced.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String...strings) {
		
		ConcurrentHashMap chm=new ConcurrentHashMap(); // constructor can have capacity,capacity-fillratio,
		// capacity-fillratio-concurrencylevel,map.
		
		chm.put(101,"A");
		chm.put(102, "B");
		chm.putIfAbsent(103, "C");
		chm.putIfAbsent(101, "D");
		
		System.out.println(chm); // {101=A, 102=B, 103=C}
		chm.remove(101);
		System.out.println(chm);// {102=B, 103=C}
		chm.remove(102, "B");
		
		System.out.println(chm); // {103=C}
		
		chm.put(103, "E");
		System.out.println(chm); // {103=E}
	}
	
	
	
   
	
	
    	
	
	
	
}
