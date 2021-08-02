package BinarySearchTree;

import java.util.HashSet;
import BinarySearchTree.A1_SearchInBST.Node;

public class B1_PairWithGivenSumInBST {

	public static void main(String... strings) {

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);

		boolean b=find(root,40);
		System.out.print(b);
	}


	//O(N),O(h+n)-space.
	static HashSet<Integer> hs=new HashSet<>();
	private static boolean find(Node root, int sum) {
		if(root==null) return false;
		
		if(find(root.left,sum)) {
			return true;
		}
		
		if(hs.contains(sum-root.key)) {
			return true;
		}
		else {
			hs.add(root.key);
		}
		return find(root.right,sum);
	}


	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
