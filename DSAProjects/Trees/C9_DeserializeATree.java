package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Trees.A1_ConstructATree.Node;

public class C9_DeserializeATree {

	public static void main(String... strings) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(-1);
		list.add(40);
		list.add(-1);
		list.add(-1);
		list.add(-1);
		list.add(-1);

		Node root = deSerialize(list);
		levelOrder(root);

	}

	
	//t(N)
	private static Node deSerialize(ArrayList<Integer> list) {
		if (list.isEmpty()) {
			return null;
		}
		int y = list.get(0);
		list.remove(0);
		if (y == -1)
			return null;

		Node z = new Node(y);
		z.left = deSerialize(list);
		z.right = deSerialize(list);
		return z;
	}

	private static void levelOrder(Node root) {
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
