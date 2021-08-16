package Trees;

import Trees.A1_ConstructATree.Node;

public class B5_ConvertBinaryTreeToDLL {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		Node head = bToDLL(root);

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}

	// O(N),O(h)-space.
	static Node bToDLL(Node root) {
		if (root == null)
			return root;

		Node x = bToDLL(root.left);
		Node y = bToDLL(root.right);
		if (x == null && y == null) {
			return root;
		}
		if (x != null && y != null) {
			Node z = x;
			while (z != null && z.right != null) {
				z = z.right;
			}
			z.right = root;
			root.left = z;
			root.right = y;
			y.left = root;
		} else if (x == null && y != null) {
			root.right = y;
			y.left = root;
			x = root;

		} else if (y == null && x != null) {
			Node z = x;
			while (z != null && z.right != null) {
				z = z.right;
			}
			z.right = root;
			root.left = z;
		}

		return x;
	}
}
