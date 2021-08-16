package LinkedList;

import java.util.HashSet;
import java.util.Scanner;

import LinkedList.B2_ReverseLinkedListInGroups.Node;

public class B3_DetectLoopInLinkedList {
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

		boolean c = funUsingSpace(head);
		System.out.println(c);

		boolean d = funUsingFlyoidsCycleDetection(head);
		System.out.println(d);

		boolean b = funUsingModifyingRefrences(head);
		System.out.println(b);

	}

	// O(N)
	private static boolean funUsingFlyoidsCycleDetection(Node head) {
		if (head == null)
			return false;
		Node slow = head, fast = head;
		while ( fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	// O(N),O(N)
	private static boolean funUsingSpace(Node head) {
		if (head == null)
			return false;

		HashSet<Node> hs = new HashSet<>();
		Node curr = head;
		while (curr != null) {
			if (hs.contains(curr)) {
				return true;
			}
			hs.add(curr);
			curr = curr.next;
		}
		return false;
	}

	// O(N)
	private static boolean funUsingModifyingRefrences(Node head) {
		if (head == null)
			return false;

		Node temp = new Node(1, null);
		Node curr = head;
		while (curr != null) {
			if (curr.next == null) {
				return false;
			}
			if (curr.next == temp) {
				return true;
			}
			Node x = curr.next;
			curr.next = temp;
			curr = x;
		}

		return false;
	}

	// O(N2)
	private static boolean fun(Node head) {
		if (head == null)
			return false;
		Node curr = head;
		while (curr != null) {
			Node ref = curr;
			Node nextnode = curr.next;
			while (nextnode != null) {
				if (nextnode == ref) {
					return true;
				}
				nextnode = nextnode.next;
			}
			curr = curr.next;
		}
		return false;

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
