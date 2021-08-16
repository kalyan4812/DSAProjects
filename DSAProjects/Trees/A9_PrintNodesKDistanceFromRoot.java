package Trees;

import Trees.A1_ConstructATree.Node;

public class A9_PrintNodesKDistanceFromRoot {
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.right = new Node(70);

		print(root, 2);
	}

	// t(n),t(n)
	private static void print(Node root, int k) {
		if (root == null)
			return;
		if (k == 0)
			System.out.print(root.key + " ");

		print(root.left, k - 1);
		print(root.right, k - 1);

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
