package LinkedList;

public class C8_AddTwoLinkedLIsts {

	/*
	 * Method 1:
	 * 
	 * 
	 * 
	   
	 static Node addTwoLists(Node first, Node second){
       
       first=reverse(first);
       second=reverse(second);
       Node head=null;
       
       int sum=0,carry=0;
       Node curr1=first,curr2=second;
       while(curr1!=null && curr2!=null){
           sum=(curr1.data+curr2.data+carry)%10;
           carry=(carry+curr1.data+curr2.data)/10;
           head=insertAtEnd(sum,head);
           curr1=curr1.next;
           curr2=curr2.next;
           
       }
       
       while(curr1!=null){
           sum=(curr1.data+carry)%10;
           carry=(carry+curr1.data)/10;
           head=insertAtEnd(sum,head);
           curr1=curr1.next;
       }
       while(curr2!=null){
           sum=(curr2.data+carry)%10;
           carry=(carry+curr2.data)/10;
           head=insertAtEnd(sum,head);
           curr2=curr2.next; 
       }
       
       if(carry!=0){
            head=insertAtEnd(carry,head);
       }
       
       return head;
    }
    
    
    
    
    // O(N)
	public static Node insertAtStart(int data, Node head) {
	if (head == null) {
			return new Node(data);
		}
		Node x = new Node(data);
	    x.next=head;
		head = x;
		return head;
	}
    
    
    // t(N)
	private static Node reverse(Node head) {
		if (head == null)
			return head;
		Node curr = head.next;
		if (curr == null)
			return head;

		curr = head;
		Node prev = null;
		Node nextnode;
		while (curr != null) {
			nextnode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextnode;
		}
		return prev;

	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 * 
	 * Recursive way
	 * 
	 * 
	 * 
	 static int carry=0;
    static Node addTwoLists(Node first, Node second){
        
        int c1=0,c2=0;
            Node x=first,y=second;
      while(x!=null){
          c1++;
          x=x.next;
      }
      while(y!=null){
          c2++;
          y=y.next;
      }
        if(c1>c2){
          for(int i=0;i<Math.abs(c1-c2);i++){
            second=insertAtStart(0,second);
        }  
        }
        else{
              for(int i=0;i<Math.abs(c1-c2);i++){
            first=insertAtStart(0,first);
        } 
        }
       
        
       Node head=null;
       head=fun(first,second,head);
     
      if(carry!=0){
            head=insertAtStart(carry,head);
       }
       carry=0;
       
       return head;
       
      
      
    }
    
    public static Node fun(Node curr1,Node curr2,Node head){
        if(curr1==null){
           
           
            return head;
        }
       
        
        head=fun(curr1.next,curr2.next,head);
        
        int s=curr1.data+curr2.data+carry;
        carry=s/10;
        head=insertAtStart(s%10,head);
        return head;
        
    }
    
    // O(N)
	public static Node insertAtStart(int data, Node head) {
	if (head == null) {
			return new Node(data);
		}
		Node x = new Node(data);
	    x.next=head;
		head = x;
		return head;
	}
    
	 */
}
