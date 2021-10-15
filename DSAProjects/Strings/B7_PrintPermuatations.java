package Strings;

public class B7_PrintPermuatations {

	public static void main(String[] args) {

		String str = "abc";
		solution(str);
	}

	// iterative way.
	public static void solution(String s) {

		int n = s.length();
		int f = fact(n);

		for (int i = 0; i < f; i++) {

			StringBuilder sb = new StringBuilder(s);
			int temp = i;
			for (int div = n; div >= 1; div--) {

				int q = temp / div;
				int r = temp % div;

				System.out.print(sb.charAt(r));
				sb.deleteCharAt(r);

				temp = q;
			}

			System.out.println();

		}

	}

	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}

}
