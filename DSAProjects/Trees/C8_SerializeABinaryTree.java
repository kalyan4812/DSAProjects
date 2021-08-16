package Trees;

import java.util.ArrayList;

import Trees.A1_ConstructATree.Node;

public class C8_SerializeABinaryTree {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		
		ArrayList<Integer> k=new ArrayList<>();
		ArrayList<Integer> ans=serialize(root,k);
		System.out.print(ans.toString());
	}

	
	//t(n),t(n)
	private static ArrayList<Integer> serialize(Node root, ArrayList<Integer> k) {
		if(root==null) {
			k.add(-1);
			return k;
		}
		k.add(root.key);
		ArrayList<Integer> ls=serialize(root.left,k);
		ArrayList<Integer> rs=serialize(root.right,k);
		
		return k;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
