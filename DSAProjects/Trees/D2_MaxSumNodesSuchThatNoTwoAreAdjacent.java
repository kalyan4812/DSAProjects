package Trees;

public class D2_MaxSumNodesSuchThatNoTwoAreAdjacent {

	public static void main(String args[]) {
		Node root = new Node(10);
		root.left = new Node(1);
		root.left.left = new Node(2);
		root.left.left.left = new Node(1);
		root.left.right = new Node(3);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(5);
		System.out.print(maxSum(root));
	}

	private static int maxSum(Node root) {
		if (root == null) {
			return 0;
		}
		int p = root.data;
		int incl=p;
		if(root.left!=null) {
			incl+=maxSum(root.left.left);
			incl+=maxSum(root.left.right);
		}
		if(root.right!=null) {
			incl+=maxSum(root.right.left);
			incl+=maxSum(root.right.right);
		}
		int x = maxSum(root.left);
		int y = maxSum(root.right);

		
		return Math.max(incl, x+y);

	}

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
}
