package AdvancedConcepts;

public class A1_DSU {

	// Disjoint set union.

	public static void main(String... strings) {

		int a[] = { 0, 1, 2, 3, 4, 5, 6 };

		usingArray(a, a.length);

		usingTree(a, a.length);

	}

	private static void usingTree(int[] a, int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		union(parent, rank, 1, 2); // 2 is merged with 1,so now parent of 2 is 1.

		System.out.println(get(parent, 2)); // 1.
	}

	static int rank[];

	static int get(int parent[], int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = get(parent, parent[x]); // store while coming back-path compression.
	}

	static void union(int parent[], int rank[], int a, int b) {
		a = get(parent, a);
		b = get(parent, b);

		if (rank[a] == rank[b]) {
			rank[a]++;
		}
		if (rank[a] > rank[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

//---------------------------------------------------------------------------------------------------------------	
	private static void usingArray(int[] a, int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		union(1, 2, n); // 2 is merged with 1,so now parent of 2 is 1.

		System.out.println(get(2)); // 1.

	}

	static int parent[];

	// O(1)
	static int get(int x) {
		return parent[x];
	}

	// O(N)
	static boolean union(int a, int b, int n) {

		a = get(a);
		b = get(b);
		if (a == b) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (parent[i] == b) {
				parent[i] = a;
			}
		}

		return true;

	}
//---------------------------------------------------------------------------------------------------------------

}
