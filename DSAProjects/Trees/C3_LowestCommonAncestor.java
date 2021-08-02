package Trees;

import java.util.ArrayList;

import Trees.A1_ConstructATree.Node;

public class C3_LowestCommonAncestor {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		
		int k=lcaFun(root,40,30);
		System.out.println(k);
		
		int p=lcaRecursive(root,40,30);
		System.out.println(p);
	}

	private static int lcaRecursive(Node root, int n1, int n2) {
		if(root==null) return -1;
		if(root.key==n1 || root.key==n2) return root.key;
		int x=lcaRecursive(root.left, n1,  n2);
		int y=lcaRecursive(root.right, n1, n2);
		if(x!=-1 && y!=-1) {
			return root.key;
		}
		else if(x!=-1){
			return x;
		}
		else if(y!=-1) {
			return y;
		}
		return -1;
	}

	
	
	
	//t(n) ,O(n)-space.
	private static int lcaFun(Node root,int n1,int n2) {
		if(root==null) return -1;
		ArrayList<Integer> p1=new ArrayList<>();
		ArrayList<Integer> p2=new ArrayList<>();
		if(path(root,n1,p1)==null || path(root,n2,p2)==null) {
			return -1;
		}
		else {
			for(int i=0;i<p1.size();i++) {
				if(p2.contains(p1.get(i))) {
					return p1.get(i);
				}
			}
		}
		
		return -1;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
	
	 public static ArrayList<Integer> path(Node root,int n,ArrayList<Integer> ans){
	        if(root==null) return null;
	        if(root.key==n) {
	            ans.add(root.key);
	            return ans;
	        }
	        ArrayList<Integer> p1=path(root.left,n,ans);
	        ArrayList<Integer> p2=path(root.right,n,ans);
	        
	        if(p1!=null && p1.size()>0 && root!=null){
	            ans.add(root.key);
	          
	            return ans;
	        }
	        else if(p2!=null && p2.size()>0 && root!=null){
	            ans.add(root.key);
	          
	            return ans;
	           
	        }
	       
	        return null;
	    }
}
