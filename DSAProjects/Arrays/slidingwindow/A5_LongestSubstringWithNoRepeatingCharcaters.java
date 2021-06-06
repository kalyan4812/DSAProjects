package Arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class A5_LongestSubstringWithNoRepeatingCharcaters {
	public static void main(String... strings) {
		String s = "bccbababd";
		fun(s, s.length());
	}

	private static void fun(String s, int n) {
	
		Map<Character, Integer> h = new HashMap<>();
		int maxlen = 0, st = 0, e = 0;

		while (e < n) {
			char c = s.charAt(e);
			
			h.put(c, h.getOrDefault(c, 0) + 1);

			if (h.size() == e-st+1) {
				maxlen = Math.max(maxlen, e - st + 1);
			}
			while (h.size() < e-st+1) {
				char front = s.charAt(st);
				h.put(front, h.getOrDefault(front, 0) - 1);

				if (h.get(front) == 0) {
					h.remove(front);
				}
			
				st++;
			}

			e++;
		}

		System.out.println(maxlen);
	}
}
