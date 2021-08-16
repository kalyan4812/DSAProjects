package BinarySearchTree;

import BinarySearchTree.A7_KthSmallestElement.Node;

public class A8_CheckForBST {
	public static void main(String... strings) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		boolean b = check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(b);

		boolean c = check2(root);
		// idea:a binary tree is bst iff inorder traversal of it is in increasing order.
		System.out.println(c);

	}

	static Node prev = null;

	private static boolean check2(Node root) {

		if (root == null)
			return true;

		boolean a = check2(root.left);
		if (!a) {
			return false;
		}
		if (root.key <= prev.key) {
			return false;
		} else {
			prev = root;
		}
		boolean b = check2(root.right);
		if (!b) {
			return false;
		}
		return true;
	}

	// O(N)
	private static boolean check(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.key >= max || root.key <= min)
			return false;

		return check(root.left, min, root.key) && check(root.right, root.key, max);

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
