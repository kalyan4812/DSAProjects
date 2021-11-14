package Trees;

public class D1_VertexCover {

	public static void main(String[] args) {
		// Let us construct tree given in the above diagram
		node root = newNode(20);
		root.left = newNode(8);
		root.left.left = newNode(4);
		root.left.right = newNode(12);
		root.left.right.left = newNode(10);
		root.left.right.right = newNode(14);
		root.right = newNode(22);
		root.right.right = newNode(25);

		System.out.printf("Size of the smallest vertex" + "cover is %d ", vCover(root));

	}

	private static int vCover(node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		if(root.vc>0) {
			return root.vc;
		}

		int x = 1 + vCover(root.left) + vCover(root.right);

		int y = 0;
		if (root.left != null) {
			y += 1 + vCover(root.left.left) + vCover(root.left.right);
		}
		if (root.right != null) {
			y += 1 + vCover(root.right.left) + vCover(root.right.right);
		}

		root.vc= Math.min(x, y);
		return root.vc;
	}

	static class node {
		int data,vc;
		node left, right;
	};

	static node newNode(int data) {
		node temp = new node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

}
