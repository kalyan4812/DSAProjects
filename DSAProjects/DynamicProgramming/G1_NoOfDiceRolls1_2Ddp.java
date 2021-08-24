package DynamicProgramming;

public class G1_NoOfDiceRolls1_2Ddp {
	public static void main(String... strings) {
		int target = 4;
		int dicerolls = 3;
		// range of dice :1,2,3
		// find no of ways we can get 3.

		System.out.println(recursiveSol(target, dicerolls));

		System.out.println(dpSol(target, dicerolls));
	}

	private static int dpSol(int t, int d) {
		int dp[][] = new int[t + 1][d + 1];
		
		for (int i = 0; i <= t; i++) {
			for (int j = 0; j <= d; j++) {
                if(i==0 && j==0) {
                	dp[i][j] = 1;
                }
                else if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		for (int i = 1; i <= t; i++) {
			for (int j = 1; j <= d; j++) {

				for (int k = 1; k <= 3; k++) {

					if (i >= k) {
						dp[i][j] = dp[i][j] + dp[i - k][j - 1];
					}
				}
			}
		}

		return dp[t][d];
	}

	private static int recursiveSol(int t, int d) {
		if (t < 0 || d < 0) {
			return 0;
		}
		if (t == 0 && d == 0) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= 3; i++) {
			ans += recursiveSol(t - i, d - 1);
		}
		return ans;
	}
}
