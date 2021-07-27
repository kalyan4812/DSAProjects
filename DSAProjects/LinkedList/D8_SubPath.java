package LinkedList;

public class D8_SubPath {

	/*
	  My solution not working:
	  
	  
	    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head.next==null) return true;
          ListNode x=head;
        while(x!=null && x.next!=null && x.next.next!=null){
            x=x.next;
        }
         ListNode y=x.next,z=x;
        x.next=null;
          boolean a=isSubPath(head,root);
          if(!a){
              return false;
          }
        else{
          boolean node1=ifNodeExists(root.left,z.val,y.val);
            boolean node2=ifNodeExists(root.right,z.val,y.val);
            boolean node3=ifNodeExists(root,z.val,y.val);
            
             if(node3){
                return true;
            }
            else{
               if(node1){
                return true;
            }
            else if(node2){
                return true;
            }
                return false;
            }
            
        }
        
    }
    
    static boolean ifNodeExists( TreeNode node, int key,int k)
{
    if (node == null)
        return false;
 
    if (node.val == key)
        
    {    TreeNode node1=node,node2=node;
         while(node1!=null && node1.right!=null &&node1.right.val==key){
             node1=node1.right;
         }
         if(node1.right!=null && node1.right.val==k){
            return true;
        }
        if(node1.left!=null && node1.left.val==k){
            return true;
        }
        
        while(node2!=null && node2.left!=null &&node2.left.val==key){
             node2=node2.left;
         }
        if(node2.left!=null && node2.left.val==k){
            return true;
        }
      if(node2.right!=null && node2.right.val==k){
            return true;
        }
       
         
            return false;
        
        
    }
 
   
     boolean res1 = ifNodeExists(node.left, key,k);
   
     if(res1){
         return true;
     }
    
 
      boolean res2 = ifNodeExists(node.right, key,k);
        if(res2){
            return true;
        }
 
    return res2;
}
	 */
}
