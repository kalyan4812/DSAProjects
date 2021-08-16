package Trees;

import java.util.Stack;

import Trees.A1_ConstructATree.Node;

public class A2_InorderTraversal {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		inorderFun(root);
		System.out.println();
		iterativeInorder(root);
	}

	
	//t(n),O(h)
	private static void iterativeInorder(Node root) {
		if (root == null) {
			return;
		}
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

	// O(n)-time,O(h)-space ,h=height of binary tree.
	private static void inorderFun(Node root) {

		if (root == null) {
			return;
		}

		inorderFun(root.left);
		System.out.print(root.key + " ");
		inorderFun(root.right);

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}

}
