package PracticeQuestions;

public class D6_CountDearrangements {

	// A Derangement is a permutation of n elements, such that no element appears in
	// its original position.

	public static void main(String... strings) {

		int n = 4;
		int ans = fun(n);
		System.out.print(ans);
	}

	private static int fun(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		return (n - 1) * (fun(n - 2) + fun(n - 1));
	}

}
