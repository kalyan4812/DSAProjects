package Hashing;

public class A3_KeyPoints {

	/*
	 * 
	 * Java HashTable uses Separate chaining technique to avoid collisions.
	 * -> Prints output from top to bottom of table,if multiple entries in one slot prints from right to left.
	 * -> O(1) all operations.
	 * -> Null key,value is not allowed.
	 * 
	 * */
	
	
	
	
	
	/*
	 * 1)
	 * -> HashSet implements set,uses hash table data structure.(All operations O(1) on average ,, add,remove,contains).(isEmpty,size() are O(1)).
	 * -> Null insertion is possible.
	 * -> Duplicates not allowed.
	 * -> insertion order is not preserved.
	 * -> To preserve insertion order use LinkedHashSet ,it uses hash table+linked list.
	 * -> Use Tree set to get sorted output,it uses Balanced tree data structure.(Null insertion not possible)
	 */
	
	/*
	 * 
	 * 2)-> HashMap implements Map,uses HashTable data structure.
	 *  ->  Insertion not preserved.
	 *  -> Not Synchronized.
	 *  - > To preserve insertion order use LinkedHashMap ,it uses hash table+linked list.
	 *  -> Identity hash map uses "==" for identification of duplicate keys.("==" means reference comparison)
	 *  -> WeakHashMap removes key from entries if gets initialized with null after insertion.(i.e Garbage Collectible)
	 *  -> TreeMap uses RED_BLACK TREE data structure,gives sorted output based on keys.
	 */
	
	/*
	 * -> For null key,hash code always  be Zero.
	 */
}
