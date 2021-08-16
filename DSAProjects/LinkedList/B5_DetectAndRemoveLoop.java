package LinkedList;

import LinkedList.B3_DetectLoopInLinkedList.Node;

public class B5_DetectAndRemoveLoop {
	public static void main(String... strings) {
		Node head = null;
		Node last = null;

		head = insertAtStart(20, head);
		last = head;
		head = insertAtStart(12, head);
		head = insertAtStart(15, head);
		head = insertAtStart(10, head);
		last.next = head;
		head = insertAtStart(40, head);

		detectAndRemove(head);

		detectAndRemove(head);
	}

	//O(N)
	private static void detectAndRemove(Node head) {
		if (head == null)
			return;
		Node slow = head, fast = head;
		boolean enteredloop = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {

				break;
			}
			enteredloop = true;

		}
		if (slow == fast && enteredloop) {

			int count = 1;
			Node meetpoint = slow;

			Node x = slow.next;
			while (x != null && x != meetpoint) {
				count++;
				x = x.next;

			}
			System.out.println("Loop exists with size :" + count);
		} else {
			System.out.println("No loop here");
			return;
		}
		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println("Start of the loop : " + fast.next.data);
		fast.next = null;

		System.out.println("Loop removed Now ");

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
