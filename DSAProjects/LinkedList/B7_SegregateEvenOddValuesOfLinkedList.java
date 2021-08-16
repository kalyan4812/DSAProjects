package LinkedList;

import LinkedList.B6_DeleteNodeWithOnlyPointerGivenToIt.Node;

public class B7_SegregateEvenOddValuesOfLinkedList {

	public static void main(String... strings) {
		Node head = null;

		head = insertAtStart(25, head);
		head = insertAtStart(20, head);
		head = insertAtStart(15, head);

		head = insertAtStart(10, head);
		head = insertAtStart(5, head);

		printList(head);

		head = fun(head);
		printList(head);

		head = fun2(head);
		printList(head);

	}

	// O(N)
	private static Node fun2(Node head) {
		if (head == null)
			return head;
		Node firsteven = null, lasteven = null, firstodd = null, lastodd = null;

		Node curr = head;
		boolean first_even = true, first_odd = true;
		while (curr != null) {
			if ((curr.data) % 2 == 0) {
				if (first_even) {
					firsteven = curr;
					first_even = false;
					lasteven = firsteven;

				} else {
					lasteven.next = curr;
					lasteven=curr;
				}
			} else {
				if (first_odd) {
					firstodd = curr;
					lastodd=curr;
					first_odd = false;

				} else {
					lastodd.next = curr;
					lastodd=curr;
				}
			}
			curr = curr.next;
		}
		if(firsteven==null||firstodd==null){
	        return head;
	    }
	
		lasteven.next = firstodd;
		lastodd.next=null;

		return firsteven;
	}

	// O(N)
	private static Node fun(Node head) {
		if (head == null)
			return head;
		Node curr = head;
		while (curr != null && curr.next != null) {
			curr = curr.next;
		}
		Node lastnode = curr;
		Node last = curr;

		curr = head;
		Node even_node = null;
		Node lasteven = null;
		boolean firsteven = true;
		boolean firstodd = true;
		Node oddnode = null;
		while (curr != null) {
			Node z = curr;
			if ((curr.data) % 2 != 0) {
				if (firstodd) {
					oddnode = curr;
					firstodd = false;
				}
				Node x = curr.next;
				if (even_node != null) {
					even_node.next = x;
					// even_node = null;
				}
				lastnode.next = curr;
				lastnode = curr;
				lastnode.next = null;

				curr = x;
			} else {
				if (firsteven) {
					head = curr;
					firsteven = false;
				}
				even_node = curr;
				lasteven = curr;
				curr = curr.next;
			}
			if (z == last) {
				if (lasteven != null) {
					lasteven.next = oddnode;
				}
				break;
			}

		}
		if (firsteven) {
			return oddnode;
		}
		return head;
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
