package PracticeQuestions;

public class A9_RateMazePaths {
	public static void main(String... strings) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		// 0-blocked cell
		// 1-free cell

		// naive approach is to find path from 0,0 to n-1,n-1 and filter solutions
		// without 0s.

		// only two moves allowed down,right.
		int k = countMazePath(maze);

		System.out.println("Total Paths : " + k);

		int p = countMazePathUsingDp(maze);

		System.out.println("Total Paths : " + p);
		
		
		System.out.println(dpSol(maze,maze.length,maze[0].length));

	}

	//t(MN)
	private static int dpSol(int[][] maze, int rows, int cols) {
		 int dp[][]=new int[rows][cols];
	        int i, j;
	        for(i=0;i<rows;i++){
	            for(j=0;j<cols;j++){
	                if(maze[i][j] == 0){
	                    dp[i][j] = 0;
	                }
	                else if(i == 0 && j == 0){
	                    dp[0][0] =1;
	                }
	                else if(i == 0){
	                    dp[i][j] = dp[i][j-1];
	                }
	                else if(j == 0){
	                    dp[i][j] = dp[i-1][j];
	                }
	                else{
	                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
	                }
	            }
	        }
	        return dp[rows-1][cols-1];
	}

	private static int countMazePathUsingDp(int[][] maze) {
		int n = maze.length;
		int m = maze[0].length;

		int dp[][] = new int[n + 1][m + 1];

		if (maze[n - 1][m - 1] == 1) {
			dp[n - 1][m - 1] = 1; // take no step ,that is also one way.
		}

		for (int i = n - 2; i >= 0; i--) { // last column.
			if (maze[i][m - 1] == 0) {
				dp[i][m - 1] = 0;
			} else {
				dp[i][m - 1] = dp[i][m - 1] + dp[i + 1][m - 1];
			}
		}

		for (int i = m - 2; i >= 0; i--) { // last row.
			if (maze[n - 1][i] == 0) {
				dp[n - 1][i] = 0;
			} else {
				dp[n - 1][i] = dp[n - 1][i] + dp[n - 1][i + 1];
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				if (maze[i][j] == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i][j] + dp[i + 1][j] + dp[i][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	private static int countMazePath(int[][] maze) {

		int n = maze.length;
		int m = maze[0].length;

		return helper(maze, n, m, 0, 0);
	}

	private static int helper(int[][] grid, int n, int m, int i, int j) {

		if (i >= n || j >= m) {
			return 0;
		}
		if (i == n - 1 && j == m - 1) {
			return grid[i][j] != 0 ? 1 : 0;
		}
		int c1 = 0, c2 = 0;
		if (j + 1 < m && grid[i][j + 1] != 0) {
			c1 = helper(grid, n, m, i, j + 1); // right move.
		}

		if (i + 1 < n && grid[i + 1][j] != 0) {
			c2 = helper(grid, n, m, i + 1, j); // down move
		}
		return c1 + c2;
	}

}
