package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class A4_MaxMeetingInRoom {

	public static void main(String... strings) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };

		System.out.println(maxMeetings(start, end));
	}

	public static int maxMeetings(int s[], int e[])

	{
		int a[][] = new int[s.length][2];
		for (int i = 0; i < s.length; i++) {
			a[i][0] = s[i];
			a[i][1] = e[i];
		}

		int ans = 0;

		Arrays.sort(a, (c, d) -> (c[1] != d[1]) ? (c[1] - d[1]) : 0); // sort based on end time.

		ArrayList<int[]> al = new ArrayList<>();

		for (int k[] : a) {

			if (al.size() == 0) {
				al.add(k);
				ans++;
			} else {
				int prev[] = al.get(al.size() - 1);

				if (prev[1] < k[0]) {

					prev[1] = k[1];

					ans++;
					al.add(k);
				}
			}

		}
		for (int k[] : al) {
			System.out.println(k[0]);
		}
		return ans;
	}
}
