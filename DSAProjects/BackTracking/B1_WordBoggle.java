package BackTracking;

public class B1_WordBoggle {

	public static void main(String... strings) {

		char boogle[][] = { { 'b', 'c', 'a' }, { 'c', 'h', 'e' }, { 'e', 'o', 't' }, { 's', 's', 'p' } };
		String word = "bcemmm";
		boolean b = wordBoggle(boogle, word);
		System.out.print(b);
	}

	private static boolean wordBoggle(char[][] boogle, String word) {
		int n = boogle.length;
		int m = boogle[0].length;
		boolean vis[][] = new boolean[n][n];

		int i = 0, j = 0;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (word.charAt(0) == boogle[i][j]) {
					if (helper(word, word.length(), i, j, boogle, m, n, vis, 0))
						return true;
				}
			}
		}

		return false;

	}

	private static boolean helper(String word, int wl, int row, int col, char[][] grid, int m, int n, boolean[][] vis,
			int index) {
		if (index == wl)
			return true;

		if (!isSafe(row, col, grid, word, wl, vis, index)) {
			return false;
		}
		vis[row][col] = true;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0)
					continue;

				if (helper(word, wl, row + i, col + j, grid, m, n, vis, index + 1))
					return true;

			}
		}

		vis[row][col] = false;
		return false;
	}

	private static boolean isSafe(int row, int col, char[][] grid, String word, int n, boolean[][] vis, int index) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return false;
		}

		if (vis[row][col] || word.charAt(index) != grid[row][col]) {
			return false;
		}
		return true;
	}
}
