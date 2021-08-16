package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import BinarySearchTree.B2_VerticalSumInBinaryTree.Node;

public class B3_VerticalTraversal {

	public static void main(String...strings) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left=new Node(25);

		verticalTraversal(root);
		
	}
	private static void verticalTraversal(Node root) {
		
		Queue<Pair> q=new LinkedList<>();
		
		Map<Integer,ArrayList<Integer>> mp=new TreeMap<>();
		
		q.add(new Pair(root,0));
		
		while(!q.isEmpty()) {
			Pair p=q.poll();
			Node curr=p.node;
			int hd=p.hd;
			
			if(mp.containsKey(hd)) {
				mp.get(hd).add(curr.key);
			}
			else {
				ArrayList<Integer> al=new ArrayList<>();
				al.add(curr.key);
				mp.put(hd, al);
			}
			
			if(curr.left!=null) {
				q.add(new Pair(curr.left,hd-1));
			}
			if(curr.right!=null) {
				q.add(new Pair(curr.right,hd+1));
			}
		}
		
		
		for(Map.Entry<Integer,ArrayList<Integer>> m:mp.entrySet()) {
			ArrayList<Integer> list=m.getValue();
			for(int x:list) {
				System.out.print(x+" ");
			}
			System.out.println();
			
		}
	}
	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
	
	static class Pair{
		Node node;
		int hd;
		Pair(Node node,int hd){
			this.node=node;
			this.hd=hd;
		}
	}
}
