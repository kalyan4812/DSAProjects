package LinkedList;

import LinkedList.B9_PairwiseSwapNodes.Node;

public class C1_CloneALinkedListWithRandomPointers {

	public static void main(String... strings) {
		Node head = null;
		head = insertAtStart(10, head);
		head = insertAtStart(5, head);
		head = insertAtStart(20, head);
		head = insertAtStart(15, head);
		head = insertAtStart(20, head);

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
		Node random;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

}
