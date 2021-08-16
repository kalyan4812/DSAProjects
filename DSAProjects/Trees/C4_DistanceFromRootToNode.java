package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.A1_ConstructATree.Node;

public class C4_DistanceFromRootToNode {

	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		
		int a=getDist(root,40);
		System.out.println(a);
		
		int b=getDistUsingRecusrion(root,40);
		System.out.print(b);
	}

	
	private static int getDistUsingRecusrion(Node root, int num) {
		if(root==null) return -1;
		if(root.key==num) return 0;
		int l=getDistUsingRecusrion(root.left,num);
		int r=getDistUsingRecusrion(root.right,num);
		
		if(l>=0) {
			return 1+l;
		}
		else if(r>=0) {
			return 1+r;
		}
		
		return -1;
	}

	
	//other recursive
	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.key == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
	}

	//O(N)
	private static int getDist(Node root, int num) {
		if (root == null)
			return -1;

		Queue<Node> q = new LinkedList<>();

		q.add(root);
		int level=1;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Node curr = q.poll();
				if(curr.key==num) {
					return level-1;
				}
				
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
			level++;
			
		}
		
		return -1;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
