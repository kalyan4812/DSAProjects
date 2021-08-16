package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class B6_MostFrequentWordInString {
	static Map<String, Integer> m = new HashMap<>();

	public static void main(String... strings) {
		String s = "no hi no hi yes";

		// if more than one word print aplhabetically.
		fun(s, s.length());

	}

	
	//O(nlogn),O(N)-space.
	private static void fun(String s, int n) {
		s = s.replaceAll("[^a-zA-Z0-9]", " ");
		String str[] = s.split(" +");
       Character c=s.charAt(0);
       
      
		int max = 0;
		for (String word : str) {
			word = word.toLowerCase();
			m.put(word, m.getOrDefault(word, 0) + 1);
			max = Math.max(m.get(word), max);
		}

		ArrayList<String> finallist = new ArrayList<>();
		for (Map.Entry e : m.entrySet()) {
			if (e.getValue().equals(max)) {
				finallist.add(e.getKey().toString());
			}
		}
		Collections.sort(finallist, new MyComparator());

		System.out.print(finallist);
	}

	public static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {

			if (m.get(o2) != m.get(o1)) {
				return m.get(o2) - m.get(o1);
			}
			return o1.compareTo(o2);

		}

	}
}
