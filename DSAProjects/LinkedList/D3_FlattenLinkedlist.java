package LinkedList;

public class D3_FlattenLinkedlist {

	/*
	 * public Node flatten(Node head) {
        Stack<Node> s = new Stack<>();
        Node t = head;
        while(t != null) {
            if(t.child != null) {
                if(t.next != null) s.push(t.next);
                t.next = t.child;
                t.child.prev = t;
                t.child = null;
                t = t.next;
            } else if(t.next != null) {
                t = t.next;
            } else if(!s.isEmpty()) {
                Node next = s.pop();
                t.next = next;
                next.prev = t;
                t = next;
            } else {
                t = null;
            }
        }
        return head;
    }
	 */
	
	/*
	 * My Solution:
	 
	 
	 
	 public Node flatten(Node head) {
       if(head==null) return head; 
        Node x=head;
                    
        while(x!=null){
            if( x.child!=null){
               Node nextnode=x.next;
               Node y= flatten(x.child);
                if(y!=null){
                x.next=y;
                x.child=null;
                y.prev=x;
                }
                while(y!=null && y.next!=null){
                    y=y.next;
                }
                if(nextnode!=null){
                y.next=nextnode;
                nextnode.prev=y;
                }
                return head; 
               
                
            }
            
            x=x.next;
            
        }
        return head;
    }
	 */
}
