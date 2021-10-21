package BackTracking;

public class B6_MaxAreaIsland {

	public static void main(String... strings) {
		int g[][] = { { 1 }, { 1 } };

		System.out.println(maxAreaOfIsland(g));
	}

	public static int maxAreaOfIsland(int[][] g) {

		int n = g.length;
		int m = g[0].length;

		boolean vis[][] = new boolean[n][m];
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (g[i][j] == 1 && vis[i][j] == false) {
					ans = Math.max(ans, area(g, vis, i, j));
				}
			}
		}
		return ans;
	}

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static int area(int g[][], boolean vis[][], int i, int j) {
		int n = g.length;
		int m = g[0].length;

		if (i >= n || i < 0 || j < 0 || j >= m) {
			return 0;
		}
		if (g[i][j] == 0 || vis[i][j]) {
			return 0;
		}
		vis[i][j] = true;
		int next = 0;
		for (int d = 0; d < 4; d++) {
			next += area(g, vis, i + dx[d], j + dy[d]);
		}

		return next + 1;

	}
}
