package Recursion;

import java.util.Scanner;

public class A2_Pattern {
	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		fun(n); // output 321123 for n==3.
		System.out.println();

		fun2(n, 1); // output 123321 for n==3.
		System.out.println();

		fun3(n); // output 321 for n==3.
		System.out.println();

		fun4(n); // output 123 for n==3.
		System.out.println();

	}

	// t(N)
	private static void fun4(int n) {
		if (n < 1) {
			return;
		}
		fun4(n - 1);
		System.out.print(n + " ");

	}

	// t(N)
	private static void fun3(int n) {

		if (n < 1) {
			return;
		}

		System.out.print(n + " ");
		fun3(n - 1);
	}

	// t(N)
	private static void fun2(int n, int res) {
		if (n < 1) {
			return;
		}
		System.out.print(res + " ");
		fun2(n - 1, res + 1);
		System.out.print(res + " ");

	}

	// t(N)
	private static void fun(int n) {
		if (n < 1) {
			return;
		}
		System.out.print(n + " ");
		fun(n - 1);
		System.out.print(n + " ");
	}
}
