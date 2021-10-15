package Matrix;

public class A4_RoatateMatrixBy90 {

	public static void main(String... strings) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		// naive method : temp[n-j-1][i]=a[i][j];

		rotate(a, a.length, a[0].length);
	}

	// O(n2)
	private static void rotate(int[][] a, int n, int m) {
		transpose(a, n, m);
		// now reverse columns.
		for (int i = 0; i < n; i++) {
			// select a row i ,and reverse elements in that row.
			int l = 0, h = n - 1;
			while (l <= h) {
				int temp = a[i][l];
				a[i][l] = a[i][h];
				a[i][h] = temp;

				l++;
				h--;
			}
		}
		

		display(a, n);

	}

	private static void transpose(int[][] a, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}

	}

	private static void display(int[][] a, int length) {
		for (int k[] : a) {
			for (int p : k) {
				System.out.print(p + " ");

			}
			System.out.println();
		}

	}
}
