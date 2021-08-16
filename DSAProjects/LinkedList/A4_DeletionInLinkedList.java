package LinkedList;

import java.util.Scanner;

import LinkedList.A3_SearchInLinkedList.Node;

public class A4_DeletionInLinkedList {

	public static void main(String... strings) {
		Node head = null;
		head = insertAtStart(10, head);
		head = insertAtStart(20, head);
		head = insertAtStart(30, head);
		head = insertAtStart(40, head); // 40 30 20 10

		head = deleteFromStart(head); // 30 20 10
		printList(head);
		System.out.println();

		head = deleteFromEnd(head); // 30 20
		printList(head);

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		head = deleteFromPosition(head, n); // for n==2 -> 30
		printList(head);
		System.out.println();
		
		int m = sc.nextInt();
		head = deleteFromPositionRecursively(head, m); // for n==1 -> null
		printList(head);

	}

	// O(N)
	private static Node deleteFromPosition(Node head, int pos) {
		if (pos < 1)
			return head;

		if (head == null) {
			return null;
		}
		if (pos == 1) {
			return head.next;
		}
		Node curr = head;
		int count = 1;
		while (count < pos - 1 && curr != null) {
			curr = curr.next;
		}
		if (curr == null) {
			return head;
		}
		curr.next = curr.next.next;

		return head;
	}
	
	//O(n),O(N)-space.
	private static Node deleteFromPositionRecursively( Node head, int pos) {
	    if(pos<1) return head;
	    if(head==null && pos>0) return head;
	    
	    if(pos==1) return head.next;
	    
	    head.next=deleteFromPositionRecursively(head.next,pos-1);
	    
		return head;
	}

	private static Node deleteFromEnd(Node head) {
		if (head == null)
			return head;

		if (head.next == null)
			return null; // if there is only one element.

		Node curr = head;
		while (curr.next != null && curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;

		return head;
	}

	// O(N)
	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	private static Node deleteFromStart(Node head) {
		if (head == null)
			return head;
		return head.next;

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
