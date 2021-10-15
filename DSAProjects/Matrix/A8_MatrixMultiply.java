package Matrix;

import java.util.Scanner;

public class A8_MatrixMultiply {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int m1 = sc.nextInt();

		int a[][] = new int[n1][m1];

		for (int i = 0; i < n1; i++) {

			for (int j = 0; j < m1; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int n2 = sc.nextInt();
		int m2 = sc.nextInt();

		int b[][] = new int[n2][m2];

		for (int i = 0; i < n2; i++) {

			for (int j = 0; j < m2; j++) {
				b[i][j] = sc.nextInt();
			}
		}

		if (m1 != n2) {
			System.out.println("Invalid input");
			return;
		}

		int ans[][] = new int[n1][m2];

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m2; j++) {
				for (int k = 0; k < n2; k++) {
					ans[i][j] += a[i][k] * b[k][j];
				}
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}
}
