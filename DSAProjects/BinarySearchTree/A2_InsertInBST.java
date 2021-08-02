package BinarySearchTree;

import BinarySearchTree.A1_SearchInBST.Node;

public class A2_InsertInBST {
	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		insert(root, 40);
		
		iterativeInsert(root,40);
	}

	
	//O(h),O(1)-space.
	private static Node iterativeInsert(Node root, int num) {
		Node temp=new Node(num);
		Node parent=null;
		Node curr=root;
		while(curr!=null) {
			parent=curr;
			if(curr.key>num) {
				curr=curr.left;
			}
			else if(curr.key<num) {
				curr=curr.right;
			}
			else {
				return root;
			}
			
		}
		if(parent==null) return root;
		
		if(parent.key>num) {
			parent.left=temp;
		}
		else if(parent.key<num) {
			parent.right=temp;
		}
		return root;
	}


	//O(h),O(h)
	private static Node insert(Node root, int num) {

		if (root == null) {
			return new Node(num);
		}
		if (root.key > num) {
			root.left = insert(root.left, num);
		} else if (root.key < num) {
			root.right = insert(root.right, num);
		}
		return root;

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
