package BackTracking;

public class A5_KnightsTour {

	// check if knight placed at 0,0 can cover all cells.

	public static void main(String... strings) {

		int n = 8;

		knightsTour(n);
	}

	
	static int num_of_ways = 0;

	private static void knightsTour(int n) {

		boolean vis[][] = new boolean[n][n];
		int grid[][] = new int[n][n];

		helper(n, vis, 0, 0, 0, grid);

		System.out.println("No of ways : " + num_of_ways);

	}

	
	private static void display(int[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				System.out.print(grid[i][j] + " ");

			}
			System.out.println();

		}
		System.out.println();

	}

	static boolean onesol=false;
	private static void helper(int n, boolean[][] vis, int row, int col, int count, int[][] grid) {
		if (count == (n * n)-1) {
			grid[row][col] = count;
			display(grid);
			num_of_ways++;
			onesol=true;
			return;
		}
		if(count>=n*n) {
			return;
		}
		 if(onesol) {
			   return;
		   }

		int x[] = { -2, -2, -1, -1, 2, 2, 1, 1 };
		int y[] = { 1, -1, 2, -2, -1, 1, -2, 2 };
		
		vis[row][col] = true;
		grid[row][col]=count;
		
		for (int i = 0; i < 8; i++) {
			   if(onesol) {
				   return;
			   }
				if (isSafe(row+x[i], col+y[i], vis, n)) {
					
					helper(n, vis,row+x[i], col+y[i], count + 1,grid);
				
				}
			
		}
		vis[row][col] = false;
		grid[row][col]=-1;

	}

	
	private static boolean isSafe(int r, int c, boolean[][] vis, int n) {
		
		return r>=0 && r<n && c>=0 && c<n && !vis[r][c];
	}
	
	
	}