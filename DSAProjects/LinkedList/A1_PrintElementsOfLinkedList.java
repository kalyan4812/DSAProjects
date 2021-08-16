package LinkedList;

public class A1_PrintElementsOfLinkedList {

	public static void main(String... strings) {
		Node head = null;
		head = insert(10, head);
		head = insert(20, head);
		head = insert(30, head);
		head = insert(40, head);

		printList(head);

		System.out.println();
		printUsingRecusrion(head);

	}

	// O(N),O(N+1)-stack.
	private static void printUsingRecusrion(Node head) {
		if (head == null)
			return;

		System.out.print(head.data + " ");
		printUsingRecusrion(head.next);

	}

	// O(N)
	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	public static Node insert(int data, Node head) {
		if (head == null) {
			return new Node(data, null);
		}
		Node x = new Node(data, head);
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
