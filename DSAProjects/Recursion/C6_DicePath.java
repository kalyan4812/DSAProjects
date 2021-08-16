package Recursion;

public class C6_DicePath {

	public static void main(String...strings) {
		
		int n=4;
		
		dicePath(n,0,"");
		
		// from a block you can take 1 to 6 moves only.
	}

	private static void dicePath(int n, int i, String op) {
	
		if(i>=n) return;
		
		if(i==n-1) {
			System.out.println(op);
			return;
		}
		for(int j=1;j<=6;j++) {
			dicePath(n,i+j,j+"->"+op);
		}
		
	}
}
