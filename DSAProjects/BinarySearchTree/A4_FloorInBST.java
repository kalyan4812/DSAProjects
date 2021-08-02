package BinarySearchTree;

import BinarySearchTree.A1_SearchInBST.Node;

public class A4_FloorInBST {

	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		
		System.out.print(floor(root,12).key);
	}

	

	//O(h),O(1)
	private static Node floor(Node root, int num) {
		Node res=null;
		while(root!=null) {
			if (root.key == num) {
				return root;
			} else if (root.key > num) {
				root = root.left;
			} else {
				res=root;
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
