package Arrays.slidingwindow;

public class A8_FindAverageOfSubArraysOfSizeK {

	public static void main(String... strings) {
		int a[] = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		int k = 5;
		fun(a, a.length, 5);
		// 2.2, 2.8, 2.4, 3.6, 2.8
	}


	// O(N)
	private static void fun(int[] a, int n, int k) {
		int s = 0, e = 0;
		float avg[] = new float[n - k + 1];
		float sum = 0;
		while (e < n) {
			sum = sum + a[e];
			if (e - s + 1 == k) {
				avg[s] = sum / k;
				sum = sum - a[s];
				s++;
			}
			e++;

		}
		for (float p : avg) {
			System.out.print(p + " ");
		}
	}
}
