package LinkedList;

public class D5_SortedListToBST {

	/*
	 
	  public TreeNode sortedListToBST(ListNode head) {
        if(head==null )return null;
      
        ListNode mid=getMid(head);
        TreeNode root=new TreeNode(mid.val);
        if(head==mid) return root;
    
         root.left=sortedListToBST(head);
          root.right=sortedListToBST(mid.next);
       
        
        
       
        return root;
    }
    
    public static ListNode getMid(ListNode head){
        if(head==null) return null;
        ListNode slow=head,fast=head,prev=head;
        
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null) prev.next=null;
        return slow;
    }
    
	 */
}
