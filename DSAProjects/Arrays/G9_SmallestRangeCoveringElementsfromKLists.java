package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G9_SmallestRangeCoveringElementsfromKLists {

	/*
	 * You have k lists of sorted integers in non-decreasing order. Find the
	 * smallest range that includes at least one number from each of the k lists.
	 * 
	 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a
	 * < c if b - a == d - c.
	 */

	public static void main(String... strings) {

		List<List<Integer>> l = new ArrayList<>();
		l.add(Arrays.asList(4, 10, 15, 24, 26));
		l.add(Arrays.asList(0, 9, 12, 20));
		l.add(Arrays.asList(5, 18, 22, 30));

		int ans[] = smallestRange(l);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] smallestRange(List<List<Integer>> nums) {
		int res[] = { -100000, 100000 };
		int n = nums.size();
		int max = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

		for (int i = 0; i < n; i++) {

			int min = nums.get(i).get(0);
			int[] x = { min, 0, i };
			max = Math.max(max, min);
			pq.add(x);

		}

		while (true) {
			int min[] = pq.poll();
			if (res[1] - res[0] > max - min[0]) {
				res[0] = min[0];
				res[1] = max;
			}
			min[1]++;
			List<Integer> cl = nums.get(min[2]);
			if (min[1] == cl.size()) {
				break;
			} else {
				min[0] = cl.get(min[1]);
				max = Math.max(max, min[0]);
				pq.add(min);
			}

		}

		return res;
	}
}
