package BackTracking;

public class A8_Sudoko {

	public static void main(String...strings) {
		
		int grid[][]= {{1,0,3,0},{0,0,2,1},{0,1,0,2},{2,4,0,0}};
		
		sudokoSolver(grid);
	}

	private static void sudokoSolver(int[][] grid) {
		
		int n=grid.length;
		
		helper(grid,0,0,n);
		
		display(grid,n);
	}

	private static void display(int[][] grid, int n) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static boolean helper(int[][] grid, int i, int j, int n) {
		
		 if(i == n) return true;
		    
		    if(grid[i][j] != 0){
		        if(j == n-1){
		            return helper(grid,i+1,0,n);
		        }
		        else{
		            return helper(grid,i,j+1,n);
		        }
		    }

		    for(int k=1;k<=n;k++){
		        if(isSafe(i,j,grid,k)){
		            grid[i][j] = k;
		            if(j == n-1){
		                if(helper(grid,i+1,0,n)){
		                    return true;
		                }
		            }
		            else{
		                if(helper(grid,i,j+1,n)){
		                    return true;
		                }
		            }
		            grid[i][j] = 0;
		        }
		    }
		    return false;  
		
	}

	private static boolean isSafe(int r, int c, int[][] grid, int k) {
		
		for(int s=0;s<grid.length;s++) {
			if(grid[r][s]==k || grid[s][c]==k) {
				return false;
			}
		}
		int s=(int)Math.sqrt(grid.length);  // size of subgrid.
		
		int rs=r-r%s;
		int cs=c-c%s;  // starting indexes of sub grid row and column.
		
		for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++) {
				if(grid[i+rs][j+cs]==k) {
					return false;
				}
			}
		}
		
		return true;
	}

	
}
