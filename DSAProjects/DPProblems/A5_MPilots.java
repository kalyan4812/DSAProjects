package DPProblems;

import java.util.Scanner;

public class A5_MPilots {

	/*
	 * 
	 * Char lie acquired airline transport company and to stay in business he needs
	 * to lower the expenses by any means possible. There are N pilots working for
	 * his company (N is even) and N/2 plane crews needs to be made. A plane crew
	 * consists of two pilots - a captain and his assistant. A captain must be older
	 * than his assistant. Each pilot has a contract granting him two possible
	 * salaries - one as a captain and the other as an assistant. A captain's salary
	 * is larger than assistant's for the same pilot. However, it is possible that
	 * an assistant has larger salary than his captain. Write a program that will
	 * compute the minimal amount of money Charlie needs to give for the pilots'
	 * salaries if he decides to spend some time to make the optimal (i.e. the
	 * cheapest) arrangement of pilots in crews.
	 */

	/*
	 * The first line of input contains integer N, 2 ≤ N ≤ 10,000, N is even, the
	 * number of pilots working for the Charlie's company. The next N lines of input
	 * contain pilots' salaries. The lines are sorted by pilot's age, the salaries
	 * of the youngest pilot are given the first. Each of those N lines contains two
	 * integers separated by a space character , X i Y, 1 ≤ Y < X ≤ 100,000, a
	 * salary as a captain (X) and a salary as an assistant (Y).
	 */

	// idea:

	/*
	 * every pilot has 2 choices,if we find n/2 assistants,then after we can make
	 * n/2 pilots as capatains.
	 */

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int cap[] = new int[n];
		int ass[] = new int[n];
		/*
		 * System.out.println(n);
		 * 
		 * int i = 0;
		 * 
		 * while (n > 0) {
		 * 
		 * cap[i] = sc.nextInt(); ass[i] = sc.nextInt(); sc.nextLine();
		 * System.out.println(n+" "+cap[i]+"  "+ass[i]); i++;
		 * 
		 * n--; }
		 */

		cap[0] = 5000;
		cap[1] = 6000;
		cap[2] = 8000;
		cap[3] = 9000;

		ass[0] = 3000;
		ass[1] = 2000;
		ass[2] = 1000;
		ass[3] = 6000;

		int ans = fun(cap, ass, 0, 0, 0); // 3d dp.
		System.out.println(ans);
		
		
		int ans2=fun2(cap,ass,0,0); // 2dp. use a-c=x.
		System.out.println(ans2);
		
		
		

	}

	private static int fun2(int[] cap, int[] ass, int i, int x) {
		if (i == cap.length) {
			return 0;
		} else if (x == cap.length / 2) {
			return fun2(cap, ass, i + 1,x) + cap[i];
		} else if (x==0) {
			return fun2(cap, ass, i + 1, x+1) + ass[i];
		} else {
			return Math.min(fun2(cap, ass, i + 1,x) + cap[i], fun2(cap, ass, i + 1, x+1) + ass[i]);
		}
	}

	private static int fun(int[] cap, int[] ass, int i, int a, int c) {
		if (i == cap.length) {
			return 0;
		} else if (a == cap.length / 2) {
			return fun(cap, ass, i + 1, a, c + 1) + cap[i];
		} else if (a == c) {
			return fun(cap, ass, i + 1, a + 1, c) + ass[i];
		} else {
			return Math.min(fun(cap, ass, i + 1, a, c + 1) + cap[i], fun(cap, ass, i + 1, a + 1, c) + ass[i]);
		}

	}
}
