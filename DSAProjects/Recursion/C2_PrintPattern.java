package Recursion;

import java.util.ArrayList;

public class C2_PrintPattern {

	public static void main(String... strings) {

		fun(5);
		
		System.out.println();

		fun2(5, 0);

	}

	private static void fun2(int n, int c) {
		if (n == 0) {

			return;
		}
		if (c < n) {
			System.out.print("*" + " ");
			fun2(n, c + 1);
		} else {
			System.out.println();

			fun2(n - 1, 0);
		}

	}

	private static void fun(int n) {
		if (n == 0) {

			return;
		}
		for (int i = 0; i < n; i++) {
			System.out.print("*" + " ");
		}
		System.out.println();
		fun(n - 1);
	}

}
