package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.A1_ConstructATree.Node;

public class B4_MaxWidthOfBinaryTree {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		System.out.println(maxWidth(root));
	}

	// t(N),T(w)==O(N) for perfectBinaryTree.
	private static int maxWidth(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int max = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			max = Math.max(max, size);
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();

				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}

		}
		return max;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
