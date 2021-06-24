package General;

public class A1_TimeComplexitiesOfJavaCollections {

	/*
	 * 
	 * 1) ArrayList :
	 * 
	 * add() – takes O(1) time. However, worst-case scenario, when a new array has to be created and all the elements copied to it, is O(n).
         * add(index, element) – in average runs in O(n) time
         * get() – is always a constant time O(1) operation
         * remove() – runs in linear O(n) time. We have to iterate the entire array to find the element qualifying for removal
         * indexOf() – also runs in linear time. It iterates through the internal array and checking each element one by one. So the time complexity for this operation always requires O(n) time
         * contains() – implementation is based on indexOf(). So it will also run in O(n) time
	 * 
	 */
	
	
	
	/*
	 * 2) LinkedList :
	 * 
	 * add() – appends an element to the end of the list. So it only updates a tail, therefore O(1) constant-time complexity.
         * add(index, element) – in average runs in O(n) time
         * get() – searching for an element takes O(n) time
         * remove(element) – to remove an element, only pointers have to be updated. This operation is O(1).
         * remove(index) – to remove an element by index, we first need to find it, therefore the overall complexity is O(n)
         * contains() – also has O(n) time complexity
	 * 
	 * 
	 */
	
	
	/*
	 * 3) HashMap-prints based on index in hash table, LinkedHashMap-prints in same order as inserted, IdentityHashMap, WeakHashMap, EnumMap and ConcurrentHashMap.
	 * 
	 *  get(),put(),containsKey(),remove()-O(1) average until rehashing is not done .(worst case-O(l) ,if there is a collision) l=length of linked list.
	 *  
	 * Important note: After Java 1.8 ,after reaching a threshold value=8,it uses Balanced tree to store items if there is a collision instead of linked list,so worst case
	 *   time complexity will be O(log(l))
	 * 
	 *  isEmpty(),size()-O(1)
	 * 
	 * 
	 * -> TreeMap and ConcurrentSkipListMap the put(), get(), remove(), containsKey() operations time is O(log(n)). 
	 * 
	 * -> hash code for null key is zero.
	 * -> Balanced tree left group smaller values,right group larger values.
	 */
	
	
	
	/*
	 * 4) HashSet, LinkedHashSet, and EnumSet the add(), remove() and contains() operations cost constant O(1) time.  
	 * 
	 * -> TreeSet , ConcurrentSkipListSet has O(log(n)) time complexity.
	 * 
	 */
	
	
	
      /* 5) CopyOnWriteArrayList :
       * add() – depends on the position we add value, so the complexity is O(n)
       * get() – is O(1) constant time operation
       * remove() – takes O(n) time
       * contains() – likewise, the complexity is O(n)
       * 
       * -> CopyOnWriteArraySet, the add(), remove() and contains() methods have O(n) average time complexity.
       */
}
