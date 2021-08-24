package DynamicProgramming;

import java.util.ArrayList;

public class G4_RangeSumQuery2D {

	// DOubt
	public static void main(String... strings) {
		int maze[][] = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 5, 6, 3, 2, 1 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		dpSol(maze, maze.length, maze[0].length);

		System.out.println(sumRegion(1, 2, 2, 4));
	}

	static boolean flag = false;
	static int dp[][];

	private static void dpSol(int[][] matrix, int m, int n) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		

		dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
	}

	static int sumRegion(int row1, int col1, int row2, int col2) {
		if(flag){
            return 0;
        }
       /* if(row1 == 0 && col1 == 0){
            return dp[row2][col2];
        }
        else if(row1 == 0){
            return dp[row2][col2] - dp[row2][col1-1];
        }
        else if(col1 == 0){
            return dp[row2][col2] - dp[row1-1][col2];
        }
        else{
            return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
        }*/
		 int iMin = Math.min(row1, row2);
		    int iMax = Math.max(row1, row2);
		    
		    int jMin = Math.min(col1, col2);
		    int jMax = Math.max(col1, col2);
		    
		    return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];  
	}

}
