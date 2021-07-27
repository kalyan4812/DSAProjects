package CircularLinkedList;

public class A1_PrintLL {
	public static void main(String... strings) {
		Node head = null;
		head = insertAtFront(30, head);
		printList(head);
		head = insertAtFront(20, head);
		printList(head);
		head = insertAtFront(10, head);
		printList(head);
		head = insertAtFront(5, head);
		printList(head);

		head = insertBySWapping(12, head);
		printList(head);

		head = insertAtEnd(20, head);
		printList(head);

		head = insertAtEndSwapping(25, head);
		printList(head);

		head = deleteHead(head);
		printList(head);

		head = deleteHeadBySwapping(head);
		printList(head);

		head = deleteKthNode(3, head);
		printList(head);
	}

	// O(K)
	private static Node deleteKthNode(int k, Node head) {
		if (head == null)
			return null;
		if (k == 1)
			deleteHeadBySwapping(head);
		Node curr = head;
		for (int i = 0; i < k - 2; i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		return head;
	}

	// O(1)
	private static Node deleteHeadBySwapping(Node head) {
		if (head == null)
			return null;
		if (head.next == head)
			return null;

		head.data = head.next.data;
		head.next = head.next.next;
		return head;
	}

	// O(N)
	private static Node deleteHead(Node head) {
		if (head == null)
			return null;
		if (head.next == head)
			return null;
		Node curr = head;
		while (curr != null && curr.next != head) {
			curr = curr.next;
		}
		curr.next = head.next;

		return curr.next;
	}

	// O(1)
	private static Node insertAtEndSwapping(int x, Node head) {

		Node curr = new Node(x);
		if (head == null) {
			curr.next = curr;
			return curr;
		} else {
			curr.next = head.next;
			head.next = curr;
		}
		// swap data
		int data = head.data;
		head.data = head.next.data;
		head.next.data = data;

		return curr;
	}

	// O(N)
	private static Node insertAtEnd(int x, Node head) {
		Node curr = new Node(x);
		if (head == null) {
			curr.next = curr;
			return curr;
		}
		Node temp = head;

		while (temp != null && temp.next != head) {
			temp = temp.next;
		}
		temp.next = curr;
		curr.next = head;
		return head;
	}

	// O(1)
	private static Node insertBySWapping(int x, Node head) {

		Node curr = new Node(x);
		if (head == null) {
			curr.next = curr;
			return curr;
		} else {
			curr.next = head.next;
			head.next = curr;
		}
		// swap data
		int data = head.data;
		head.data = head.next.data;
		head.next.data = data;

		return head;
	}

	// O(N)
	private static Node insertAtFront(int x, Node head) {

		Node curr = new Node(x);
		if (head == null) {
			curr.next = curr;
			return curr;
		}
		Node temp = head;

		while (temp != null && temp.next != head) {
			temp = temp.next;
		}
		temp.next = curr;
		curr.next = head;
		return curr;
	}

	private static void printList(Node head) {
		if (head == null)
			return;
		Node curr = head;
		System.out.print(curr.data + " ");
		head = head.next;
		while (head != null && head != curr) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();

	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;

		}
	}
}
