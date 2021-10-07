package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class C8_NotATriangle {

	/*
	 * You have N (3 ≤ N ≤ 2,000) wooden sticks, which are labeled from 1 to N. The
	 * i-th stick has a length of Li (1 ≤ Li ≤ 1,000,000). Your friend has
	 * challenged you to a simple game: you will pick three sticks at random, and if
	 * your friend can form a triangle with them (degenerate triangles included), he
	 * wins; otherwise, you win. You are not sure if your friend is trying to trick
	 * you, so you would like to determine your chances of winning by computing the
	 * number of ways you could choose three sticks (regardless of order) such that
	 * it is impossible to form a triangle with them.
	 */

	// for normal triangle a+b>c ,degenerate means a+b=c is also allowed.
	// for not to form a triangle a+b<c.==> c>a+b.

	// lower_bound returns firstvalue in array which is >=target. // in java you can
	// use Collections.binarySearch function.
	// uppeer_bound retuns first value in array>target.(here we need c>a+b).

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		while (true) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			Arrays.sort(a);
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n - 1; j++) {
					int k = a[i] + a[j];
					// upper(a,k) gives index.
					// to get total possible pairs.
					ans += (n - 1) - upper(a, k);
				}
			}

			System.out.println(ans);

			n = sc.nextInt();
			if (n == 0) {
				break;
			}
		}

	}

	public static int upper(int arr[], int key) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = low + (high - low + 1) / 2;
			if (arr[mid] <=key) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
}
