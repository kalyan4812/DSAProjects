package Stacks;

import LinkedList.A2_InsertionInLinkedList.Node;

public class A2_StackUsingLinkedList implements A0_MyStack {

	//All are O(1)
	
	int size;
	Node head;

	public A2_StackUsingLinkedList() {
		size = 0;
		head=null;
	}

	public static void main(String... strings) {
		A2_StackUsingLinkedList s = new A2_StackUsingLinkedList();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
		System.out.println(s.getSize());
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();

		s.display();

	}

	@Override
	public void push(int val) {
		head=insertAtStart(val,head);
		size++;

	}

	@Override
	public int getSize() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return (size==0);
	}

	@Override
	public int pop() {
		int res=-1;
		if(head==null) {
			System.out.println("Stack is Empty");
			return -1;
		}
		else {
			res=head.data;
			head=head.next;
			size--;
		}
		return res;
	}

	@Override
	public int peek() {
		if(head==null) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return head.data;
	}

	@Override
	public void display() {
		printList(head);

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
