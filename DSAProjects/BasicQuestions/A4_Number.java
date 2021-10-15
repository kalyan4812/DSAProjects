package BasicQuestions;

public class A4_Number {

	public static void main(String...strings) {
		
		countDigitsOfNumber(1234);
		
		printDigits(6789);
		
		reverseOfNumber(1234);
		
		primeFactorization(120);
	}

	private static void primeFactorization(int n) {
		for(int div=2;div*div<=n;div++) {
			while(n%div==0) {
				n=n/div;
				System.out.print(div+" ");
			}
		}
		if(n!=1) {
			System.out.println(n);
		}
	}

	private static void reverseOfNumber(int n) {
	  
		while(n>0) {
			
			int p=n%10;
			System.out.print(p+" ");
			n=n/10;
		
		}
		System.out.println();
		
	}

	private static void printDigits(int n) {
		
		int k=countDigitsOfNumber(n);
		
		int pow=(int)Math.pow(10, k-1);
		
		while(pow>0) {
			int p=n/pow;
			System.out.print(p+" ");
			n=n%pow;
			pow=pow/10;
		}
		System.out.println();
	}

	private static int countDigitsOfNumber(int n) {
	
		int c=0;
		
		while(n>0) {
			n=n/10;
			c++;
		}
		
		System.out.println(c);
		return c;
	}
}
