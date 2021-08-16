package DoublyLinkedList;

import DoublyLinkedList.A1_InsertAtFrontDLL.Node;

public class A3_ReverseDLL {
	public static void main(String... strings) {
		Node head = null;
		head = insertAtFront(30, head);

		head = insertAtFront(20, head);

		head = insertAtFront(10, head);

		head = insertAtFront(5, head);

		printList(head);

		head = reverseList(head);
		printList(head);
		
		head=reverseListUsingIterative(head);
		printList(head);

	}

	private static Node reverseListUsingIterative(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node prevs=null,curr=head;
		while(curr!=null) {
			Node nextnode=curr.next;
			curr.next=prevs;
			curr.prev=nextnode;
			prevs=curr;
			curr=nextnode;
		}
		
		return prevs;
	}

	private static Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node remain = reverseList(head.next);
		Node tail = head.next;
		tail.next = head;
		head.prev = tail;
		head.next = null;
		head = remain;

		return head;
	}

	private static Node insertAtFront(int x, Node head) {
		Node curr = new Node(x);
		if (head != null) {
			curr.next = head;
			head.prev = curr;
		}
		head = curr;
		return head;
	}

	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();

	}

	static class Node {
		int data;
		Node prev, next;

		Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
}
