package Recursion;

import java.util.Scanner;

public class B2_TowerOfHanoi {
	static int count = 0;

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long k = toh(n, 1, 2, 3);
		System.out.println(k);

		sc.close();
	}

	
	//O(2^n)
	public static long toh(int N, int from, int to, int aux) {
		count++;
		if (N == 1) {
			System.out.println("move disk 1 from rod " + from + " to rod " + to);
			return 1;
		}

		toh(N - 1, from, aux, to);

		System.out.println("move disk " + (N) + " from rod " + from + " to rod " + to);

		toh(N - 1, aux, to, from);

		return count;
	}
}
