package LinkedList;

import LinkedList.B3_DetectLoopInLinkedList.Node;

public class B4_DetectLoopByModifyingNode {
	public static void main(String... strings) {
		Node head = null;
		Node last = null;

		head = insertAtStart(20, head);
		last = head;
		head = insertAtStart(12, head);
		head = insertAtStart(15, head);
		head = insertAtStart(10, head);
		last.next = head;

		boolean a = fun(head);
		System.out.println(a);

	}

	// O(N)
	private static boolean fun(Node head) {
		if (head == null)
			return false;
		Node curr = head;
		while (curr != null) {
			if (curr.visited) {
				return true;
			}
			curr.visited = true;
			curr = curr.next;
		}
		return false;
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
		boolean visited;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
			visited = false;
		}
	}

}
