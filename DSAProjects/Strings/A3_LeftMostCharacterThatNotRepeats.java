package Strings;

import java.util.ArrayList;
import java.util.HashMap;

public class A3_LeftMostCharacterThatNotRepeats {

	public static void main(String... strings) {
		String s = "geeks for geeks";
		fun1(s, s.length());
		fun2(s, s.length());
		fun3(s, s.length());
	}

	
	//O(n),O(256) in one traversal
	private static void fun3(String s, int n) {
		ArrayList<Integer> al = new ArrayList<>(256);
		for (int i = n - 1; i >= 0; i--) {
			if (al.contains(Integer.valueOf(s.charAt(i)))) {
				al.remove(Integer.valueOf(s.charAt(i)));
				al.add(al.size() - 1, Integer.valueOf(s.charAt(i)));
			} else {
				al.add(0, Integer.valueOf(s.charAt(i)));
			}
		}
		System.out.println(al.toString());
		int i = al.get(0);
		char c = (char) i;
		System.out.println(s.indexOf(c) + "  " + c);
	}

	// O(n),t(256)-space.
	private static void fun2(String s, int n) {
		int f[] = new int[256];
		for (int i = 0; i < n; i++) {

			f[s.charAt(i)]++;

		}
		for (int i = 0; i < n; i++) {
			if (f[s.charAt(i)] == 1) {
				System.out.println(i + " " + s.charAt(i));
				break;
			}
		}

	}

	// O(n),t(256)-space.
	private static void fun1(String s, int n) {
		int res = Integer.MAX_VALUE;
		int f[] = new int[256];
		for (int i = 0; i < 256; i++) {
			f[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			if (f[s.charAt(i)] == -1) {
				f[s.charAt(i)] = i;
			} else {
				f[s.charAt(i)] = -2;
			}
		}
		for (int i = 0; i < 256; i++) {
			if (f[i] >= 0) {
				res = Math.min(res, f[i]);
			}
		}
		System.out.println((res == Integer.MAX_VALUE) ? -1 : res);
	}
}
