package PracticeQuestions;

public class E4_ConsecutiveNumbersSum {

	// number of ways you can write n as the sum of consecutive positive integers.
	public static void main(String[] args) {

		int num = 15;
		int res = consecutiveNumbersSum(num);
		System.out.println(res);
	}

	public static int consecutiveNumbersSum(int n) {

		int count = 0;
		int k = 1;
		while (2 * n > k * (k - 1)) {

			int numerator = n - (k * (k - 1)) / 2;
			if (numerator % k == 0) { // shoule be a integer.
				count++;
			}

			k++;

		}
		return count;

	}
}
