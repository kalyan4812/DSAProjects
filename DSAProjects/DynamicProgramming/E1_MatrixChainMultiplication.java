package DynamicProgramming;

import java.util.Arrays;

public class E1_MatrixChainMultiplication {

	public static void main(String... strings) {
		int a[] = { 10,30,5,60 };

		// since array size is 5,matrix size is 4. A1,A2,A3,A4.
		// dimension of A1 is a[0]*a[1],A2 is a[1]*a[2] and so on.
		int k = mcm(a, 1, a.length - 1);
		System.out.println(k);

		db = new int[a.length][a.length];
		for (int y[] : db) {
			Arrays.fill(y, -1);
		}

		
		int p = mcmMemozizie(a, 1, a.length - 1);
		System.out.println(p);
	}

//-------------------------------------------Top Down----------------------------------------------------
	static int db[][];
	
	private static int mcmMemozizie(int[] a, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (db[i][j] != -1) {
			return db[i][j];
		}
		int min = Integer.MAX_VALUE;
		for (int k = j-1; k <= j - 1; k++) {

			int tempans = ((db[i][k] != -1) ? db[i][k] : mcmMemozizie(a, i, k))
					+ ((db[k + 1][j] != -1) ? db[k + 1][j] : mcmMemozizie(a, k + 1, j)) + a[i - 1] * a[k] * a[j];
			min = Math.min(tempans, min);
			db[i][j] = min;
		}
		return db[i][j];
	}

	// --------------------------------------Recursive code--------------------------------------------
	
   // doubt why ,min1 should be inside in function.
	private static int mcm(int[] a, int i, int j) {
		if (i == j) {
			return 0;
		}
		int min1=Integer.MAX_VALUE;;
		for (int k = j-1; k <= j - 1; k++) {
			int tempans = mcm(a, i, k) + mcm(a, k + 1, j) + a[i - 1] * a[k] * a[j];
			min1 = Math.min(tempans, min1);
		}
		return min1;
	}

}
