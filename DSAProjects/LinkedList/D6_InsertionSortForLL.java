package LinkedList;

public class D6_InsertionSortForLL {
/*
 
 
  public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
      ListNode  x=head.next;
        head.next=null;
        while(x!=null){
            ListNode nextnode=x.next;
            ListNode y=temp;
            if(temp.val>x.val){
                x.next=temp;
                temp=x;
            }
            else{
            while(y!=null && y.next!=null){
           if( y.next.val>x.val){
               x.next=y.next;
               y.next=x;
               break;
           }
                y=y.next;
            }
                if(y.next==null){
                    y.next=x;
                    x.next=null;
                
                  }
            }
            
           
            x=nextnode;
            
        }
        return temp;
        
    }
 */
	
	/*
	  Working solution:
	  
	    public boolean isSubPath(ListNode head, TreeNode root) {
    if(head==null)
        return true;
     if(root==null)
         return false;
     return ispath(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
 }
 
 public boolean ispath(ListNode head,TreeNode root)
 {
     if(head==null)
         return true;
     if(root==null)
         return false;
     return (head.val==root.val) && (ispath(head.next,root.left) || ispath(head.next,root.right));
 }
   
	 */
}


