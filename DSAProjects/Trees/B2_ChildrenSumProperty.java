package Trees;

import Trees.A1_ConstructATree.Node;

public class B2_ChildrenSumProperty {
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		System.out.println(isSumProperty(root) == 1 ? true : false);
		
		
		System.out.print(fun2(root));
	}

	private static boolean fun2(Node root) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;
		
		int sum=0;
		if(root.left!=null) {
			sum=sum+root.left.data;
		}
		if(root.right!=null) {
			sum=sum+root.right.data;
		}

		return (sum==root.data)&&fun2(root.left)&&fun2(root.right);
	}

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			this.data = key;
		}
	}

	//O(n),O(h)
	public static int isSumProperty(Node root) {
		if (root == null)
			return 1;

		if (root.left == null && root.right == null)
			return 1;

		int b = isSumProperty(root.left);
		int c = isSumProperty(root.right);

		if (b == 1 && c == 1) {
			if (root != null) {
				if (root.left != null && root.right != null) {

					return (root.data == root.left.data + root.right.data) ? 1 : 0;
				} else if (root.left != null && root.right == null) {
					return (root.data == root.left.data) ? 1 : 0;
				} else if (root.right != null && root.left == null) {
					return (root.data == root.right.data) ? 1 : 0;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}

	}
}