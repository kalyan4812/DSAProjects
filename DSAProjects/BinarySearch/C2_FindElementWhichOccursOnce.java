package BinarySearch;

public class C2_FindElementWhichOccursOnce {

	public static void main(String... strings) {
		int a[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };

		int k = fun(a);
		System.out.println(k);

		int p = fun2(a);
		System.out.println(p);

	}

	// O(logn)
	// idea is dividing into left half(1,1) and right half(2,3,3,4,4,8,8) .on right
	// half for repeating elements first instance is odd,second instance is even
	// vice versa for left half.

	// ans will be a[low],low will cross high after iteration,in case is non
	// repeating element is last element then low cross bounds,so better take
	// high as last second index.

	// xor of odd index with 1 gives previous index,if even it gives next index.
	private static int fun2(int[] a) {
		int l = 0, h = a.length - 2;
		while (l <= h) {
			int m = l + (h - l) / 2;
			// check if its left half.
			if (a[m] == a[m ^ 1]) {
				l = m + 1;
			} else {
				h = m - 1;
			}

		}
		return a[l];
	}

	// O(N) XOR Approach,idea xor of two similar numbers is zero & 0^x=x.
	private static int fun(int[] a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res = res ^ a[i];
		}
		return res;
	}
}
