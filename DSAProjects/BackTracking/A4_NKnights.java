package BackTracking;

public class A4_NKnights {

	public static void main(String... strings) {

		int n = 4;

		nKnights(n);
	}

	// time complexity: O(n!)
	static int num_of_ways = 0;

	private static void nKnights(int n) {

		boolean vis[][] = new boolean[n][n];

		helper(n, vis, 0, 0, 0);

		System.out.println("No of ways : " + num_of_ways);

	}

	private static void display(boolean[][] vis) {

		for (int i = 0; i < vis.length; i++) {
			for (int j = 0; j < vis[0].length; j++) {
				if (vis[i][j]) {
					System.out.print("K ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();

		}
		System.out.println();

	}

	private static void helper(int n, boolean[][] vis, int row, int col, int count) {
		if (count == n ) {
			display(vis);
			num_of_ways++;
			return;
		}

		for (int i = row; i < n; i++) {
			for (int j = (i == row) ? col : 0; j < n; j++) {
				if (isSafe(row, col, vis, n)) {
					vis[i][j] = true;
					helper(n, vis, i, j + 1, count + 1);
					vis[i][j] = false;
				}
			}
		}

	}

	private static boolean isSafe(int r, int c, boolean[][] vis, int n) {
		if (r - 2 >= 0 && c - 1 >= 0 && vis[r - 2][c - 1]) {
			return false;
		}
		if (r - 1 >= 0 && c - 2 >= 0 && vis[r - 1][c - 2]) {
			return false;
		}
		if (r - 2 >= 0 && c + 1 < n && vis[r - 2][c + 1]) {
			return false;
		}
		if (r - 1 >= 0 && c + 2 < n && vis[r - 1][c + 2]) {
			return false;
		}

		return true;
	}
}
