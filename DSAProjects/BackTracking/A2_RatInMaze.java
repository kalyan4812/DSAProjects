package BackTracking;

import java.util.ArrayList;

public class A2_RatInMaze {

	public static void main(String... strings) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		// 0-blocked cell
		// 1-free cell

		// naive approach is to find path from 0,0 to n-1,n-1 and filter solutions
		// without 0s.

		// only two moves allowed down,right.
		int k = countMazePath(maze);

	
		System.out.println("Total Paths : " + k);

	}

	

	static int num_of_paths = 0;

	static ArrayList<Path> path = new ArrayList<>();

	

	// time complexity: 3^(n2-(4n-4))*2^(4n-4)
	private static int countMazePath(int[][] maze) {
		int n = maze.length;

		boolean vis[][] = new boolean[n][n];

		

		helper(0, 0, n, maze, vis,"("+0+","+0+")");

		return num_of_paths;

	}

	private static void helper(int i, int j, int n, int[][] maze, boolean[][] vis,String op) {
		if (i == n - 1 && j == n - 1) {
			if(op.length()>0) {
				System.out.println(op);
			}
			num_of_paths++;
			return;
		}
		if (!isSafe(i, j, vis, n)) {
			return;
		}
		vis[i][j] = true;
		

		if (i + 1 < n && maze[i + 1][j] == 1) { // down move
			helper(i + 1, j, n, maze, vis,op+" "+"("+(i+1)+","+(j)+")"+" ");
		}
		if (j + 1 < n && maze[i][j + 1] == 1) { // right move
			helper(i, j + 1, n, maze, vis,op+" "+"("+(i)+","+(j+1)+")"+" ");
		}
		vis[i][j] = false;
		
		

		return;
	}

	private static void display(ArrayList<Path> p) {
		
		for(Path path:p) {
			System.out.print("("+path.i+","+path.j+")"+"  ");
		}
	}

	private static boolean isSafe(int i, int j, boolean[][] vis, int n) {

		return i >= 0 && i < n && j >= 0 && j < n && !vis[i][j];
	}

	static class Path {
		int i, j;

		Path(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}
