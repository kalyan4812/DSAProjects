package Trees;

import Trees.A5_SizeOfBinaryTree.Node;

public class A6_MaxInBinaryTree {
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		int size = getMax(root);
		System.out.println(size);
	}

	// O(n),O(h)
	private static int getMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int a = getMax(root.left);
		int b = getMax(root.right);

		return Math.max(root.key, Math.max(a, b));
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
