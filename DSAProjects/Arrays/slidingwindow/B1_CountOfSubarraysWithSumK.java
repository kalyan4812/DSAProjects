package Arrays.slidingwindow;

import java.util.HashMap;

public class B1_CountOfSubarraysWithSumK {

	public static void main(String[] args) {
		int a[] = { 1, 1, 1 };
		int ans = solution(a, 2);
		System.out.println(ans);
		
		System.out.println(-12%7);
		// modulo negative number ,ignore negative sign find remainder and put negative sign to answer.
	}

	public static int solution(int[] a, int t) {

		HashMap<Integer, Integer> hm = new HashMap<>();

		int n = a.length;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (sum == t) {
				count++;
			}
			if (hm.containsKey(sum - t)) {
				count += hm.get(sum - t);
			}

			hm.put(sum, hm.getOrDefault(sum, 0) + 1);

		}

		return count;
	}
}
