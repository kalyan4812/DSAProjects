package PracticeQuestions;

public class D3_AssemblyLineScheduling {

	static int NUM_LINE = 2;
	static int NUM_STATION = 4;

	public static void main(String... strings) {
		int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
		int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
		int e[] = { 10, 12 }, x[] = { 18, 7 };

		int ans = fun(a, t, e, x);
		System.out.println(ans);
	}

	private static int fun(int[][] a, int[][] t, int[] e, int[] x) {

		int dp1[] = new int[4];
		int dp2[] = new int[4];
		dp1[0] = e[0] + a[0][0];
		dp2[0] = e[1] + a[1][0];

		for (int i = 1; i < 4; i++) {

			dp1[i]=Math.min(dp1[i-1]+a[0][i], dp2[i-1]+t[1][i]+a[0][i]);
			dp2[i]=Math.min(dp2[i-1]+a[1][i], dp1[i-1]+t[0][i]+a[1][i]);
		}
		
		return Math.min(dp1[3]+x[0],dp2[3]+x[1]);

	}

}
