package Matrix;

public class A3_TransposeOfMatrix {

	public static void main(String... strings) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		transpose(a, a.length, a[0].length); // n==m

	}

	private static void display(int[][] a, int length) {
		for (int k[] : a) {
			for (int p : k) {
				System.out.print(p + " ");

			}
			System.out.println();
		}

	}

	// O(n^2)
	private static void transpose(int[][] a, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {  // or j=0;j<i;j++ // or j=i+1;j<n;j++
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}

		display(a, a.length);
	}

	// for m*n matrix,after transpose new matrix will be n*m dimension.
	public static int[][] transpose(int[][] a) {

		int m = a.length;
		int n = a[0].length;
		int b[][] = new int[n][m];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				b[i][j] = a[j][i];
			}
		}
		return b;

	}
}
