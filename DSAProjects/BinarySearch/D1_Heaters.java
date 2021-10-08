package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class D1_Heaters {

	/*
	 * Winter is coming! During the contest, your first job is to design a standard
	 * heater with a fixed warm radius to warm all the houses.
	 * 
	 * Every house can be warmed, as long as the house is within the heater's warm
	 * radius range.
	 * 
	 * Given the positions of houses and heaters on a horizontal line, return the
	 * minimum radius standard of heaters so that those heaters could cover all
	 * houses.
	 */

	// idea from array one find floor ciel for every element,now calculate
	// a[i]-floor,ceil-a[i] consider min value.
	// for min radius. and after finding radius for all elements in array one take
	// max value because one heater has to cover
	// all houses.

	public static void main(String[] args) {
		// input work
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] houses = new int[n];

		for (int i = 0; i < n; i++) {
			houses[i] = scn.nextInt();
		}

		int m = scn.nextInt();
		int[] heaters = new int[m];

		for (int i = 0; i < m; i++) {
			heaters[i] = scn.nextInt();
		}

		System.out.println(findRadius(houses, heaters));
	}

	public static int findRadius(int[] a, int[] heaters) {

		Arrays.sort(heaters);
		int n = a.length;
		int dist[] = new int[n];

		for (int i = 0; i < n; i++) {

			int floor = getFloor(heaters, a[i]);
			int ceil = getCeil(heaters, a[i]);

			if (floor != -1 && ceil != -1) {
				dist[i] = Math.min(a[i] - floor, ceil - a[i]);
			} else if (floor == -1) {
				dist[i] = ceil - a[i];
			} else {
				dist[i] = a[i] - floor;
			}

		}
		int max = 0;
		for (int k : dist) {
			max = Math.max(max, k);
		}

		return max;
	}

	private static int getCeil(int[] a, int x) {

		int n = a.length;
		int l = 0, h = n - 1;
		int ans = -1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a[m] == x)
				return a[m];
			else if (a[m] > x) {
				ans = a[m];
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return ans;
	}

	// O(logn)
	private static int getFloor(int[] a, int x) {
		int n = a.length;
		int l = 0, h = n - 1;
		int ans = -1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a[m] == x)
				return a[m];
			else if (a[m] < x) {
				ans = a[m];
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return ans;
	}
}
