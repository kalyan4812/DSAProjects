package Matrix;

public class A5_SpiralTraversalOfMatrix {

	public static void main(String... strings) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		spiralTraversal(a, a.length, a[0].length); // n==m

		spiralTraversal2(a, a.length, a[0].length);

	}

	private static void spiralTraversal2(int[][] a, int n1, int m1) {
		int minr = 0, maxr = n1 - 1, minc = 0, maxc = m1 - 1;
		int c = 0;
		int t = n1 * m1;
		while (c < n1 * m1) {

			for (int i = minr, j = minc; i <= maxr && c < t; i++) {
				System.out.println(a[i][j]);
				c++;
			}
			minc++;

			for (int i = minc, j = maxr; i <= maxc && c < t; i++) {
				System.out.println(a[j][i]);
				c++;
			}

			maxr--;

			for (int i = maxr, j = maxc; i >= minr && c < t; i--) {
				System.out.println(a[i][j]);
				c++;
			}

			maxc--;

			for (int i = maxc, j = minr; i >= minc && c < t; i--) {
				System.out.println(a[j][i]);
				c++;
			}

			minr++;

		}

	}

	// O(n^2)
	private static void spiralTraversal(int[][] a, int n, int m) {
		int top = 0, left = 0, bot = n - 1, right = m - 1;
		while (top <= bot && left <= right) {

			// top row
			for (int i = left; i <= right; i++) {
				System.out.print(a[top][i] + " ");
			}
			top++;

			// right column
			for (int i = top; i <= bot; i++) {
				System.out.print(a[i][right] + " ");
			}
			right--;

			// bottom row in reverse order.
			if (top <= bot) {
				for (int i = right; i >= left; i--) {
					System.out.print(a[bot][i] + " ");
				}
			}
			bot--;

			if (left <= right) {
				for (int i = bot; i >= top; i--) {
					System.out.print(a[i][left] + " ");
				}
				left++;
			}

		}
	}

}
