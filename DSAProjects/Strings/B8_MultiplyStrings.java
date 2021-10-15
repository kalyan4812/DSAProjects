package Strings;

public class B8_MultiplyStrings {

	public static void main(String... strings) {

		System.out.println(multiply("100", "22"));
	}

	public static String multiply(String n1, String n2) {

		if (n1.equals("0") || n2.equals("0")) {
			System.out.println("zero");
			return "0";
		}

		int m1 = n1.length();
		int m2 = n2.length();

		int res[] = new int[m1 + m2];

		String ans = "";

		int i = m2 - 1;
		int pf = 0;
		while (i >= 0) {
			int x = n2.charAt(i) - '0';
			i--;
			int j = m1 - 1;
			int carry = 0;
			int k = res.length - 1 - pf;
			while (j >= 0 || carry != 0) {

				int y = (j >= 0) ? n1.charAt(j) - '0' : 0;
				j--;

				int p = x * y + carry + res[k];
				res[k] = p % 10;
				carry = p / 10;
				k--;
			}

			pf++;

		}

		boolean flag = false;

		for (int u : res) {
			if (u == 0 && flag == false) {
				continue;
			} else {
				ans += u;
				flag = true;
			}
		}

		return ans;
	}
}
