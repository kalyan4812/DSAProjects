package LinkedList;

import java.util.Scanner;

public class A5_SortedInsertInLinkedList {

	public static void main(String... strings) {
		Node head = null;
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);
		head = insertAtStart(10, head); // 10 20 30 40

		printList(head);
		System.out.println();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		head = sortedInsert(head, n); // if n=12 -> 10 12 20 30 40.

		printList(head);
		System.out.println();

	}

	// O(N)
	private static Node sortedInsert(Node head, int n) {
		if (head == null) {
			return new Node(n, head);
		}
		if (n < head.data) {
			return insertAtStart(n, head);
		}
		Node curr = head;
		while (curr != null && curr.next != null && n > curr.next.data) {
			curr = curr.next;
		}
		Node x = new Node(n, null);
		x.next = curr.next;
		curr.next = x;
		return head;

	}

	// O(N)
	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

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
