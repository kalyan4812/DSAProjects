package Trees;

import Trees.A6_MaxInBinaryTree.Node;

public class A7_HeightOfBinaryTree {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		int size = getHeight(root);
		System.out.println(size);
	}

	// O(n),O(h)
	private static int getHeight(Node root) {
		if (root == null)
			return 0;

		int a = getHeight(root.left);
		int b = getHeight(root.right);

		return 1+Math.max(a, b);
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
