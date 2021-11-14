package BitManipulation;

public class A1_Basics {

	public static void main(String... strings) {
		int x = 3, y = 6;

		System.out.println("AND OPERATOR : " + (x & y)); // multiply binary digits.
		System.out.println("OR OPERATOR : " + (x | y)); // add binary digits.
		System.out.println("XOR OPERATOR : " + (x ^ y)); // when digits are different then 1 else 0.

		// In java negative numbers are represented as (-x)=2^32-x;
		System.out.println("NOT OPERATOR : " + (~x));

		System.out.println("RIGHT SHIFT OPERATOR : " + (x >> 1)); // trick: x>>y== x/2^y.

		System.out.println("LEFT SHIFT OPERATOR : " + (x << 1)); // trick: x<<y==x*2^y.

		

		System.out.println(fun(10265,16,4));
	}

	static int fun(int num, int k, int r) {
		String s = Integer.toString(num, 2);
		StringBuilder sb = new StringBuilder(s);

		int x = Math.abs(s.length() - k);
		while (x > 0) {
			sb.insert(0, '0');
			x--;
		}

		String k1 = sb.toString();
		String j = k1.substring(k1.length() - r) + k1.substring(0, k1.length() - r);

		Integer p = Integer.parseInt(j, 2);
		return p;
	}

}
