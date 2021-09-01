package PracticeQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C5_Projects {

	/*
	 * There are n projects you can attend. For each project, you know its starting
	 * and ending days and the amount of money you would get as reward. You can only
	 * attend one project during a day.
	 * 
	 * What is the maximum amount of money you can earn?
	 * 
	 * 
	 */

	// same problem as weighted job scheduling.
	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			jobs[i] = new Job(x, y, z);
		}

		int ans = fun(jobs, jobs.length);
		System.out.println(ans);
	}

	private static int fun(Job[] jobs, int n) {
		Arrays.sort(jobs, new MyComparator());
		int dp[] = new int[n];
		dp[0] = jobs[0].reward;

		for (int i = 1; i < n; i++) {
			int include = jobs[i].reward;
			int ind = binarySearch(jobs, i);
			if (ind != -1) {
				include = include + dp[ind];
			}
			int exclude = dp[i - 1];

			dp[i] = Math.max(include, exclude);
		}
		return dp[n - 1];
	}
	
	private static int binarySearch(Job[] jobs, int i) {
		int l = 0, h = i - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if(jobs[m].end == jobs[i].start) {
				return m;
			}
			else if (jobs[m].end < jobs[i].start) {
				if (jobs[m + 1].end < jobs[i].start) {
					l = m + 1;
				} else {
					return m;
				}
			} else {
				h = m - 1;
			}
		}
		return -1;
	}

	static class MyComparator implements Comparator<Job> {

		@Override
		public int compare(Job j1, Job j2) {

			return j1.end - j2.end;
		}

	}

	static class Job {
		int start, end, reward;

		public Job(int start, int end, int reward) {
			this.start = start;
			this.end = end;
			this.reward = reward;
		}
	}
}
