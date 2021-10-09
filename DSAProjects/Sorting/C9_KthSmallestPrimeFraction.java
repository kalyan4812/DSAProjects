package Sorting;

public class C9_KthSmallestPrimeFraction {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 5 };

		int ans[] = kthSmallestPrimeFraction(a, 3);
		System.out.print(ans[0] + "  " + ans[1]); // forms smallest fraction.

	}

	public static int[] kthSmallestPrimeFraction(int[] a, int k) {
		int n = a.length;

		double l = a[0] * 1.0 / a[n - 1];
		double r = 1;

		while (l <= r) {

			double m = l + (r - l) / 2;

			int count[] = fun(a, m);

			if (k < count[0]) {
				r = m;
			} else if (k > count[0]) {
				l = m;
			} else {
				return new int[] { count[1], count[2] };
			}
		}
		return null;
	}

	public static int[] fun(int a[], double t) {

		int count = 0;
		int n = a.length;
		int i = 0, num = a[0], den = a[n - 1];

		for (int j = 1; j < n; j++) {

			while (a[i] <= t * a[j]) {
				i++;
			}
			count += i;

			if (i - 1 >= 0 && a[i - 1] * den > a[j] * num) {
				num = a[i - 1];
				den = a[j];
			}
		}

		return new int[] { count, num, den };

	}
	/*	Aashish Raika 5-Yr IDD Civil Engg., IIT (BHU) Varanasi4:28 PM
	Placement 2022:
	View mode: https://bit.ly/3uezBCn
	Edit mode: https://bit.ly/3ueH9os
	Internship 2022: https://bit.ly/2VJaHOd
	If anyone faces any access issues, please let me know.

	Company Grievance Doc: http://bit.ly/2YSumvv
	Below are the docs from previous placement sessions
	2021: 
	https://bit.ly/3ff7ji4
	https://bit.ly/3hTDCVl (Edit mode)
	2020:
	Coding:
	http://bit.ly/33OwO4j
	http://bit.ly/2LRQO0T
	Interview: 
	https://bit.ly/2BNlY6r
	Internship 2020: http://bit.ly/39TMM0P
	Placement 2019: https://go
	*/
}
