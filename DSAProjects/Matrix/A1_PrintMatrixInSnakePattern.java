package Matrix;

public class A1_PrintMatrixInSnakePattern {

	public static void main(String...strings) {
		int a[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		print(a,a.length,a[0].length);
	}

	private static void print(int[][] a, int n, int m) {
		for(int i=0;i<n;i++) {
			if((i&1)==0) {
				for(int j=0;j<m;j++) {
					System.out.print(a[i][j]+" ");
				}
			}
			else {
				for(int j=m-1;j>=0;j--) {
					System.out.print(a[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
