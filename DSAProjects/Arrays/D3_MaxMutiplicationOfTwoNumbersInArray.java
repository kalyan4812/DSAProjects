package Arrays;

import java.util.Arrays;

public class D3_MaxMutiplicationOfTwoNumbersInArray {

	public static void main(String... strings) {
		int a[] = { -4, 7, -8, 2, 5 };
		fun(a, a.length);

		funUsingSorting(a, a.length);

		int b[] = { -4, 7, -8, 2, 5 };
		fun2(b, b.length);
	}

	//O(n)
	private static void fun2(int[] a, int n) {
		int max = a[0] > a[1] ? a[0] : a[1];
		int secmax = a[0] > a[1] ? a[1] : a[0];
		int min = secmax;
		int secmin = max;

		for (int i = 0; i < n; i++) {

			if (a[i] < min) {
				secmin = min;
				min = a[i];
			} else if (a[i] < secmin && a[i]!=min) {
				secmin = a[i];
				//instead of using a[i]!=min run loop from 2 to n since we have already compared first two elements.
			}
			if (a[i] > max) {
				secmax = max;
				max = a[i];
			} else if (a[i] > secmax && a[i]!=max) {
				secmax = a[i];
			}

		}
		System.out.println(Math.max(min * secmin, max * secmax));

	}

	// O(nlogn)
	private static void funUsingSorting(int[] a, int n) {
		Arrays.sort(a);
		System.out.println(Math.max(a[0] * a[1], a[n - 2] * a[n - 1]));

	}

	// O(n2)
	private static void fun(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] * a[j] > max) {
					max = a[i] * a[j];
				}
			}
		}
		System.out.println(max);
	}
}
