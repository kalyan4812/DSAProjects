package LinkedList;

public class D1_CheckPalindrome {

	/*
	 *  public boolean isPalindrome(ListNode head) {
       if(head==null) return false;
        if(head.next==null) return true;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rem=slow;
        rem=reverse(rem);
        
        while(head!=null && rem!=null){
           if(head.val!=rem.val){
               break;
           } 
            head=head.next;
            rem=rem.next;
        }
      
        if(head==null || rem==null) return true;
        return false;
    }
    
    private static ListNode reverse(ListNode head) {
		if (head == null)
			return head;
		ListNode curr = head.next;
		if (curr == null)
			return head;

		curr = head;
		ListNode prev = null;
		ListNode nextnode;
		while (curr != null) {
			nextnode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextnode;
		}
		return prev;

	}
	 */
}