package LinkedList;

public class D2_RemoveAllElementsWIthGivenValue {

	
	/* EX: Remove all 2 from linkedlist.
	 
	 
	 * public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
         
         while(head!=null && head.val==val){
             head=head.next;
         }
        
        ListNode x=head;
        while(x!=null && x.next!=null){
            if(val==x.next.val){
                x.next=x.next.next;
            }else{
            x=x.next;
            }
        }
        
        return head;
        
    }
	 */
}
