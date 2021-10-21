package Arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class A9_CountSubstringsWithAtmostKUniqueCharcaters {
	public static void main(String[] args) {

		String str = "aabcbcdbca";
		int k = 2;

		// atmost k unquie characters.
		System.out.println(solution(str, k));

		// idea for exactly k unquie characters is solution(k)-solution(k-1);
		int ans = solution(str, k) - solution(str, k - 1);
		System.out.println(ans);
	}

	public static int solution(String s, int k) {
		Map<Character, Integer> h = new HashMap<>();
		int count = 0, st = 0, e = 0;
		int n = s.length();
		while (e < n) {
			char c = s.charAt(e);
			h.put(c, h.getOrDefault(c, 0) + 1);

			while (h.size() > k) {
				char front = s.charAt(st);
				h.put(front, h.getOrDefault(front, 0) - 1);

				if (h.get(front) == 0) {
					h.remove(front);
				}
				st++;

			}

			count += e - st + 1;

			e++;
		}

		return count;
	}
}
