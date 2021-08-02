package BinarySearchTree;

public class A1_SearchInBST {

	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		boolean b = search(root, 20);
		System.out.print(b);

		boolean c = iterativeSearch(root, 20);
		System.out.print(c);
	}

	//O(h),O(1)-space.
	private static boolean iterativeSearch(Node root, int num) {

		while (root != null) {
			if (root.key == num) {
				return false;
			} else if (root.key > num) {
				root = root.left;
			} else {
				root = root.right;
			}

		}

		return false;
	}

	// O(h)-time,O(h)-space.
	private static boolean search(Node root, int num) {
		if (root == null)
			return false;

		if (root.key == num)
			return true;

		else if (root.key > num) {
			return search(root.left, num);
		} else {
			return search(root.right, num);
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
