package Trees;

import Trees.A1_ConstructATree.Node;

public class C5_DistanceBetweenTwoNodes {

	//Distance(U, V) = Distance(root, U) + Distance(root, V) - 2 * Distance(root, LCA)
	
	// or Distance(U, V) = Distance(LCA, U) + Distance(LCA, V)
	public static void main(String... strings) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		
		System.out.println(findDistanceBetweenNodes(root,40,30));
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int key) {
			this.val = key;
		}
	}
	public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2)
	{
        int a=getDistUsingRecusrion(root,node1);
        if(a<=0) return -1;
        int b=getDistUsingRecusrion(root,node2);
        if(b<=0) return -1;
        int lca=lcaRecursive(root,node1,node2);
        if(lca==Integer.MIN_VALUE){
            return -1;
    }
        int d=getDistUsingRecusrion(root,lca);
        if(d<=0) return -1;
        return a+b-2*d;
		
	}
    private static int lcaRecursive(TreeNode root, int n1, int n2) {
		if(root==null) return Integer.MIN_VALUE;
		if(root.val==n1 || root.val==n2) return root.val;
		int x=lcaRecursive(root.left, n1,  n2);
		int y=lcaRecursive(root.right, n1, n2);
		if(x!=Integer.MIN_VALUE && y!=Integer.MIN_VALUE) {
			return root.val;
		}
		else if(x!=Integer.MIN_VALUE){
			return x;
		}
		else if(y!=Integer.MIN_VALUE) {
			return y;
		}
		return Integer.MIN_VALUE;
	}
    private static int getDistUsingRecusrion(TreeNode root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.val == n1) || (x = getDistUsingRecusrion(root.left, n1)) > 0
					|| (x = getDistUsingRecusrion(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
	}
}
