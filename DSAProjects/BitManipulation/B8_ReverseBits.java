package BitManipulation;

public class B8_ReverseBits {

	public static void main(String... strings) {
		int n = 11;

		System.out.print(reverse(n));
	}

	private static int reverse(int n) {
		String res = "";
		boolean flag = false;
		for (int i = 31; i >= 0; i--) {
			int mask = 1 << i;
			if (flag) {
				if ((n & mask) != 0) {

					System.out.print(1);
					res = "1" + res;
				} else {
					System.out.print(0);
					res = "0" + res;
				}
			} else {
				if ((n & mask) != 0) {
					flag = true; // Encountered first one.
					System.out.print(1);
					res = "1" + res;
				} else {

				}
			}
		}
		System.out.println();
		return Integer.valueOf(res, 2);
	}
}
