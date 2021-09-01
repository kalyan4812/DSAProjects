package Qeues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import Sorting.SortArrayBasedOnFrequency.MyComparator;

public class Q1 {

	public static void main(String...strings) {
		String s="HelloWorld";
		
		String k=fun(s,s.length());
		System.out.println(k);
	}
	static Map<Character, Integer> m = new HashMap<>();
	private static String fun(String s, int n) {
		m.clear();
		Character c[]=new Character[n];
		for (int i = 0; i < n; i++) {
			m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
			c[i]=s.charAt(i);
		}
		
		
		
		
		Arrays.sort(c, new MyComparator());
		
		char c1[]=new char[n];
		ArrayList<Character> hs=new ArrayList<>();
		for(char k:c) {
			if(hs.contains(k)==false)
			hs.add(k);
		}
		
		int i=0;
		for(char p:hs) {
			c1[i]=p;
			i++;
		}
		
		return new String(c1);
		// loHeWrd
	}
	
	public static class MyComparator implements Comparator<Character> {

		@Override
		public int compare(Character o1, Character o2) {
			int f1 = m.get(o1);
			int f2 = m.get(o2);
			if (f1 != f2) {
				return f2 - f1;
			}

			return 0;
		}

		

	}
}
