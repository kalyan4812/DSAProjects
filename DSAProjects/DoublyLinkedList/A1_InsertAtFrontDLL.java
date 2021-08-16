package DoublyLinkedList;

import LinkedList.A1_PrintElementsOfLinkedList.Node;

public class A1_InsertAtFrontDLL {

	
	public static void main(String...strings) {
		Node head=null;
		head=insertAtFront(30,head);
		printList(head);
		head=insertAtFront(20,head);
		printList(head);
		head=insertAtFront(10,head);
		printList(head);
		head=insertAtFront(5,head);
		printList(head);
	}
	
	private static Node insertAtFront(int x, Node head) {
		Node curr=new Node(x);
		if(head!=null) {
			curr.next=head;
			head.prev=curr;
		}
		head=curr;
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
