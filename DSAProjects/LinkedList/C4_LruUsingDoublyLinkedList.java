package LinkedList;

public class C4_LruUsingDoublyLinkedList {

	static int p;
	int capacity;
	
	
	
	//delte -o(1),get-O(N),insert-O(1)

	public C4_LruUsingDoublyLinkedList(int capacity) {
		this.capacity = capacity;
	}

	public static void main(String[] args) {

		C4_LruUsingDoublyLinkedList l = new C4_LruUsingDoublyLinkedList(4);
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
			int i = C4_LruUsingDoublyLinkedList.searchAndDelete(x, head);

		}
		if (p == capacity) {
			Node curr = head;
			while (curr != null && curr.next != null && curr.next.next != null) {
				curr = curr.next;
			}
			curr.next.prev=null;
			curr.next = null;
			p--;
			head = C4_LruUsingDoublyLinkedList.insert(x, head);

			return head;
		}
		head = C4_LruUsingDoublyLinkedList.insert(x, head);

		return head;
	}

	public static int searchAndDelete(int x, Node head) {
		Node curr = head;
		while (curr != null) {
			if (curr.data == x) {
				p--;

				
				if (curr.next == null && curr.prev == null) {
					head = null;
				} else if (curr.next == null && curr.prev != null) {
					curr.prev.next = null;
				}
				if (curr.prev != null && curr.next != null) {
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
				}

				return x;
			}
			curr = curr.next;
		}

		return -1;
	}

	public static Node insert(int x, Node head) {
		Node temp = new Node(x);
		temp.next = head;
		if (head != null) {
			head.prev = temp;
		}
		head = temp;
		p++;
		return temp;
	}

	public static void print(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
}
