package PracticeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A5_LongestAP {

	public static void main(String... strings) {
		int arr[] = { 15, 8, 10, 20, 17, 13, 5 };

		// print subsequences which form ap.

		Arrays.sort(arr);
		int n = arr.length;
		ArrayList<Integer> al = new ArrayList<>(n);
		for (int i : arr) {
			al.add(i);
		}
		ArrayList<ArrayList<Integer>> ans = go(al);
		System.out.println(ans.toString());

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

		int i = 0;
		for (ArrayList<Integer> a : rem) {

			if (a.size() >= 2 && ((a.get(0) - a.get(1)) == (a.get(a.size() - 1) - p))) {
				rem.get(i).add(p);

			} else if (a.size() == 1) {
				rem.get(i).add(p);

			} else {
				rem.removeAll(rem.get(i));
			}
			i++;

		}
		return rem;

	}

	
}
