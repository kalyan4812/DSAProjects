package DynamicProgramming;

public class G3_MaximalSquare {

	public static void main(String... strings) {
		String maze[][] = { { "1", "0", "1", "0", "0" }, { "1", "0", "1", "1", "1" }, { "1", "1", "1", "1", "1" } };

		System.out.println(dpSol(maze, maze.length, maze[0].length));

	}

	private static int dpSol(String[][] matrix, int rows, int col) {

		int dp[][] = new int[rows][col];

		int i, j;
		int maxsize=0;

		for (i = 0; i < rows; i++) {
			
			dp[i][0] = matrix[i][0].charAt(0) - '0';
			maxsize =Math.max(maxsize, dp[i][0]);
		}

		for (i = 0; i < col; i++) {
			dp[0][i] = matrix[0][i].charAt(0) - '0';
			maxsize =Math.max(maxsize, dp[0][i]);
		}

		for (i = 1; i < rows; i++) {
			for (j = 1; j < col; j++) {
				if (matrix[i][j].charAt(0) == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					maxsize = Math.max(maxsize, dp[i][j]);
				}

			}
		}
		return maxsize * maxsize;
	}
}
