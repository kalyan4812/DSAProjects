package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import LinkedList.C4_LruUsingDoublyLinkedList.Node;

public class C6_LruCacheBest {

	// all are O(1)
	static HashMap<Integer, Node> h = new HashMap<>();
	static int p;
	int capacity;

	static Node tail;

	public C6_LruCacheBest(int capacity) {
		this.capacity = capacity;
	}

	public static void main(String[] args) {

		C6_LruCacheBest l = new C6_LruCacheBest(4);
		Node head = null;
		head = l.get(10, head);
		l.print(head);
		head = l.get(20, head);
		l.print(head);
		head = l.get(10, head);
		l.print(head);
		head = l.get(30, head);
		l.print(head);
		head = l.get(40, head);
		l.print(head);
		head = l.get(50, head);
		l.print(head);
		head = l.get(30, head);
		l.print(head);
		head = l.get(40, head);
		l.print(head);
		head = l.get(60, head);
		l.print(head);
		head = l.get(30, head);
		l.print(head);

	}

	public Node get(int x, Node head) {
		if (h.containsKey(x)) {
			Node curr = h.get(x);
			if (curr.next == null && curr.prev == null) {
				head = null;
			} else if (curr.next == null && curr.prev != null) {
				curr.prev.next = null;
				tail = curr.prev;
			}
			if (curr.prev != null && curr.next != null) {
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
			}
			p--;

		}
		if (p == capacity) {
			if (tail != null) {
				Node k = tail.prev;
				tail.prev.next = null;
				tail.prev = null;
				tail = k;

			}
			p--;
			head = insert(x, head);

			return head;
		}
		head = insert(x, head);

		return head;
	}

	public static Node insert(int x, Node head) {
		Node temp = new Node(x);
		temp.next = head;
		temp.prev = null;
		if (head != null) {
			head.prev = temp;
		}

		if (tail == null) {
			tail = temp;
		}
		head = temp;
		p++;
		h.put(x, temp);
		return temp;
	}

	public static void print(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

}

interface Cache {
	void get(int key);

}
