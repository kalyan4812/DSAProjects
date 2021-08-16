package BackTracking;

public class A3_NQueen {

	public static void main(String...strings) {
		
		int n=4;
		
		nqueen(n);
	}

	static int num_of_ways=0;
	private static void nqueen(int n) {
	
		boolean vis[][]=new boolean[n][n];
		
		helper(n,vis,0);
		
		System.out.println("No of ways : "+num_of_ways);
		
		
	}

	private static void display(boolean[][] vis) {
		
		for(int i=0;i<vis.length;i++) {
			for(int j=0;j<vis[0].length;j++) {
				if(vis[i][j]) {
					System.out.print("Q ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println();
			
		}
		System.out.println();
		
	}

	private static void helper(int n, boolean[][] vis, int row) {
		if(row==n) {
			display(vis);
			num_of_ways++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(isSafe(row,i,vis,n)) {
			vis[row][i]=true;
			helper(n,vis,row+1);
			vis[row][i]=false;
			}
		}
		
	}

	private static boolean isSafe(int row, int col, boolean[][] vis,int n) {
		
		for(int i=row-1;i>=0;i--) {
			if(vis[i][col]) {
				return false;
			}
		}
		for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--) {
			if(vis[i][j]) {
				return false;
			}
		}
		for(int i=row-1,j=col+1;i>=0 && j<n ;i--,j++) {
			if(vis[i][j]) {
				return false;
			}
		}
		return true;
	}
}
