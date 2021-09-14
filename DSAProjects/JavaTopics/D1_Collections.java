package JavaTopics;

public class D1_Collections {

	
	// Collection frame work-contains several classes and interfaces which can be used to represent a group of 
	// individual objects as single entity.
	
	// if we want to represent a group of individual objects as single entity we should go for collection.
	
	// collection-hold only objects,API feature,memory performance.
	// Arrays-can hold both primitive and objects,speed performance.
	
	/*
	 * collection are growable,can store any type of data,underlying datastructure,low performance.
	 */
	
	/*
	 * collection-interface,root of collection framework,defines most common method used by any collection object
	 *  there is no concrete class which implements Collection interface directly.
	 *  
	 *  Collections-utility class,to define several utility methods for collection objects,like sorting ,searching.
	 *  
	 *  
	 */
	
	/*
	 * 
	 * Collection (Interface)- List,Set,Queue (all are interfaces).
	 * 
	 * List- ArrayList,LinkedList,(Vector-Stack).
	 * 
	 * Set-(HashSet-LinkedHashSet),SortedSet(interface)-Navigableset(interface)-TreeSet.
	 * 
	 * Queue-PriorotyQueue,SynchronizedQueue,Dequeue,BlockingQueue-(PriorityBlockingQueue,LinkedBlockingQueue).
	 * 
	 * 
	 */
	
	// common methods of collection.
	
	/*
	 *  add,addAll,remove -> return boolean.
	 *  
	 *  removeAll,clear
	 *  
	 *  retainAll(Collection c)-except c ,all will be removed.
	 *  
	 *  contains,containsAll,isEmpty,size.
	 *  
	 *  
	 *  toArray.-> return Object[].
	 *  
	 *  iterator. -> return Iterator ,to get Objects one by one.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Map(Interface) not a child of interface collection.
	// if we want to represent group of objects as key-value pairs we use map.
	// Each key-value pair is an entry,hence map is considered as collection of entry objects.
	// Map interface contains Entry interface.
	
	
	/* 
	 * Map-(HashMap-LinkedHashMap),SortedMap(interface)-NavigableMap(interface)-TreeMap,WeakHashMap,IdentityHashMap,
	 * 
	 * Dictionary(abstract class)-HashTable,Properties.
	 * 
	 * 
	 */
	
	// common methods of Map
	
	/*
	 * put -> return old value.
	 * 
	 * putAll -> void.
	 * 
	 * get(key)
	 * 
	 * remove,containsKey,ContainsValue,isEmpty,size,clear.
	 * 
	 * keySet-return Set.
	 * 
	 * values -return Collection.
	 * 
	 * entrySet-return set.
	 */
	
	// Entry interface contains -getKey,getValue,setValue.
}
