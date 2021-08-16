package Trees;

import Trees.A1_ConstructATree.Node;

public class A5_SizeOfBinaryTree {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		
		int size=getSize(root);
		System.out.println(size);
	}

	
	//O(n),O(h)
	private static int getSize(Node root) {
	  if(root==null)
		return 0;
	  
	  else return 1+getSize(root.left)+getSize(root.right);
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
