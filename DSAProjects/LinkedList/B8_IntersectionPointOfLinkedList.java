package LinkedList;

import java.util.HashSet;

import LinkedList.B7_SegregateEvenOddValuesOfLinkedList.Node;

public class B8_IntersectionPointOfLinkedList {
	public static void main(String... strings) {
		Node head = null;
		
		Node head2 = null;

		head = insertAtStart(15, head);
		head = insertAtStart(12, head);
		head = insertAtStart(10, head);
		head2 = insertAtStart(9, head);
		head = insertAtStart(7, head);
		head = insertAtStart(8, head);
		head = insertAtStart(5, head);

	

		/*head2 = insertAtStart(15, head2);
		head2 = insertAtStart(12, head2);
		head2 = insertAtStart(10, head2);*/
		head2 = insertAtStart(9, head2);

		getInterSection(head, head2);
		
		getIntersectionOtherWay(head,head2);

	}

	//O(M+N),O(1)-space.
	private static void getIntersectionOtherWay(Node head, Node head2) {
		if (head == null || head2 == null) {
			return;
		}
		
		int count1=0,count2=0;
		Node curr1=head;
		Node curr2=head2;
		while(curr1!=null) {
			curr1=curr1.next;
			count1++;
		}
		
		while(curr2!=null) {
			curr2=curr2.next;
			count2++;
		}
		
		int diff=Math.abs(count1-count2);
		curr1=head;
		
		for(int k=0;k<diff;k++) {
			curr1=curr1.next;
		}
		
		curr2=head2;
		while(curr1!=null && curr2!=null) {
			if(curr1==curr2) {
				System.out.println(curr1.data);
				break;
			}
			curr1=curr1.next;
			curr2=curr2.next;
		}
		
		
		
	}

	//O(M+N),O(M)-space.
	private static void getInterSection(Node head, Node head2) {
		if (head == null || head2 == null) {
			return;
		}
		HashSet<Integer> hs = new HashSet<>();
		Node curr = head;
		while (curr != null) {
			hs.add(curr.data);
			curr = curr.next;
		}

		Node x = head2;
		while (x != null) {

			if (hs.contains(x.data)) {
				System.out.print(x.data + " ");
				hs.remove(x.data);
			}
			x = x.next;
		}

		System.out.println();

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
