package Arrays;

public class G7_MaxProductOfThreeNumbers {

	public static void main(String[] args) {

		int arr[] = { 3, 2, -4, -6, 5, 1 };
		int prod = maximumProduct(arr);
		System.out.println(prod);
	}

	public static int maximumProduct(int[] a) {

		int n = a.length;
		int min1 = Integer.MAX_VALUE;
		int min2 = min1;

		int max1 = Integer.MIN_VALUE;
		int max2 = min1, max3 = max1;

		for (int i = 0; i < n; i++) {
			int x = a[i];

			// max
			if (x >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = x;
			} else if (x >= max2) {
				max3 = max2;
				max2 = x;
			} else if (x >= max3) {
				max3 = x;
			}

			// min

			if (x <= min1) {
				min2 = min1;
				min1 = x;
			} else if (x <= min2) {
				min2 = x;
			}

		}

		return Math.max(min1 * min2 * max1, max1 * max2 * max3);

	}
}
