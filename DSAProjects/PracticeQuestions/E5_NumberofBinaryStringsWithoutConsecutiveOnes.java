package PracticeQuestions;

public class E5_NumberofBinaryStringsWithoutConsecutiveOnes {

	// from 0 to n, find numbers whose binary won't contain consecutive ones.

	public static void main(String... strings) {
		int n = 5;

		int ans = fun(n);
		System.out.println(ans);

	}

	private static int fun(int n) {
         count=2;
		 helper(1, 1, n);
		 
		 return count;
	}

	static int count = 2;

	private static void helper(int curr, int prev, int n) {

		if (prev == 0 && curr * 2 + 1 <= n) {
			helper(curr * 2 + 1, 1, n);
			count++;

		}

		if (curr * 2 <= n) {

			helper(curr * 2, 0, n);
			count++;
		}

	}

}
