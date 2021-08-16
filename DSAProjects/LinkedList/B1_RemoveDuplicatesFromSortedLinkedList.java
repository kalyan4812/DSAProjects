package LinkedList;

import LinkedList.A9_ReverseALinkedList.Node;

public class B1_RemoveDuplicatesFromSortedLinkedList {
	public static void main(String... strings) {
		Node head = null;

		head = insertAtStart(30, head);
		head = insertAtStart(30, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);
		head = insertAtStart(20, head);
		head = insertAtStart(10, head);

		removeFun(head);
		printList(head);
	}

	// O(N)
	private static void removeFun(Node head) {
		if (head == null)
			return;

		Node curr = head;
		while (curr != null && curr.next != null) {

			if (curr.next.data == curr.data) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}

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
