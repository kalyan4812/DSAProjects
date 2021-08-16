package BackTracking;

import java.util.ArrayList;

public class B5_GenerateValidIpV4Address {

	public static void main(String... strings) {
		String s = "1902426";
		generate(s, s.length());
		System.out.print(res.toString());
	}

	static ArrayList<String> res = new ArrayList<>();

	private static void generate(String s, int n) {
		int i, j, k;

		for (i = 0; i < n - 3; i++) {
			for (j = i + 1; j < n - 2; j++) {
				for (k = j + 1; k < n - 1; k++) {
					if (valid_ip(s, n, i, j, k)) {
						add_string(s, n, i, j, k, res);
					}
				}
			}
		}

	}

	private static void add_string(String s, int n, int i, int j, int k, ArrayList<String> res2) {

		StringBuilder sb=new StringBuilder();
		sb.append(s.substring(0, i+1));
		sb.append(".");
		sb.append(s.substring(i+1, j+1));
		sb.append(".");
		sb.append(s.substring(j+1, k+1));
		sb.append(".");
		sb.append(s.substring(k+1, n));
		
		res2.add(sb.toString());
		
	}

	private static boolean valid_ip(String s, int len, int i, int j, int k) {
		if (valid_subpart(s, 0, i) && valid_subpart(s, i + 1, j) && valid_subpart(s, j + 1, k)
				&& valid_subpart(s, k + 1, len - 1))
			return true;
	
		return false;
	}

	private static boolean valid_subpart(String s, int i, int j) {
		int len = j - i + 1;

		if (len > 3)
			return false;

		if (s.charAt(i) == '0') {
			if (len == 1)
				return true;
			return false;
		}

		int num = Integer.valueOf(s.substring(i, j + 1));
		if (num >= 0 && num <= 255)
			return true;
		return false;
	}
}
