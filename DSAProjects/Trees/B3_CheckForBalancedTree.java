package Trees;

import Trees.A1_ConstructATree.Node;

public class B3_CheckForBalancedTree {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		System.out.println(isBalanced(root));

		System.out.println(isBalancedOptimized(root) != -1 ? true : false);
	}

	// O(n)
	private static int isBalancedOptimized(Node root) { // returns height of tree
		if (root == null)
			return 0;

		int lh = isBalancedOptimized(root.left);
		if (lh == -1)
			return -1;

		int rh = isBalancedOptimized(root.right);
		if (rh == -1)
			return -1;

		if (Math.abs(rh - lh) > 1)
			return -1;

		else
			return Math.max(lh, rh) + 1;

	}

	// O(n2) --for every root we need height which is also O(N)
	private static boolean isBalanced(Node root) {

		if (root == null)
			return true;

		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		return Math.abs(rh - lh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private static int getHeight(Node root) {
		if (root == null)
			return 0;

		int a = getHeight(root.left);
		int b = getHeight(root.right);

		return 1 + Math.max(a, b);
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
