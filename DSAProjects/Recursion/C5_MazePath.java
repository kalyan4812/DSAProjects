package Recursion;

public class C5_MazePath {

	public static void main(String...strings) {
		// given n*m matrix,go from 0,0 to n-1,m-1 .and you can move right,down,diagnolly.
		
		int n=3,m=3;
		
		mazePath(0,0,n,m,"");
		
		System.out.println("Num of paths : "+num_of_paths);
	}

	static int num_of_paths=0;
	private static void mazePath(int i, int j, int n, int m, String op) {
		if(i>=n || j>=m) {
			return;
		}
		if(i==n-1 && j==m-1) {
			num_of_paths++;
			System.out.println(op);
			return;
		}
		mazePath(i, j+1,  n,  m, "R" +op); // right move
		mazePath(i+1, j,  n,  m, "D" +op);  // down move
		
		//mazePath(i+1, j+1,  n,  m, "->" +op); // diagnol move
		
		
	}
}
