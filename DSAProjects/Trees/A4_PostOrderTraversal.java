package Trees;

import java.util.Stack;

import Trees.A3_PreorderTraversal.Node;

public class A4_PostOrderTraversal {
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		postOrderFun(root);
		System.out.println();
		iterativePostorder(root);
		System.out.println();
		iterativePostorderOptimized(root);
	}

	// t(n),O(h)
	private static void iterativePostorderOptimized(Node root) {
		if (root == null)
			return;

		Stack<Node> st = new Stack<>();
		Node curr = root;
		while (!st.isEmpty() || curr != null) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			curr = st.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
		}

	}

	// t(n),t(n)
	private static void iterativePostorder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> st = new Stack<>();
		// st.push(root);
		Node curr = root;
		while (!st.isEmpty() || curr != null) {
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}
			curr = st.pop();
			System.out.print(curr.key + " ");
		}
	}

	
	
	
	// O(n)-time,O(h)-space ,h=height of binary tree.
	private static void postOrderFun(Node root) {

		if (root == null) {
			return;
		}
		postOrderFun(root.left);
		postOrderFun(root.right);
		System.out.print(root.key + " ");

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
