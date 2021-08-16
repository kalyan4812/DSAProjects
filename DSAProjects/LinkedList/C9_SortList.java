package LinkedList;

import LinkedList.A2_InsertionInLinkedList.Node;

public class C9_SortList {
	public static void main(String... strings) {
		ListNode head = null;
		head = insertAtStart(0, head);
		head = insertAtStart(4, head);
		head = insertAtStart(3, head);
		head = insertAtStart(5, head);
		head = insertAtStart(-1, head);

		// head = sortList(head);
		printList(head);
		System.out.println();

		head = sortUsingMergeSort(head);
		printList(head);

	}

	private static ListNode sortUsingMergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = getMiddleBySlowAndFast(head);
		ListNode rem = middle.next;
		middle.next = null;
		return mergeFunction(sortUsingMergeSort(head), sortUsingMergeSort(rem));
	}

	private static ListNode mergeFunction(ListNode f, ListNode s) {
		ListNode temp = new ListNode(0, null);
		ListNode list = temp;
		while (f != null && s != null) {
			if (f.val < s.val) {
				temp.next = f;
				f = f.next;
			} else {
				temp.next = s;
				s = s.next;
			}

			/*
			 * For union use: if(f.val==s.val){ temp.next=f; f=f.next; s=s.next; } For
			 * intersection use above,and in above if else statements no need of
			 * temp.next=f/temp.next=s;
			 */
			temp = temp.next;
		}
		if (f != null) {
			temp.next = f;

		} else {
			temp.next = s;

		}

		return list.next;
	}

	// t(N/2)
	private static ListNode getMiddleBySlowAndFast(ListNode head) {
		if (head == null)
			return head;
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) { // no of need of slow!=null condition because only after fast
													// beoming null ,slow will become null.
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

/////////////////////////////////////////////////////////	
	public static ListNode sortList(ListNode head) {

		if (head == null) {
			return head;
		}
		ListNode x = sortList(head.next);
		head = adjustList(head.val, x);
		return head;
	}

	public static ListNode adjustList(int n, ListNode head) {
		// O(N)

		if (head == null) {
			return new ListNode(n, head);
		}
		if (n < head.val) {
			return insertAtStart(n, head);
		}
		ListNode curr = head;
		while (curr != null && curr.next != null && n > curr.next.val) {
			curr = curr.next;
		}
		ListNode x = new ListNode(n, null);
		x.next = curr.next;
		curr.next = x;
		return head;

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// O(N)
	private static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

	// O(1)
	public static ListNode insertAtStart(int data, ListNode head) {
		if (head == null) {
			return new ListNode(data, null);
		}
		ListNode x = new ListNode(data, head);
		// x.next=head;
		head = x;
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int data, ListNode next) {
			this.val = data;
			this.next = next;
		}
	}
}
