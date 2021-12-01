package Samples;

public class A8_KthDigit {

	public static void main(String... strings) {
		// sequence - 12345678910111213...
		long n = 15;

		long ans = fun(n);
		System.out.println(ans);

	}

	private static long fun(long n) {
		long base = 9, digits = 1;
		while (n - base * digits > 0) {
			n -= base * digits;
			base *= 10;
			digits++;
		}
		long index = n % digits;
		
		if (index == 0)
			index = digits;
		
		long num = 1;
		
		for (int i = 1; i < digits; i++)
			num *= 10;
		
		num += (index == digits) ? n / digits - 1 : n / digits;
	
		for (long i = index; i < digits; i++)
			num /= 10;
		return num % 10;
	}
}
