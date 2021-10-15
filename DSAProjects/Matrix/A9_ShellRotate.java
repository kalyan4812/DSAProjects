package Matrix;

import java.util.Scanner;

public class A9_ShellRotate {

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

		int s = sc.nextInt();
		int r = sc.nextInt();

		rotateShell(a, s, r);

		

	}

	public static void rotateShell(int a[][], int s, int r) {
		int d[] = getOneDFromShell(a, s);
		rotateoneD(d, r);
		fillShellFromArray(a, s, d);
	}

	public static void fillShellFromArray(int a[][], int s, int d[]) {
		int n1 = a.length;
		int m1 = a[0].length;
		int minr = s - 1, maxr = n1 - s, minc = s - 1, maxc = m1 - s;
		int c = 0;
		int t = 2 * (maxr - minr + 1) + 2 * (maxc - minc + 1) - 4;

		while (c < t) {

			for (int i = minr, j = minc; i <= maxr && c < t; i++) {
				// System.out.println(a[i][j]);
				a[i][j] = d[c];
				c++;
			}
			minc++;

			for (int i = minc, j = maxr; i <= maxc && c < t; i++) {
				a[j][i] = d[c];
				c++;
			}

			maxr--;

			for (int i = maxr, j = maxc; i >= minr && c < t; i--) {
				a[i][j] = d[c];
				c++;
			}

			maxc--;

			for (int i = maxc, j = minr; i >= minc && c < t; i--) {
				a[j][i] = d[c];
				c++;
			}

			minr++;

		}

	}

	public static int[] getOneDFromShell(int a[][], int s) {

		int n1 = a.length;
		int m1 = a[0].length;
		int minr = s - 1, maxr = n1 - s, minc = s - 1, maxc = m1 - s;
		int c = 0;
		int t = 2 * (maxr - minr + 1) + 2 * (maxc - minc + 1) - 4;

		int ans[] = new int[t];
		while (c < t) {

			for (int i = minr, j = minc; i <= maxr && c < t; i++) {
				// System.out.println(a[i][j]);
				ans[c] = a[i][j];
				c++;
			}
			minc++;

			for (int i = minc, j = maxr; i <= maxc && c < t; i++) {
				ans[c] = a[j][i];
				c++;
			}

			maxr--;

			for (int i = maxr, j = maxc; i >= minr && c < t; i--) {
				ans[c] = a[i][j];
				c++;
			}

			maxc--;

			for (int i = maxc, j = minr; i >= minc && c < t; i--) {
				ans[c] = a[j][i];
				c++;
			}

			minr++;

		}
		return ans;

	}

	public static void rotateoneD(int c[], int r) {
		r = r % c.length;
		if (r < 0) {
			r = r + c.length;
		}
		reverseArrayFromXtoY(c, 0, c.length - r - 1);
		reverseArrayFromXtoY(c, c.length - r, c.length - 1);
		reverseArrayFromXtoY(c, 0, c.length - 1);
	}

	private static void reverseArrayFromXtoY(int[] a, int i, int j) {
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}

	}

}
