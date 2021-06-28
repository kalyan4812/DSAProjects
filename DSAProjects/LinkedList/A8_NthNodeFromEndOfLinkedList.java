package LinkedList;

import java.util.Scanner;

import LinkedList.A7_MiddleOfLinkedList.Node;

public class A8_NthNodeFromEndOfLinkedList {
	public static void main(String... strings) {
		Node head = null;

		head = insertAtStart(50, head);
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);
		head = insertAtStart(10, head); // 10 20 30 40 50

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int p = getAnswer(head, n);
		System.out.println(p);

		int r = getAnswerBySlowAndFast(head, n);
		System.out.println(r);
	}

	// t(N).
	private static int getAnswerBySlowAndFast(Node head, int n) {
		if (head == null)
			return -1;

		Node slow = head, fast = head;
		for (int i = 1; i < n; i++) {
			if (fast == null)
				return -1;
			fast = fast.next;
		}
		if (fast == null)
			return -1;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	// T(N)
	private static int getAnswer(Node head, int n) {
		if (head == null)
			return -1;

		int len = 1;
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
			len++;
		}
		if (len < n) {
			return -1;
		}

		curr = head;
		int c = 1;
		while (c < (len - n + 1) && curr != null) {
			curr = curr.next;
			c++;
		}
		if (curr == null)
			return -1;

		return curr.data;
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
