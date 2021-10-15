package BasicQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A2_CheckPrime {

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		boolean ans = fun1(n);
		System.out.println(ans);

		boolean ans2 = fun2(n);
		System.out.println(ans2);

		// print prime till n.

		sieve(n);

		// print all divisors of n!.

		divisorOfFactorial(n);

		// print prime between a and b
		segmentedSieveAlgo(2, 100); // used incase if b<=10^9 ,in that cases you can't use direct sieve algo.

	}

	// O(nlog(log(n)).
	public static void segmentedSieveAlgo(int a, int b) {

		int rootb = (int) Math.sqrt(b);
		boolean bool[] = new boolean[b - a + 1]; // false-prime.

		ArrayList<Integer> al = new ArrayList<>();
		sieve(rootb, al);

		// System.out.println(al);

		for (int k : al) {
			// starting index for marking prime.

			int multiple = (int) Math.ceil((a * 1.0) / k);

			if (multiple == 1) {
				multiple++;
			}

			int indx = multiple * k - a;

			for (int j = indx; j < bool.length; j += k) {
				bool[j] = true;
			}

		}

		for (int i = 0; i < bool.length; i++) {
			if (!bool[i] && i + a > 1) {
				System.out.println(i + a);
			}
		}

	}

	private static void sieve(int n, ArrayList<Integer> al) {
		boolean isPrime[] = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i <= n; i++) {

			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		// 1 is not prime.
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				// System.out.print(i+" ");
				al.add(i);
			}
		}
	}

	private static void divisorOfFactorial(int n) {
		int res = 1;
		System.out.println(al.toString());
		for (int i = 0; i < al.size() && al.get(i) <= n; i++) {
			int k = al.get(i);
			int count = 0;
			while (n / k != 0) {
				count = count + n / k;
				k = k * al.get(i);
			}
			res = res * (count + 1);
		}
		System.out.println(res);
	}

	static ArrayList<Integer> al = new ArrayList<>();

	// O(nloglogn).
	// time complexity- n/2+n/3+n/4+.......n/n^1/2.
	// take n common,(1/2+1/3+...1/n^1/2),through converegnce divergence sum of
	// prime numbers fraction is log(log(n)).
	// so tc is n*log(log(n)).

	private static void sieve(int n) {
		boolean isPrime[] = new boolean[10000];
		Arrays.fill(isPrime, true);

		for (int i = 2; i * i <= n; i++) {

			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		// 1 is not prime.
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				System.out.print(i + "  ");
				al.add(i);
			}
		}
	}

	// O(n^1/2).
	private static boolean fun2(int n) {
		int count = 0;

		for (int i = 2; i * i <= n; i++) { // neglect 1.,why root n because p*q=n,both p and q (factors) should be less
											// than equal
											// to root n.
			if (n % i == 0) {
				count++;
				break;
			}
		}
		if (count == 0) { // no divisor then prime.
			return true;
		}
		return false;

	}

	// O(N)
	private static boolean fun1(int n) {

		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			return true;
		}
		return false;
	}
}
