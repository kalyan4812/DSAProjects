package LinkedList;

public class C3_LruUsingLinkedList {

	int capacity;
	int p = 0;

	
	 // delete -O(N),get-O(n),insert-O(1)
	public C3_LruUsingLinkedList(int capacity) {
		this.capacity = capacity;
	}

	public static void main(String[] args) {

		C3_LruUsingLinkedList l = new C3_LruUsingLinkedList(4);
		Node head = null;
		head = l.get(10, head);
		l.print(head);
		head = l.get(20, head);
		l.print(head);
		head = l.get(10, head);
		l.print(head);
		head = l.get(30, head);
		l.print(head);
		head = l.get(40, head);
		l.print(head);
		head = l.get(50, head);
		l.print(head);
		head = l.get(30, head);
		l.print(head);
		head = l.get(40, head);
		l.print(head);
		head = l.get(60, head);
		l.print(head);
		head = l.get(30, head);
		l.print(head);
	}

	public Node get(int x, Node head) {
		if (head != null) {
			int i = C3_LruUsingLinkedList.search(x, head);
			if (i != -1) {

				C3_LruUsingLinkedList.delete(i, head);
				p--;

			}
		}
		if (p == capacity) {
			Node curr = head;
			while (curr != null && curr.next != null && curr.next.next != null) {
				curr = curr.next;
			}
			curr.next = null;
			head = C3_LruUsingLinkedList.insert(x, head);
			return head;
		}
		head = C3_LruUsingLinkedList.insert(x, head);
		p++;
		return head;
	}

	private static void delete(int x, Node head) {
		if (head == null)
			return;
		Node curr = head;
		while (curr != null && curr.next != null) {
			if (curr.next.data == x) {
				curr.next = curr.next.next;
				return;
			}
			curr = curr.next;
		}
		return;
	}

	public static int search(int x, Node head) {
		Node curr = head;
		while (curr != null) {
			if (curr.data == x) {
				return x;
			}
			curr = curr.next;
		}
		
		return -1;
	}

	public static void print(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static Node insert(int x, Node head) {
		Node temp = new Node(x);
		temp.next = head;
		return temp;
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
