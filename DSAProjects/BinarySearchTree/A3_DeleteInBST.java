package BinarySearchTree;

import BinarySearchTree.A1_SearchInBST.Node;

public class A3_DeleteInBST {

	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		Node n=delete(root,20);
		System.out.print(n.key);
	}

	

	//O(h),O(h)
	private static Node delete(Node root, int num) {
		if(root==null) return null;
		if(root.key>num) {
			root.left=delete(root.left,num);
		}
		else if(root.key<num) {
			root.right=delete(root.right,num);
		
		}
		else {
			if(root.left==null) return root.right;
			else if(root.right==null) return root.left;
			else {
			Node succ=getSuccessor(root);
			root.key=succ.key;
			root.right=delete(root.right,succ.key);
			}
		}
		return root;
	}



	private static Node getSuccessor(Node root) {
		Node curr=root.right;
		while(curr!=null && curr.left!=null) {
			curr=curr.left;
		}
		return curr;
	}



	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
