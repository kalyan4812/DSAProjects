package DPProblems;

import java.util.Arrays;
import java.util.Scanner;

public class B4_Sushi {

	/*
	 * There are N dishes, numbered 1,2,…,N. Initially, for each i (1≤i≤N), Dish i
	 * has ai (1<=ai<=3) pieces of sushi on it.
	 * 
	 * Taro will perform the following operation repeatedly until all the pieces of
	 * sushi are eaten:
	 * 
	 * Roll a die that shows the numbers 1,2,…,N with equal probabilities, and let i
	 * be the outcome. If there are some pieces of sushi on Dish i, eat one of them;
	 * if there is none, do nothing. Find the expected number of times the operation
	 * is performed before all the pieces of sushi are eaten.
	 */

	// expectation=probability of that event *(number of times that event ocuured).

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int one = 0;
		int two = 0;
		int three = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x == 1) {
				one++;
			} else if (x == 2) {
				two++;
			} else {
				three++;
			}
		}
		db = new double[n + 1][n + 1][n + 1];
		for (double x[][] : db) {
			for (double y[] : x) {
				Arrays.fill(y, -1);
			}
		}

		double ans = fun(one, two, three, n);
		System.out.println(String.format("%.10f", ans));

	}

	static double db[][][];

	private static double fun(int x, int y, int z, int n) {
		if (x < 0 || y < 0 || z < 0) {
			return 0;
		}

		if (x == 0 && y == 0 && z == 0) {
			return 0;
		}
		if (db[x][y][z] > -0.9) {
			return db[x][y][z];
		}
		double exp = n + x * fun(x - 1, y, z, n) + y * fun(x + 1, y - 1, z, n) + z * fun(x, y + 1, z - 1, n);
		db[x][y][z] = exp/(x+y+z);
		return db[x][y][z];
	}

}
