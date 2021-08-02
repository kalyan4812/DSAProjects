package Trees;

import Trees.A1_ConstructATree.Node;

public class C7_CountNodesInCompleteBinaryTree {

	//Binary tree which has all nodes filled in all levels ,except the last level.
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		
		System.out.println(count(root));
		
		System.out.println(countOptimized(root));
		
	}

	
	//O(logn*logn)
	private static int countOptimized(Node root) {
		int lh=0,rh=0;
		Node curr=root;
		while(curr!=null) {
			lh++;
			curr=curr.left;
		}
		curr=root;
		while(curr!=null) {
			rh++;
			curr=curr.right;
		}
		if(lh==rh) {
			return (int)Math.pow(2, rh)-1;
		}
		return 1+count(root.left)+count(root.right);
	}

	
	//t(N)
	private static int count(Node root) {
		if(root==null) return 0;
		
		return 1+count(root.left)+count(root.right);
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
