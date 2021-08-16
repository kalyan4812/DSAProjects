package LinkedList;

import LinkedList.A5_SortedInsertInLinkedList.Node;

public class A6_GetSizeOfLinkedList {
	public static void main(String... strings) {
		Node head = null;

		getSize(head);
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);

		getSize(head);

		head = insertAtStart(10, head); // 10 20 30 40

		getSize(head);

		int p = getSizeRecursively(head);
		System.out.println("Size Recursively : " + p);
	}

	
	//O(N),O(N)-stack space.
	private static int getSizeRecursively(Node head) {
		if (head == null) {

			return 0;
		}

		return getSizeRecursively(head.next) + 1;

	}

	// O(N)
	private static void getSize(Node head) {
		if (head == null) {
			System.out.println("Empty List ");
			return;
		}
		Node curr = head;
		int count = 1;
		while (curr.next != null) {
			curr = curr.next;
			count++;
		}
		System.out.println("Size : " + count);

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
