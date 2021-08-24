package PracticeQuestions;

public class B2_CountNumbersWithUniqueDigits {

	public static void main(String... strings) {
		int n = 2; // (0,10^4) number of numbers with unique digits.

		System.out.println(dpSol(n));
	}

	private static int dpSol(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		int nd=1;
        int s=1;
		
		
		for (int i = 1; i <= n; i++) {
			dp[i]=10*dp[i-1]+(i-1)*nd;
			nd=((int)Math.pow(10, i)-(int)Math.pow(10, i-1)-dp[i]);
            s=s+nd;
		}

		return s;
	}
}
