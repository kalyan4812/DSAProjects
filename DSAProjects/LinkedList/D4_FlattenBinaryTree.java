package LinkedList;

import java.util.Stack;

import LinkedList.A1_PrintElementsOfLinkedList.Node;

public class D4_FlattenBinaryTree {

	/*public void flatten(Node root) {
		if(root==null) return;
		Stack<Node> st=new Stack<>();
		st.push(root);
		while(st.size()>0) {
			Node curr=st.pop();
			if(curr.right!=null) {
				st.push(curr.right);
			}
			 if(curr.left!=null) {
				st.push(curr.left);
			}
			 if(!st.isEmpty()) {
				 curr.right=st.peek();
			 }
			 curr.left=null;
		}
		
	}*/
	
	/*
	 My Solution:
	 
	 public void flatten(TreeNode root) {
        if(root==null) return ;
        fun(root);
       
    }
    public static TreeNode fun(TreeNode root){
         if(root==null) return root ;
        
          
        TreeNode lef=fun(root.left);
        TreeNode rig=fun(root.right);
        if(lef!=null){
        root.right=lef;
            
         root.left=null;
        }
        
      
        while(lef!=null && lef.right!=null){
            lef=lef.right;
        }
        
        if(lef!=null && rig!=null)
        lef.right=rig;
        
        
         
       
        return root;
    }
	 
	 
	 
	 
	 */
}
