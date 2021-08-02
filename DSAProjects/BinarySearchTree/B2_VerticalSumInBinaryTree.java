package BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

import BinarySearchTree.A1_SearchInBST.Node;

public class B2_VerticalSumInBinaryTree {

	public static void main(String...strings) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left=new Node(25);

		
		verticalSum(root);
	}
	
	//O(log(hd))+O(n)+O(hd)
	private static void verticalSum(Node root) {
		TreeMap<Integer,Integer> tm=new TreeMap<>();
		vSum(root,0,tm);
		
		for(Map.Entry k:tm.entrySet()) {
			System.out.print(k.getValue()+"  ");
		}
	}

	//hd=horizontal distance.
	private static void vSum(Node root, int hd, TreeMap<Integer, Integer> tm) {
		if(root==null) return;
		
		vSum(root.left,hd-1,tm);
		
		int pSum=(tm.get(hd)==null)?0:tm.get(hd);
		tm.put(hd, pSum+root.key);
		
		vSum(root.right,hd+1,tm);
		
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
