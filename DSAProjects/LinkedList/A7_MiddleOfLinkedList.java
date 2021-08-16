package LinkedList;

import LinkedList.A6_GetSizeOfLinkedList.Node;

public class A7_MiddleOfLinkedList {
	public static void main(String... strings) {
		Node head = null;

		head = insertAtStart(50, head);
		head = insertAtStart(40, head);
		head = insertAtStart(30, head);
		head = insertAtStart(20, head);
		head = insertAtStart(10, head); // 10 20 30 40

		int p = getMiddle(head);
		System.out.println(p);
		
		
		int r = getMiddleBySlowAndFast(head);
		System.out.println(r);
	}

	
	//t(N/2)
	private static int getMiddleBySlowAndFast(Node head) {
		if(head==null) return -1;
		Node slow=head,fast=head;
		while(fast!=null && fast.next!=null) {  // no of need of slow!=null condition because only after fast beoming null ,slow will become null.
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}


	//t(N)
	private static int getMiddle(Node head) {
		if(head==null) return -1;
		
		int len=1;
		Node curr=head;
		while(curr.next!=null) {
			curr=curr.next;
			len++;
		}
		
		curr=head;
		int c=1;
		while(c<len/2+1 && curr!=null) {
			curr=curr.next;
			c++;
		}
		if(curr==null) return -1;
		
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
