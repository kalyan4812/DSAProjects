package Trees;

import java.util.Stack;

import Trees.A2_InorderTraversal.Node;

public class A3_PreorderTraversal {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		preorderFun(root);
		System.out.println();
		iterativePreorder(root);
		System.out.println();
		iterativePreorderOptimized(root);
	}

	//t(n),O(h)
	private static void iterativePreorderOptimized(Node root) {
		if(root==null) return;
		
		Stack<Node> st=new Stack<>();
		Node curr=root;
		while(curr!=null || !st.isEmpty()) {
			while(curr!=null) {
				System.out.print(curr.key+" ");
				if(curr.right!=null) {
					st.push(curr.right);
				}
				curr=curr.left;
			}
			if(!st.isEmpty()) {
				curr=st.pop();
			}
		}
		
	}

	// t(n),t(n)
	private static void iterativePreorder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> st = new Stack<>();
		st.push(root);

		while (!st.isEmpty()) {

			Node curr = st.pop();
			System.out.print(curr.key + " ");
			if(curr.right!=null) {
				st.push(curr.right);
			}
			if(curr.left!=null) {
				st.push(curr.left);
			}
			
		
		}

	}

	// O(n)-time,O(h)-space ,h=height of binary tree.
	private static void preorderFun(Node root) {

		if (root == null) {
			return;
		}

		System.out.print(root.key + " ");
		preorderFun(root.left);
		preorderFun(root.right);

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
