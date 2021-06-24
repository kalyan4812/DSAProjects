package Recursion;

import java.util.Scanner;

public class A5_SumOfDigitsInANumber {

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k = fun(n);
		System.out.println(k);

		int p = funTailRecursive(n, 0);
		System.out.println(p);
	}

	// t(n)
	private static int funTailRecursive(int n, int res) {
		if (n == 0) {
			return res;
		}

		return funTailRecursive(n / 10, res + n % 10);
	}

	// t(n)
	private static int fun(int n) {
		if (n < 10) {
			return n;
		}
		return (n % 10) + fun(n / 10);
	}
}
