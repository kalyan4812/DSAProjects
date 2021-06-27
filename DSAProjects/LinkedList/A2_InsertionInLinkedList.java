package LinkedList;

import LinkedList.A1_PrintElementsOfLinkedList.Node;

public class A2_InsertionInLinkedList {
	public static void main(String... strings) {
		Node head = null;
		head = insertAtStart(10, head);
		head = insertAtStart(20, head);
		head = insertAtStart(30, head);
		head = insertAtStart(40, head); //40 30 20 10

		head = insertAtPosition(50, head, 2); // 40 50 30 20 10
		printList(head);

		System.out.println();
		head = insertAtPosition(100, head, 3); // 40 50 100 30 20 10
		printList(head);
		
		
		System.out.println();
		head = insertAtPosition(120, head, 1); // 120 40 50 100 30 20 10
		printList(head);
		
		System.out.println();
		head = insertAtPosition(140, head, 8); // 120 40 50 100 30 20 10 140
		printList(head);
		
		System.out.println();
		head = insertAtPosition(160, head, 10); // 120 40 50 100 30 20 10 140 (cant be inserted).
		printList(head);
		
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
		//x.next=head;
		head = x;
		return head;
	}

	// O(pos)
	public static Node insertAtPosition(int data, Node head, int pos) {
		if (pos < 0) {
			System.out.println("Position can't be less than 1");
			return head;
		}

		if (head == null && pos > 1) {
			System.out.println("Position is greater than element exists");
			return head;
		}

		if (pos == 1) {
			return insertAtStart(data, head);
		} else {
			Node curr = head;
			int count = 1;
			while (count < pos-1 && curr != null) {
				curr = curr.next;
				count++;
			}
			if (curr == null) {
				System.out.println("Position is greater than element exists");
				return head;
			}
			Node x = new Node(data, null);
			x.next = curr.next;
			curr.next = x;
			return head;
		}

	}

	// O(N)
	public static Node insertAtEnd(int data, Node head) {
		if (head == null) {
			return new Node(data, null);
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		Node x = new Node(data, null);
		curr.next = x;
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
