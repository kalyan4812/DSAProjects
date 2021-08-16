package Recursion;

import java.util.Scanner;

public class A1_FactorialOfANumber {

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k = fact(n);
		System.out.println(k);

		int p = factTailRecursive(n, 1);
		System.out.println(p);
	}

	// t(N) ,modern compilers convert tail recursive code to iterative so space
	// complexity improved.
	private static int factTailRecursive(int n, int res) {
		if (n == 0) {
			return res;
		}
		return factTailRecursive(n - 1, n * res);
	}

	// t(N),t(n)-call back stack.
	private static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}
}
