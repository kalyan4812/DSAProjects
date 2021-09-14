package ImportantProblems;

import java.util.HashMap;

import ImportantProblems.A1_LRUCache.Node;

public class A2_LFUCache {

	
	static int capacity;
	static int size;
	static HashMap<Integer, Node> cache;
	static Node head;
	static Node tail;

	public A2_LFUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		size = 0;
		head.next = tail;
		tail.prev = head;

	}

	public static void main(String... strings) {
		//A1_LRUCache lru = new A1_LRUCache(5);

	}

	static void addNodeAtHead(Node node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
		return;
	}

	static void removeNode(Node node) {
		Node x = node.prev;
		Node y = node.next;
		x.next = y;
		y.prev = x;

	}

	static void moveToHead(Node node) {
		removeNode(node);
		addNodeAtHead(node);
	}

	static void put(int key, int value) {
		if (!cache.containsKey(key)) {
			Node n = new Node(key, value);
			cache.put(key, n);
			addNodeAtHead(n);
			size++;
			if (size > capacity) {
				int x = removeFromTail();
				size--;
				cache.remove(x);
			}
		} else {
			Node n = cache.get(key);
			n.val = value;
			moveToHead(n);
		}
	}

	static int get(int key) {
		if (!cache.containsKey(key)) {
			return Integer.MIN_VALUE;
		}
		Node n = cache.get(key);
		moveToHead(n);

		return n.val;

	}

	static int removeFromTail() {
		int key = tail.prev.key;
		removeNode(tail.prev);
		return key;

	}

	public static class Node {
		int key, val;
		Node prev, next;
		int count;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
			count=1;
		}
	}
}
