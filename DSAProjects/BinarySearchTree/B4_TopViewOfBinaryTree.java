package BinarySearchTree;

import BinarySearchTree.A1_SearchInBST.Node;

public class B4_TopViewOfBinaryTree {

	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		topView(root);
	}

	private static void topView(Node root) {
		
		
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
