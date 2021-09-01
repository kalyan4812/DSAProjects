package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class C1_GenerateAllPossibleSubsetSums {

	public static void main(String... strings) {
		int a[] = { 4, 2, 5, 2 };

		HashSet<Integer> hs = fun(a, a.length);
		System.out.println(hs.toString());

		HashSet<Integer> h = dpfun(a, a.length);
		System.out.println(h.toString());
	}

	
	private static HashSet<Integer> dpfun(int[] a, int n) {
		IntegerBox dp[] = new IntegerBox[n];
		dp[0] = new IntegerBox();
		dp[0].addNumber(a[0]);

		for (int i = 1; i < n; i++) {
			dp[i] = new IntegerBox();
			for (int p : dp[i - 1].getAllSums()) {
				dp[i].addNumber(p + a[i]);
			}
			dp[i].getAllSums().addAll(dp[i-1].getAllSums());
			dp[i].addNumber(a[i]);
		}

		return dp[n - 1].getAllSums();
	}

	static class IntegerBox {
		HashSet<Integer> al;

		public IntegerBox() {
			al = new HashSet<>();

		}

		void addNumber(Integer s) {
			al.add(s);
		}

		HashSet<Integer> getAllSums() {
			return al;
		}

	}

	private static HashSet<Integer> fun(int[] a, int n) {
		if (n <= 0) {
			return new HashSet<Integer>();
		}

		int k = a[n - 1];
		HashSet<Integer> rem = fun(a, n - 1);

		HashSet<Integer> al = new HashSet<>();
		for (int i : rem) {
			al.add(i + k);
		}
		rem.add(k);
		rem.addAll(al);

		return rem;
	}
}
