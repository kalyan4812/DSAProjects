package LinkedList;

public class D7_RemoveConsecutiveNodesWhichMakeSumZero {

	/*
	 
	  public ListNode removeZeroSumSublists(ListNode head) {
        
      int curr_sum = 0;
        ListNode x=new ListNode(0);
        ListNode y=x;
        x.next=head;
        
       
		Map<Integer,ListNode> map = new HashMap<>();
        boolean check=false;
        ListNode cur=null;
       
		while (x!=null ) {
           
			curr_sum = curr_sum + x.val;
           
			
			if (map.containsKey(curr_sum) && check) {
				cur = map.get(curr_sum).next;
                int key = curr_sum + cur.val;
                while(key != curr_sum) {
                    map.remove(key);
                    cur = cur.next;
                    key += cur.val;
                }
                map.get(curr_sum).next = cur.next;
               
               
                
			}
           if (!map.containsKey(curr_sum)) { 
				map.put(curr_sum,x);
               check=true;
		}
           
            x=x.next;
		} 
        
        return y.next ;
    
    }
	 */
	
	/*
	    Recursive solution:
	    
	    
	    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null ) return head;
       // if(head.next==null && head.val==0) return null;
       ListNode rem=removeZeroSumSublists(head.next);
       head.next=rem;
       ListNode k=head;
        int s=0;
        while(k!=null){
            s=s+k.val;
            if(s==0){
                while(s!=0){
                    k=k.next;
                    s=s+k.val;
                }
                break;
            }
            k=k.next;
        }
        if(k!=null){
            head=k.next;
         }
        
        return head;
        
        
    
    }
	 */
}
