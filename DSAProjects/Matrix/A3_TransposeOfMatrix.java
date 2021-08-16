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
			for (int j = i; j < n; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		
		display(a, a.length);
	}
}
