package Matrix;

public class A5_SpiralTraversalOfMatrix {

	public static void main(String... strings) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		spiralTraversal(a, a.length, a[0].length); // n==m

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
