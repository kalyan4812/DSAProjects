package BinarySearchTree;

import BinarySearchTree.A4_FloorInBST.Node;

public class A5_CielInBST {

	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		
		System.out.print(ciel(root,12).key);
	}

	

	//O(h),O(1)
	private static Node ciel(Node root, int num) {
		Node res=null;
		while(root!=null) {
			if (root.key == num) {
				return root;
			} else if (root.key > num) {
				res=root;
				root = root.left;
			} else {
				
				root = root.right;
			}
		}
		
		return res;
	}



	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
