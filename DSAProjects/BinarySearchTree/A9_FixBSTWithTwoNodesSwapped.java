package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class A9_FixBSTWithTwoNodesSwapped {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);

		printTree(root);

		findOddNodes(root);

		Node new_node = fixBST(root, first.key, second.key);

		printTree(new_node);

	}

	static Node fixednode = null;

	
	//O(N)
	private static Node fixBST(Node root, int first, int second) {
		if (root == null)
			return null;
		fixBST(root.left, first, second);
		if (root != null && root.key == first) {
			root.key = second;
			fixednode = root;

		}
		if (root != null && root != fixednode && root.key == second) {
			root.key = first;
		}

		fixBST(root.right, first, second);

		return root;
	}

	static Node prev = null, first = null, second = null;

	private static void findOddNodes(Node root) {
		if (root == null)
			return;
		findOddNodes(root.left);
		if (prev != null && root.key < prev.key) {
			if (first == null) {
				first = prev;
			}
			second = root;
		}
		prev = root;
		findOddNodes(root.right);

	}

	private static void printTree(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();

				System.out.print(curr.key + " ");
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
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
