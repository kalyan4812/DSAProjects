package Arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class A7_MinimumWindowSubString {
	public static void main(String... strings) {
		String s1 = "badeabcaae";
		String s2 = "aabc";

		fun(s1, s1.length(), s2, s2.length());
	}

	
	//O(N),O(N)-space.
	private static void fun(String s1, int m, String s2, int n) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s2.length(); i++) {
			map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
		}
		// elements to be matched=me.
		int s = 0, e = 0, min = Integer.MAX_VALUE, me = map.size();
		int fs = 0, fe = 0;

		while (e < m) {

			if (map.containsKey(s1.charAt(e))) {
				map.put(s1.charAt(e), map.getOrDefault(s1.charAt(e), 0) - 1);
				if (map.getOrDefault(s1.charAt(e), 0) == 0) {
					me--;
				}
			}

			while (me == 0) {
				if (e - s + 1 < min) {
					min = e - s + 1;
					fs = s;
					fe = e;
				}
				char c = s1.charAt(s);
				if (map.containsKey(c)) {
					
					if(map.get(c)==0) {
						me++;
					}
					map.put(s1.charAt(s), map.get(s1.charAt(s)) + 1);
				}
				s++;
			}

			e++;
		}

		System.out.println(min + " from " + fs + " to " + fe+" "+s1.substring(fs,fe+1));
	}

}
