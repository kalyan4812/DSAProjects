package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.A1_ConstructATree.Node;

public class B1_PrintLeftViewOfTree {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		
		fun1(root);
		System.out.println();
		fun2(root,1);
	}

	
	//t(n),t(h)-space.  preorder traversal.
	static int maxlevel=0;
	private static void fun2(Node root,int level) {
	 
		if(root==null) return;
		
		if(maxlevel<level) {
			System.out.print(root.key+" ");
			maxlevel=level;
		}
		
		fun2(root.left,level+1);
		fun2(root.right,level+1);
		
	}


	//t(n),t(w)
	private static void fun1(Node root) {
		if(root==null) return;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Node curr=q.poll();
				if(i==0) {
					System.out.print(curr.key+" ");
				}
				if(curr.left!=null) {
					q.add(curr.left);
				}
				if(curr.right!=null) {
					q.add(curr.right);
				}
			}
		}
		
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
