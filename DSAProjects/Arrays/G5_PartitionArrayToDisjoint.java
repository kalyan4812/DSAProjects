package Arrays;

import java.util.Scanner;

public class G5_PartitionArrayToDisjoint {

	/*
	 * 1. Given an integer array nums.
	 *  2. Partition it into two (contiguous)
	 * subarrays left and right so that: a. Every element in left is less than or
	 * equal to every element in right. b. Left and right are non-empty. c. Left has
	 * the smallest possible size.
	 *  3. Return the length of left after such a
	 * partitioning.
	 */

	public static void main(String[] args) {
		int arr[] = { 5, 0, 3, 8, 6 };

		int len = partitionDisjoint(arr);
		System.out.println(len);
	}

	public static int partitionDisjoint(int[] a) {

		int leftmax = a[0];
		int greater = a[0];
		int ans = 0;

		for (int i = 1; i < a.length; i++) {
			if (a[i] > greater) {
				greater = a[i];
			} else if (a[i] < leftmax) {
				leftmax = greater;
				ans = i;
			}
		}
		return ans + 1;
	}

}
