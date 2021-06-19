package BinarySearch;

public class B7_SearchInRowWiseAndColumnWiseSortedArray {

	public static void main(String... strings) {
		int a[][] = { { 10, 20, 30, 40 }, { 15, 25, 25, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		int key = 29;
		int k = fun(a, key);
		System.out.println(k);
	}

	// O(n+m)
	private static int fun(int[][] a, int key) {
		int n = a.length;
		int m = a[0].length;
		int i = 0, j = m - 1;
		while (i >= 0 && i < n && j >= 0 && j < m) {
			if (a[i][j] == key) {
				String s = i + "" + j;
				return Integer.parseInt(s);
			} else if (a[i][j] > key) {
				j--;
			} else if (a[i][j] < key) {
				i++;
			}
		}
		return -1;
	}
}
