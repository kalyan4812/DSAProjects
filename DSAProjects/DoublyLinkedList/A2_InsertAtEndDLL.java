package DoublyLinkedList;

import DoublyLinkedList.A1_InsertAtFrontDLL.Node;

public class A2_InsertAtEndDLL {
	
	public static void main(String...strings) {
		Node head=null;
		head=insertAtEnd(30,head);
		printList(head);
		head=insertAtEnd(20,head);
		printList(head);
		head=insertAtEnd(10,head);
		printList(head);
		head=insertAtEnd(5,head);
		printList(head);
	}
	
	private static Node insertAtEnd(int x, Node head) {
		Node temp=new Node(x);
		if(head==null) {
			return temp;
		}
		Node curr=head;
		while(curr!=null && curr.next!=null) {
			curr=curr.next;
		}
		curr.next=temp;
		temp.prev=curr;
		
		return head;
	}

	private static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();

	}
	
   static	class Node{
		int data;
		Node prev,next;
		Node(int data){
			this.data=data;
			next=null;
			prev=null;
		}
	}
}
