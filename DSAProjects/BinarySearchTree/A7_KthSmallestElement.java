package BinarySearchTree;

import BinarySearchTree.A1_SearchInBST.Node;

public class A7_KthSmallestElement {

	public static void main(String...strings) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		
		find(root,2); // k=2
	}
	

	
	//O(h+k) to O(n)
	static int count=0;
	private static void find(Node root,int k) {
		if(root!=null) {
			find(root.left,k);
			count++;
			if(count==k) {
				System.out.print(root.key+" ");
				return;
			}
			find(root.right,k);
		}
		
		
	}


	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
