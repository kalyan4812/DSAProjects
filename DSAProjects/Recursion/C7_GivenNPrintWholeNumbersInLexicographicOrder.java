package Recursion;

public class C7_GivenNPrintWholeNumbersInLexicographicOrder {

	public static void main(String... strings) {

		int n = 100;

		for (int i = 1; i <= 9; i++) {
			dfs(i, n);
		}
	}

	private static void dfs(int i, int n) {
		if (i > n) {
			return;
		}

		System.out.println(i);

		for (int j = 0; j < 10; j++) {
			dfs(10 * i + j, n);
		}

	}
}
