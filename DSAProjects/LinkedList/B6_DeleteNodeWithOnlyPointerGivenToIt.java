package LinkedList;

import LinkedList.B5_DetectAndRemoveLoop.Node;

public class B6_DeleteNodeWithOnlyPointerGivenToIt {

	public static void main(String... strings) {
		Node head = null;
		Node last = null;

		head = insertAtStart(50, head);
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		last = head;
		head = insertAtStart(20, head);
		head = insertAtStart(10, head);

		printList(head);

		fun(last);
		printList(head);

	}

	//O(1)
	private static void fun(Node pointer) {
		Node curr = pointer;

		curr.data = curr.next.data;
		curr.next = curr.next.next;

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
