package BasicQuestions;

import java.util.Scanner;

public class A6_NumberSystem {

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int base = sc.nextInt();

		decimalToBase(n, base);

		System.out.println(Integer.toString(n, base)); // direct way.

		int basenum = sc.nextInt();
		
		baseToDecimal(basenum,base);
		System.out.println(Integer.valueOf(String.valueOf(basenum), base));// direct way
		
		
		
		additionInBase(1212,256,base);

	}

	private static void additionInBase(int a, int b, int base) {
				
		int res=0;
		int p=1;
		int c=0;
		while(a>0 || b>0 || c>0) {
			int d1=a%10;
			int d2=b%10;
			
			a=a/10;
			b=b/10;
			
			int d=d1+d2+c;
			c=d/base;
			d=d%base;
			
			res+=d*p;
			p=p*10;
			
		}
		System.out.println(res);
	}

	private static void baseToDecimal(int n, int base) {
		int res = 0;

		int pow = 1;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			res += d * pow;
			pow = pow * base; 
		}
		System.out.println(res);
	}

	private static void decimalToBase(int n, int base) {

		int res = 0;

		int pow = 1;
		while (n > 0) {
			int d = n % base;
			n = n / base;
			res += d * pow;
			pow = pow * 10;
		}
		System.out.println(res);
	}
}
