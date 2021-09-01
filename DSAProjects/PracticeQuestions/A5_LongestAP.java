package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A5_LongestAP {

	public static void main(String... strings) {
		int arr[] = { 2, 4, 6, 8, 10 };

		// print subsequences which form ap.

		Arrays.sort(arr);
		int n = arr.length;
		ArrayList<Integer> al = new ArrayList<>(n);
		for (int i : arr) {
			al.add(i);
		}
		ArrayList<ArrayList<Integer>> ans = go(al);
		HashSet<ArrayList<Integer>> hs = new HashSet<>();
		for (ArrayList<Integer> h : ans) {
			if (h.size() >= 3)
				hs.add(h);
		}
		System.out.println(hs.toString() + "\n" + hs.size());

	}

//-------------------------------------------------------- Recursive solution----------------------------------------------------------	
	private static ArrayList<ArrayList<Integer>> go(ArrayList<Integer> al) {
		if (al.isEmpty()) {
			return new ArrayList<>();
		}
		if (al.size() == 1) {
			ArrayList<ArrayList<Integer>> hs = new ArrayList<>();
			hs.add(new ArrayList<>(Arrays.asList(al.get(al.size() - 1))));

			return hs;
		}

		if (al.size() == 2) {
			ArrayList<ArrayList<Integer>> hs = new ArrayList<>();
			hs.add(new ArrayList<>(Arrays.asList(al.get(al.size() - 2))));
			hs.add(new ArrayList<>(Arrays.asList(al.get(al.size() - 1))));
			hs.add(new ArrayList<>(Arrays.asList(al.get(al.size() - 2), al.get(al.size() - 1))));

			return hs;
		}

		int p = al.get(al.size() - 1);
		al.remove(al.size() - 1);

		ArrayList<ArrayList<Integer>> rem = go(al);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for (ArrayList<Integer> am : rem) {
			ArrayList<Integer> a = new ArrayList<>(am);
			if (a.size() >= 2 && ((a.get(0) - a.get(1)) == (a.get(a.size() - 1) - p))) {

				a.add(p);
				ans.add(new ArrayList<>(a));

			} else if (a.size() == 1) {

				a.add(p);
				ans.add(new ArrayList<>(a));

			}

		}
		rem.add(new ArrayList<>(Arrays.asList(p)));
		ans.addAll(rem);
		return ans;

	}

}
