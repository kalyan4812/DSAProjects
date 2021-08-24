package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C1_MaxCutsOfRope {

	static int max = Integer.MIN_VALUE;

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// int l = fun(n, a, b, c,0,0,0);
		// System.out.println(l);

		int l = maximizeCuts(n, a, b, c);
		System.out.println(l);

		sc.close();

	}

	public static int maximizeCuts(int n, int x, int y, int z) {
		db = new int[n + 1];
		Arrays.fill(db, -1);
		return fun(n, x, y, z);
	}

	static int db[];

	private static int fun(int len, int a, int b, int c) {
		if (len <= 0) {
			db[len] = 0;
			return db[len];
		}
		if (db[len] != -1) {
			return db[len];
		}
		int p = Integer.MIN_VALUE, q = Integer.MIN_VALUE, r = Integer.MIN_VALUE;

		if (len >= a) {
			p = 1 + ((db[len - a] != -1) ? db[len - a] : fun(len - a, a, b, c));
		}
		if (len >= b) {
			q = 1 + ((db[len - b] != -1) ? db[len - b] : fun(len - b, a, b, c));
		}
		if (len >= c) {
			r = 1 + ((db[len - c] != -1) ? db[len - c] : fun(len - c, a, b, c));
		}

		db[len] = Math.max(Math.max(p, q), r);
		return db[len];

	}

	private static int fun(int len, int a, int b, int c, int p, int q, int r) {
		if (len < 0) {
			return -1;
		}
		if (len == 0) {

			max = Math.max(Math.max(p, q), r);

		}

		if (len >= a || len >= b || len >= c) {

			fun(len - a, a, b, c, p + 1, q, r);
			fun(len - b, a, b, c, p, q + 1, r);
			fun(len - c, a, b, c, p, q, r + 1);
		}

		return max;

	}
}
