package BitManipulation;

public class B2_XOROfSumOfAllPairs {

	public static void main(String... strings) {
		int a[] = { 1, 2, 3, 4 };

		fun(a);
	}

	// idea:for array of a,b,c,d all pairs will be get cancelled at last there will
	// be 2a,2b,2c,2d.
	private static void fun(int[] a) {
		int res = 0;
		for (int p : a) {
			res = res ^ (2 * p);
		}
		System.out.println(res);
	}
}
