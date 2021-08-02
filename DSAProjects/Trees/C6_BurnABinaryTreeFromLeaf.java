package Trees;

import Trees.A1_ConstructATree.Node;

public class C6_BurnABinaryTreeFromLeaf {

	//Doubt
	public static void main(String... strings) {

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		
		int b=burn(root,20,new Distance(-1));
		System.out.print(b);
	}

	static int res=0;
	private static int burn(Node root,int leaf,Distance d) {
		if(root==null) return 0;
		if(root.key==leaf) {
			d.val=0;
			return 1;
		}
		Distance ldist=new Distance(-1);
		Distance rdist=new Distance(-1);
		
		int lh=burn(root.left,leaf,ldist);
		int rh=burn(root.right,leaf,rdist);
		
		if(ldist.val!=-1) {
			d.val=ldist.val+1;
			res=Math.max(res, rh+d.val);
		}
		else if(rdist.val!=-1) {
			d.val=rdist.val+1;
			res=Math.max(res, lh+d.val);
		}
		
		return Math.max(lh, rh)+1;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
	static class Distance{
		int val;
		Distance(int val){
			this.val=val;
		}
	}
}
