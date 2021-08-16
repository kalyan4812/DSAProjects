package BitManipulation;

public class A7_FindRepeatingAndMissingNumber {

	public static void main(String... strings) {
		int a[] = { 3, 6, 2, 5, 1, 2, 7 };
		find(a);
	}

	// O(N)
	private static void find(int[] a) {
		int res = 0;
		for (int k : a) {
			res = res ^ k;
		}
		for (int i = 1; i <= a.length; i++) {
			res = res ^ i;
		}

		int rsb = res & (-res);

		int x = 0, y = 0;
		for (int p : a) {
			if ((p & (rsb)) != 0) {
				x = x ^ p;
			} else {
				y = y ^ p;
			}
		}
		for (int h : a) {
			if (h == x) {
				System.out.println("repeat: " + x);
				System.out.println("missing: " + y);
				break;

			} else if (h == y) {
				System.out.println("repeat: " + y);
				System.out.println("missing: " + x);
				break;
			}
		}

	}
}
