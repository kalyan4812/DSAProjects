package LinkedList;

import java.util.Scanner;

import LinkedList.B1_RemoveDuplicatesFromSortedLinkedList.Node;

public class B2_ReverseLinkedListInGroups {

	public static void main(String... strings) {
		Node head = null;

		head = insertAtStart(60, head);
		head = insertAtStart(50, head);
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);
		head = insertAtStart(10, head);

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		head = reverseUsingRecusrion(head, k);
		printList(head);

		head = reverseUsingIterative(head, k);
		printList(head);

	}

	//t(n)
	private static Node reverseUsingIterative(Node head, int k) {
		if (head == null)
			return head;

		Node curr = head;
		boolean firstgroup = true;
		Node prevfirst = null;
		while (curr != null) {

			Node prev = null;
			int count = 0;
			Node nextnode = null;
			Node first = curr;
			while (count < k && curr != null) {
				nextnode = curr.next;
				curr.next = prev;
				prev = curr;
				curr = nextnode;
				count++;
			}
			if (firstgroup) {
				head = prev;
				firstgroup = false;
			} else {
				prevfirst.next = prev;
			}
			prevfirst = first;
		}

		return head;
	}

	// O(N),O(N/k)-space.
	private static Node reverseUsingRecusrion(Node head, int k) {
		if (head == null)
			return head;

		Node curr = head;
		Node prev = null;
		int count = 0;
		Node nextnode = null;
		while (count < k && curr != null) {
			nextnode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextnode;
			count++;
		}

		if (nextnode != null) {
			Node x = reverseUsingRecusrion(nextnode, k);
			head.next = x;
		}

		return prev;

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
