package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class E4_ScrambledString {

	public static void main(String... strings) {

		String s1 = "great";
		String s2 = "rgeat";

		boolean c = recursiveSol(s1, s2);
		System.out.println(c);

		db = new HashMap<>();
		boolean d = memeSol(s1, s2);
		System.out.println(d);

	}
	/*
	 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
Below is one possible representation of A = “great”:
 great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.
	 
	 

	 
	 */

	static Map<String, Boolean> db;

	private static boolean memeSol(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if (s1.equals(s2)) {
			return true;
		}
		if (s1.length() <= 1 || s2.length() <= 1) {
			return false;
		}
		if (db.get(s1 + "_" + s2) != null) {
			return db.get(s1 + "_" + s2);
		}
		int n = s1.length();
		boolean flag = false;
		for (int k = 1; k <= n - 1; k++) {

			boolean cond1 = memeSol(s1.substring(0, k), s2.substring(n - k))
					&& memeSol(s1.substring(k, n), s2.substring(0, n - k));

			boolean cond2 = memeSol(s1.substring(0, k), s2.substring(0, k))
					&& memeSol(s1.substring(k, n), s2.substring(k, n));

			if (cond1 || cond2) {
				flag = true;
				break;
			}

		}
		db.put(s1 + "_" + s2, flag);
		return db.get(s1 + "_" + s2);
	}

	private static boolean recursiveSol(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if (s1.equals(s2)) {
			return true;
		}
		if (s1.length() <= 1 || s2.length() <= 1) {
			return false;
		}
		int n = s1.length();
		boolean flag = false;
		for (int k = 1; k <= n - 1; k++) {

			boolean cond1 = recursiveSol(s1.substring(0, k), s2.substring(n - k))
					&& recursiveSol(s1.substring(k, n), s2.substring(0, n - k));

			boolean cond2 = recursiveSol(s1.substring(0, k), s2.substring(0, k))
					&& recursiveSol(s1.substring(k, n), s2.substring(k, n));

			if (cond1 || cond2) {
				flag = true;
				break;
			}

		}
		return flag;
	}
}
