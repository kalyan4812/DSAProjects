package LinkedList;

import java.util.Scanner;

import LinkedList.A1_PrintElementsOfLinkedList.Node;

public class A3_SearchInLinkedList {
	public static void main(String... strings) {
		Node head = null;
		head = insertAtStart(10, head);
		head = insertAtStart(20, head);
		head = insertAtStart(30, head);
		head = insertAtStart(40, head); // 40 30 20 10
		
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		search(head,n);
		
		int k=searchUsingRecusrsion(head,n,1);
		System.out.println(k);

	}

	
	//O(N),O(N)-space.F
	private static int searchUsingRecusrsion(Node head, int n,int ans) {
		if(head==null) {
			System.out.println("Not found In list");
			return -1;
		}
		
		return (head.data==n)?ans:searchUsingRecusrsion(head.next,n,ans+1);
	}

	//O(N)
	private static void search(Node head, int n) {
		if(head==null) {
			System.out.println("Not found");
			return;
		}
		Node curr=head;
		int pos=1;
		while(curr!=null) {
			if(curr.data==n) {
				System.out.println("Found at "+pos);
				return;
			}
			pos++;
			curr=curr.next;
		}
		
		System.out.println("Not found");	
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
