package Matrix;

public class B2_PrefixSumFor2d {

	public static void main(String... strings) {

		int a[][] = { { 1, 1 }, { 1, 1 } };

		int prefix[][] = getPrefix(a);
		
		for(int a1[]:prefix) {
			for(int k:a1) {
				System.out.print(k+" ");
			}
			System.out.println();
		}

	}

	private static int[][] getPrefix(int[][] a) {
		int n = a.length;
		int m = a[0].length;

		int prefix[][] = new int[n][m];
		
		prefix[0][0]=a[0][0];
		
		for(int i=1;i<n;i++) {
			prefix[i][0]=prefix[i-1][0]+a[i][0];
		}
		
		for(int j=1;j<m;j++) {
			prefix[0][j]=prefix[0][j-1]+a[0][j];
		}
		

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
              prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+a[i][j];
			}
		}
		return prefix;
	}

}
