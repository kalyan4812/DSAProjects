package Arrays;

public class G2_SubarraysWithOddSum {

	public static void main(String... strings) {

		int a[] = { 2, 3, 4, 5, 1, 4 };
		int ans = fun(a, a.length);
		System.out.println(ans);

		System.out.println(numOfSubarrays(a));
	}

	// even+even=even.
	// odd+odd=even. ---> even-odd=odd.
	// odd+even=odd. ---> odd-even=odd.

	private static int fun(int[] a, int n) {

		int prefix[] = new int[n];
		prefix[0] = a[0];
		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i - 1] + a[i];
		}

		int ans = 0;
		int odd = 0, even = 0;
		for (int i = 0; i < n; i++) {
			if ((prefix[i] & 1) == 0) {
				even++;
				ans = ans + odd;

			} else {
				odd++;
				ans = ans + even + 1;

			}
		}
		return ans;
	}

	// or use total subarrays -even subarrays.

	static int mod = 1000000000 + 7;

	public static int numOfSubarrays(int[] a) {
		int n = a.length;

		int pref[] = new int[n];
		pref[0] = a[0];

		for (int i = 1; i < n; i++) {
			pref[i] = a[i] + pref[i - 1];
		}

		long ans = 0;
		long odd = 0, even = 0;

		for (int i = 0; i < n; i++) {

			if ((pref[i] & 1) == 0) {
				even++;
				ans += even;
			}

			else {
				odd++;

				ans += odd - 1;
			}

			ans = ans % mod;

		}
		

		double k = n * 0.5; // total subarrays -n*(n+1)/2.
		k = k * (n + 1);

		ans = (long) k - ans; // total -even subarrys.
		ans = ans % mod;
		return (int) ans;
	}
}
