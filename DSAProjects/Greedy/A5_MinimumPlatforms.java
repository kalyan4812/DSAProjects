package Greedy;

import java.util.Arrays;

public class A5_MinimumPlatforms {

	public static void main(String... strings) {
		int start[] = { 120, 50, 550, 200, 700, 850 };
		int end[] = { 600, 550, 700, 500, 900, 1000 };

		int k = minPlatforms(start, end, start.length);
		System.out.println(k);

	}

	// O(2nlogn)+O(2n)
	private static int minPlatforms(int[] start, int[] end, int n) {

		Arrays.sort(start);
		Arrays.sort(end);

		int platform = 1, maxplat = 1;
		int i = 1, j = 0;
		while (i < n && j < n) {

			if (start[i] <= end[j]) {
				platform++;
				i++;
			} else if (start[i] > end[j]) {
				platform--;
				j++;
			}
			maxplat = Math.max(maxplat, platform);
		}

		return maxplat;
	}
}
