package LinkedList;

import LinkedList.B8_IntersectionPointOfLinkedList.Node;

public class B9_PairwiseSwapNodes {

	public static void main(String... strings) {
		Node head = null;
		head = insertAtStart(6, head);
		head = insertAtStart(5, head);
		head = insertAtStart(4, head);
		head = insertAtStart(3, head);
		head = insertAtStart(2, head);
		head = insertAtStart(1, head);

		

		head = swapUsingRecusrion(head);
		printList(head);
		
		head=swapUsingIterative(head);
		printList(head);

		 swap(head);
	}

	private static Node swapUsingIterative(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		
		Node curr = head.next.next;
		Node prev=head;
		head=head.next;
		head.next=prev;
		
		while(curr!=null && curr.next!=null) {
			Node y=curr.next.next;
			prev.next=curr.next;
			prev=curr;
			
			curr.next.next=curr;
			curr=y;
		}
		prev.next=curr;
		
		return head;
		
	}

	private static Node swapUsingRecusrion(Node head) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;

		Node start = swapUsingRecusrion(head.next.next);
		Node curr = head.next;
		head.next = start;
		curr.next = head;
		head = curr;

		return head;
	}

	// O(N),O(1)
	private static void swap(Node head) {
		if (head == null)
			return;
		if (head.next == null)
			return;

		Node curr = head;
		while (curr != null && curr.next != null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			curr = curr.next.next;

		}
		printList(head);

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
