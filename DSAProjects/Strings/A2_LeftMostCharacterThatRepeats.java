package Strings;

import java.util.HashSet;

public class A2_LeftMostCharacterThatRepeats {

	public static void main(String... strings) {
		String s = "geeks for geeks";
		fun1(s, s.length());
		fun2(s, s.length());
		fun3(s, s.length());
	}

	// O(n),O(N)-space.
	private static void fun3(String s, int n) {
		HashSet<Character> h = new HashSet<>();
		int repeatvalue = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (h.contains(s.charAt(i))) {
				repeatvalue = i;
			} else {
				h.add(s.charAt(i));
			}
		}

		System.out.println(repeatvalue);

	}

	// O(n),O(256)-space
	private static void fun2(String s, int n) {
		int res = Integer.MAX_VALUE;
		int f[] = new int[256];
		for (int i = 0; i < 256; i++) {
			f[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			if (f[s.charAt(i)] == -1) {
				f[s.charAt(i)] = i;
			} else {
				res = Math.min(res, f[s.charAt(i)]);
			}
		}
		System.out.println((res == Integer.MAX_VALUE) ? -1 : res);

	}

	// O(N2)
	private static void fun1(String s, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (s.charAt(j) == s.charAt(i)) {
					System.out.println(i + " " + s.charAt(i));
					return;
				}
			}
		}
		System.out.print("No Repeating Character");
	}
}
