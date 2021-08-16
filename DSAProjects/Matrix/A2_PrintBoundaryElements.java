package Matrix;

public class A2_PrintBoundaryElements {

	public static void main(String...strings) {
		int a[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		print(a,a.length,a[0].length);
	}

	//O(n+m)
	private static void print(int[][] a, int n, int m) {
		for(int i=0;i<n;i++) {
			if(i==0) {
				for(int j=0;j<m;j++) {
					System.out.print(a[i][j]+" ");
				}
			}
			if(i>=1 && i<n-1) {
				System.out.print(a[i][m-1]+" ");
			}
			if(i==n-1) {
				for(int j=m-1;j>=0;j--) {
					System.out.print(a[i][j]+" ");
				}
				
				for(int j=m-2;j>=1;j--) {
					System.out.print(a[j][0]+" ");
				}
				
			}
			System.out.println();
		}
	}
}
