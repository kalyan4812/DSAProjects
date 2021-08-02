package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Trees.A1_ConstructATree.Node;

public class B7_TreeTraversalInSpiralForm {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		printSpiral(root);
	}

	// O(N)
	private static void printSpiral(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		Stack<Integer> st = new Stack<>();
		boolean reverse = false;

		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (reverse) {
					st.push(curr.key);
				} else {
					System.out.print(curr.key + " ");
				}

				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}

			if (reverse) {
				while (!st.isEmpty()) {
					System.out.print(st.pop() + " ");
				}
				reverse = false;
			} else {
				reverse = true;
			}

			System.out.println();
		}

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
