package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H2_PascalTriangle {

	public static void main(String[] args) {
		int n = 3;
		ArrayList<Integer> res = pascalRow(n);
		for (int val : res) {
			System.out.print(val + " ");
		}
		System.out.println();

		List<List<Integer>> al = printPascal(4);

		System.out.println(al);

		// if given row,col then value at index is row-1(C)col-1.

	}

	// O(n2),O(n2)-space.
	private static List<List<Integer>> printPascal(int r) {
		List<List<Integer>> ans = new ArrayList<>();

		List<Integer> curr = null, prev = null;

		for (int i = 0; i < r; i++) {
			curr = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					curr.add(1);
				} else {
					curr.add(prev.get(j) + prev.get(j - 1));
				}

			}
			prev = curr;
			ans.add(curr);
		}

		return ans;
	}

	// get ith row of pascal triangle.
	public static ArrayList<Integer> pascalRow(int i) { // i==3,means 4th row 1,3,3,1.
		ArrayList<Integer> al = new ArrayList<>();
		long val = 1;

		for (int j = 0; j <= i; j++) {
			al.add((int) val);

			val = val * (i - j);
			val = (val) / (j + 1);

		}

		return al;
	}

	public List<Integer> getRow(int k) {
		Integer[] arr = new Integer[k + 1];
		Arrays.fill(arr, 0);
		arr[0] = 1;

		for (int i = 1; i <= k; i++)
			for (int j = i; j > 0; j--)
				arr[j] = arr[j] + arr[j - 1];

		return Arrays.asList(arr);
	}
}
