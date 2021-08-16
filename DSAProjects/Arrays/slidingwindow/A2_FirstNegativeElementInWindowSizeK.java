package Arrays.slidingwindow;

import java.util.ArrayList;

public class A2_FirstNegativeElementInWindowSizeK {

	public static void main(String... strings) {
		int a[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;

		fun(a, a.length, k);

		fun2(a, a.length, k);
	}

	// O(N),window,O(k)-space.
	private static void fun2(int[] a, int n, int k) {
		int s = 0, e = 0;
		ArrayList<Integer> al = new ArrayList<>();
		while (e < n) {
			if (a[e] < 0) {
				al.add(a[e]);
			}

			if (e - s + 1 == k) {
				if (al.size() == 0) {
					System.out.print("0" + " ");
				} else {
					System.out.print(al.get(0) + " ");

					if (a[s] == al.get(0)) {
						al.remove(0);
					}
				}
				s++;
			}
			e++;
			
		}

	}

	// O(n2)
	private static void fun(int[] a, int n, int k) {
		for (int i = 0; i < n - k + 1; i++) {
			boolean hasneg = false;
			for (int j = i; j < k + i; j++) {
				if (a[j] < 0) {
					System.out.print(a[j] + " ");
					hasneg = true;
					break;
				}
			}
			if (!hasneg) {
				System.out.print("0" + " ");
			}

		}
		System.out.println();

	}
}
