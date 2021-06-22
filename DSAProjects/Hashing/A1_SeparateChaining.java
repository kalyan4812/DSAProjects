package Hashing;

public class A1_SeparateChaining {

	private int tableSize; // size of hashtable.
	Node[] nodeArray;

	private class Node {
		private int value;
		private Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;

		}
	}

	public A1_SeparateChaining() {
		tableSize = 17; // prime number.
		nodeArray = new Node[tableSize];
		for (int i = 0; i < tableSize; i++) {
			nodeArray[i] = null;

		}
	}

	private int getHash(int key) {
		int hash = key;
		return hash % tableSize;
	}

	// O(l), l==length of linked list.
	public void add(int value) {
		int key = getHash(value);
		if (nodeArray[key] == null) {
			nodeArray[key] = new Node(value, nodeArray[key]);
		} else {
			nodeArray[key].next = new Node(value, null);
		}
	}

	// O(l), l==length of linked list.
	public boolean remove(int value) {
		int key = getHash(value);
		Node head = nodeArray[key];
		if (head != null && head.value == value) {
			nodeArray[key] = null;
			return true;
		}
		Node nextNode;
		while (head != null) {
			nextNode = head.next;
			if (nextNode != null && nextNode.value == value) {
				head.next = nextNode.next;
				return true;
			} else {
				head = nextNode;
			}
		}
		return false;
	}

	// O(l), l==length of linked list.
	public boolean find(int value) {
		int key = getHash(value);
		Node head = nodeArray[key];
		while (head != null) {
			if (head.value == value) {
				return true;
			}
			head = head.next;
		}
		return false;
	}

	public boolean contains(int value) {
		return find(value);
	}

	public void print() {
		for (int i = 0; i < tableSize; i++) {
			System.out.print("For Index  " + i + "  " + " Nodes are ::   ");
			Node head = nodeArray[i];
			while (head != null) {
				System.out.print(head.value + "  ");
				head = head.next;
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String... strings) {
		A1_SeparateChaining ht = new A1_SeparateChaining();
		for (int i = 500; i < 540; i++) {
			ht.add(i);
		}
		ht.print();

		if (ht.contains(93)) {
			System.out.println("93 is present");
		} else {
			System.out.println("93 is not  present");
		}

		ht.remove(93);
		ht.print();

		if (ht.contains(93)) {
			System.out.println("93 is present");
		} else {
			System.out.println("93 is not  present");
		}

	}

	/*
	 * Notes::
	 * 
	 * m = Number of slots in hash table n = Number of keys to be inserted in hash
	 * table
	 * 
	 * Load factor α = n/m
	 * 
	 * Expected time to search = O(1 + α)
	 * 
	 * Expected time to delete = O(1 + α)
	 * 
	 */

	/*
	 * Data Structures For Storing Chains: Linked lists Search: O(l) where l =length of linked list Delete: O(l) Insert: O(l) Not cache friendly 
	 * Dynamic Sized Arrays ( Vectors in C++, ArrayList in Java, list in Python) Search:O(l) where l = length of array Delete: O(l) Insert: O(l) Cache friendly Self
	 * Balancing BST ( AVL Trees, Red Black Trees) Search: O(log(l)) Delete: O(log(l)) Insert: O(l) Not cache friendly Java 8 onwards use this for HashMap
	 */
}
