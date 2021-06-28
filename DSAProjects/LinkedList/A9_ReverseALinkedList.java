package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

import LinkedList.A8_NthNodeFromEndOfLinkedList.Node;

public class A9_ReverseALinkedList {
	public static void main(String... strings) {
		Node head = null;

		head = insertAtStart(50, head);
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);
		head = insertAtStart(10, head); // 10 20 30 40 50

		reverse(head); // 50 40 30 20 10
		printList(head);

		head = reverseByReversingLinks(head); // 10 20 30 40 50
		printList(head);

		head = reverseUsingRecusrion(head, null); // 50 40 30 20 10
		printList(head);

		head = reverseUsingRecusrion2(head); // 10 20 30 40 50
		printList(head);
	}

	// O(N),O(N)
	private static Node reverseUsingRecusrion(Node head, Node prev) {
		if (head == null)
			return prev;

		Node nextnode = head.next;
		head.next = prev;

		return reverseUsingRecusrion(nextnode, head);
	}

	// O(N),O(N)
	private static Node reverseUsingRecusrion2(Node head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		Node newhead = reverseUsingRecusrion2(head.next);
		Node tail = head.next;
		tail.next = head;
		head.next = null;
		head = newhead;

		return newhead;

	}

	// t(N)
	private static Node reverseByReversingLinks(Node head) {
		if (head == null)
			return head;
		Node curr = head.next;
		if (curr == null)
			return head;

		curr = head;
		Node prev = null;
		Node nextnode;
		while (curr != null) {
			nextnode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextnode;
		}
		return prev;

	}

	// t(N),t(N)-space.
	private static void reverse(Node head) {
		if (head == null)
			return;
		ArrayList<Integer> al = new ArrayList<>();
		Node curr = head;
		while (curr != null) {
			al.add(curr.data);
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			curr.data = al.remove(al.size() - 1);
			curr = curr.next;
		}

	}

	// O(N)
	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	// O(1)
	public static Node insertAtStart(int data, Node head) {
		if (head == null) {
			return new Node(data, null);
		}
		Node x = new Node(data, head);
		// x.next=head;
		head = x;
		return head;
	}

	public static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
