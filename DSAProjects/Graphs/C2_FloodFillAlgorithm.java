package Graphs;

public class C2_FloodFillAlgorithm {

	public static void main(String...strings) {
		
		int a[][]= {{0,2,2,2,2},{4,2,4,2,5},{5,6,9,4,5},{7,7,7,5,5},{7,8,9,1,2,4}};
		
		for(int b[]:a) {
			 for(int p:b) {
				 System.out.print(p+" ");
			 }
			 System.out.println();
		 }
		
		System.out.println();
		
		int n=a[0].length; // columns.
		int m=a.length; // rows.
		
		int oc=a[1][3]; // old color.
		int nc=8;
		
		
		 floodFill(1,3,n,m,oc,nc,a);
		 
		 
		 for(int b[]:a) {
			 for(int p:b) {
				 System.out.print(p+" ");
			 }
			 System.out.println();
		 }
	}

	//O(3*mn)
	private static void floodFill(int x, int y, int n, int m, int oc, int nc, int[][] a) {
		
		if(y<0||y>=m||x<0|| x>=n) return;
		
		if(a[x][y]!=oc) return;
		
		a[x][y]=nc;
		floodFill(x-1,y,n,m,oc,nc,a);
		floodFill(x+1,y,n,m,oc,nc,a);
		floodFill(x,y-1,n,m,oc,nc,a);
		floodFill(x,y+1,n,m,oc,nc,a);
		
	}
}
