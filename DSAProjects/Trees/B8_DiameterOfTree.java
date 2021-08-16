package Trees;

import Trees.A1_ConstructATree.Node;

public class B8_DiameterOfTree {

	
	//longest path between two leafs.
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);

		int p = diameter(root);
		System.out.println(p);

		 diameterOptimized(root);
		System.out.print(res);

	}

	// O(N),O(h)
	static int res = Integer.MIN_VALUE;

	private static int diameterOptimized(Node root) { // diameterOprimized==height.
		if (root == null)
			return 0;
		int lh = diameterOptimized(root.left);
		int rh = diameterOptimized(root.right);
		
		int tempans=Math.max(lh, rh)+1;
		int ans=Math.max(tempans, 1+lh+rh);
		res = Math.max(res, ans);
		return tempans;
	}

	////////////////////////////////////////////////////////////////////

	// O(n2) // can be reduced by pre computing heights using hashmap.
	private static int diameter(Node root) {
		if (root == null)
			return 0;

		int d1 = 1 + getHeight(root.left) + getHeight(root.right);
		int d2 = diameter(root.left);
		int d3 = diameter(root.right);
		return Math.max(d1, Math.max(d2, d3));
	}

	private static int getHeight(Node root) {
		if (root == null)
			return 0;

		int a = getHeight(root.left);
		int b = getHeight(root.right);

		return 1 + Math.max(a, b);
	}

	/////////////////////////////////////////////////////////////////////////////////////
	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
