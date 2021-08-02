package Trees;

import java.util.HashMap;
import java.util.Map;

import Trees.A1_ConstructATree.Node;

public class B6_ConstructBinaryTreeFromInorderAndPreorder {

	static Map<Integer, Integer> m = new HashMap<>();

	public static void main(String... strings) {

		int in[] = { 20, 10, 40, 30, 50 };
		int pre[] = { 10, 20, 30, 40, 50 };

		fun(in, pre, 0, in.length - 1);

		// Method2
		for (int u = 0; u < in.length; u++) {
			m.put(in[u], u);
		}

		fun2(in, pre, 0, in.length - 1, m);

	}

	static int ind = 0;

	// O(N),O(N)-space.
	private static Node fun2(int[] in, int[] pre, int i, int j, Map<Integer, Integer> m) {

		if (i > j)
			return null;
		Node x = new Node(pre[ind]);
		ind++;

		int p = m.get(x.key);

		x.left = fun2(in, pre, i, p - 1, m);
		x.right = fun2(in, pre, p + 1, j, m);

		return x;
	}

	static int index = 0;

	// O(N2)
	private static Node fun(int[] in, int[] pre, int i, int j) {
		if (i > j)
			return null;
		Node x = new Node(pre[index]);
		index++;

		int p = 0;
		for (int k = 0; k <= j; k++) {
			if (in[k] == x.key) {
				p = k;
				break;
			}

		}

		x.left = fun(in, pre, i, p - 1);
		x.right = fun(in, pre, p + 1, j);

		return x;

	}

	static class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
		}
	}
}
