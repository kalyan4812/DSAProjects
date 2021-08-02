package Trees;

import Trees.A1_ConstructATree.Node;

public class B9_MaxPathSum {
	// from any node to any node.
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		int k = maxPathSum(root);
		System.out.print(res);
	}

	static int res = Integer.MIN_VALUE;

	private static int maxPathSum(Node root) {
		if (root == null)
			return 0;

		int l = maxPathSum(root.left);
		int r = maxPathSum(root.right);

		int temp = Math.max(root.key, Math.max(l, r) + root.key);
		int ans = Math.max(l + r + root.key, temp);
		res = Math.max(res, ans);

		return temp;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
