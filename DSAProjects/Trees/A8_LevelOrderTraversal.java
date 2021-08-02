package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.A1_ConstructATree.Node;

public class A8_LevelOrderTraversal {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		levelOrderFun(root);
		System.out.println();
		levelOrderFun2(root);
		System.out.println();
		levelOrderFun3(root);

	}

	//O(n),t(w)
	private static void levelOrderFun3(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
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

	// O(n+h),t(width+nulls)-space.

	private static void levelOrderFun2(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		q.add(null);
		while (q.size() > 1) {
			Node curr = q.poll();
			if (curr == null) {
				System.out.println();
				q.add(null);
				continue;
			}
			System.out.print(curr.key + " ");
			if (curr.left != null) {
				q.add(curr.left);
			}
			if (curr.right != null) {
				q.add(curr.right);
			}
		}

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	// O(nlogn)
	private static void levelOrderFun(Node root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}

		int h = getHeight(root);

		for (int i = 0; i < h; i++) {
			printAtGivenLevel(root, i + 1);
			System.out.println();
		}

	}

	private static void printAtGivenLevel(Node root, int level) {
		if (root == null)
			return;

		if (level == 1) {
			System.out.print(root.key + " ");
			return;
		}

		printAtGivenLevel(root.left, level - 1);
		printAtGivenLevel(root.right, level - 1);
	}

	private static int getHeight(Node root) {
		if (root == null)
			return 0;

		int a = getHeight(root.left);
		int b = getHeight(root.right);

		return 1 + Math.max(a, b);
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
