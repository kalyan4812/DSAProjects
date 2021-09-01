package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import PracticeQuestions.C1_GenerateAllPossibleSubsetSums.IntegerBox;

public class C2_ArthimeticSlices {

	public static void main(String... strings) {
		int arr[] = { 0, 2000000000, -294967296 };

		// print subsequences which form ap.

		int ans = numberOfArithmeticSlices(arr);

		System.out.println(ans);

		int ans2 = FunUsingLisApproach(arr);
		System.out.println(ans2);

	}

	//O(n2)
	private static int FunUsingLisApproach(int[] arr) {

		return lis(arr, arr.length);
	}
	
	private static int lis(int[] a, int n) {

		HashMap<String, Integer> dp = new HashMap<>(n);
		if (n == 1) {
			return 0;
		}
		int diff =( a[1]%mod - a[0]%mod)%mod;
		dp.put(1 + "_" + diff, 1);

		int ans = 0;
		for (int i = 2; i < n; i++) {

			for (int j = i - 1; j >= 0; j--) {
				diff = (a[i]%mod - a[j]%mod)%mod;
				if (dp.containsKey(j + "_" + diff)) {
					dp.put(i + "_" + diff, dp.getOrDefault(i + "_" + diff, 0)+dp.getOrDefault(j + "_" + diff, 0) + 1);
					ans = ans + dp.getOrDefault(j + "_" + diff, 0);
				} else {
					dp.put(i + "_" + diff, dp.getOrDefault(i + "_" + diff, 0) + 1);
				}
			}
		}

		return ans;
	}

// Giving TLE --------------------------------------------------------------------------------------------------------------	
	public static int numberOfArithmeticSlices(int[] arr) {

		boolean all_same = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				all_same = false;
				break;
			}
		}
		if (all_same) {

			return (int) ((long) Math.pow(2, arr.length) - (arr.length) - nCr(arr.length, 2) - 1);
		}

		ArrayList<ArrayList<Integer>> ans = tabSol(arr, arr.length);

		return ans.size();

	}

	private static ArrayList<ArrayList<Integer>> tabSol(int[] a, int n) {
		IntegerBox dp[] = new IntegerBox[n];
		dp[0] = new IntegerBox();
		dp[0].addNumber(new ArrayList<>(Arrays.asList(a[0])));

		for (int i = 1; i < n; i++) {
			dp[i] = new IntegerBox();
			int k = a[i];

			for (ArrayList<Integer> p : dp[i - 1].getAllSubsequences()) {
				ArrayList<Integer> z = new ArrayList<>(p);

				if (p.size() >= 2
						&& ((p.get(0) % mod - p.get(1) % mod) % mod == (p.get(p.size() - 1) % mod - k % mod) % mod)) {
					z.add(k);
					dp[i].addNumber(new ArrayList<>(z));

				} else if (p.size() == 1) {
					z.add(k);
					dp[i].addNumber(new ArrayList<>(z));
				}

			}

			dp[i].getAllSubsequences().addAll(dp[i - 1].getAllSubsequences());

			dp[i].addNumber(new ArrayList<>(Arrays.asList(k)));
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (ArrayList<Integer> j : dp[n - 1].getAllSubsequences()) {
			if (j.size() >= 3) {
				ans.add(j);
			}
		}
		return ans;
	}

	static class IntegerBox {
		ArrayList<ArrayList<Integer>> al;

		public IntegerBox() {
			al = new ArrayList<>();

		}

		void addNumber(ArrayList<Integer> s) {
			al.add(s);
		}

		ArrayList<ArrayList<Integer>> getAllSubsequences() {
			return al;
		}

	}

	static int mod = 1000000000 + 7;

	static int nCr(int n, int r) {
		if (n < r)
			return 0;
		r = Math.min(r, n - r);

		int dp[] = new int[r + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, r); j > 0; j--) {
				dp[j] = (dp[j - 1] + dp[j]) % mod;
			}
		}

		return dp[r];

	}
}
