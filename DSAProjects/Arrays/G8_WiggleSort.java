package Arrays;

import java.util.Arrays;

public class G8_WiggleSort {

	// nums[0] < nums[1] > nums[2] < nums[3]....

	public static void main(String... strings) {

		int a[] = { 1, 5, 1, 1, 6, 4 };
		wiggleSort(a);
	}

	public static void wiggleSort(int[] a) {

		int n = a.length;

		Arrays.sort(a);

		int res[] = new int[n];

		int i = 1, j = n - 1;

		while (i < n) {
			res[i] = a[j];
			i += 2;
			j--;

		}

		i = 0;
		while (i < n) {
			res[i] = a[j];
			i += 2;
			j--;
		}

		for (int j1 = 0; j1 < n; j1++) {
			a[j1] = res[j1];
			System.out.print(a[j1] + " ");
		}
	}
}
