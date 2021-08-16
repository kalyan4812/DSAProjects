package Arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class A6_PickToys {

	public static void main(String... strings) {
		String[] s = { "a", "b", "a", "c", "c", "a", "b" };
		// a, b,c reprsent type of toys.
		// you should slect contigious toys & at max two types of toys ,then maxmise
		// selection/selected toys.
		int k = 2;
		fun(s, s.length, k);
	}

	
	//O(N),O(N)-space.
	private static void fun(String[] s, int n, int k) {
		int st = 0, e = 0, max = 0;
		Map<String, Integer> m = new HashMap<>();
		int fs = 0, fe = 0;
		while (e < n) {
			m.put(s[e], m.getOrDefault(s[e], 0) + 1);
			if (m.size() == k) {

				if (e - st + 1 > max) {
					max = e - st + 1;
					fs = st;
					fe = e;
				}
			}
			while (m.size() > k) {
				m.put(s[st], m.getOrDefault(s[st], 0) - 1);
				if (m.get(s[st]) == 0) {
					m.remove(s[st]);
				}
				st++;
			}
			e++;

		}
		System.out.println(max + " from " + fs + " to " + fe);

	}
}
