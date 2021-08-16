package BitManipulation;

public class B6_SwapAllOddAndEvenBits {

	public static void main(String...strings) {
		int a=8;
		swapBits(a);
		
		//10111011->01110111
	}

	private static void swapBits(int n) {
		// remove odd bits from number using,and preserve even bits.
		int oMask=0x55555555;
		int odds=n&oMask;
		
		
		// remove even bits from number using,and preserve odd bits.
		int eMask=0xAAAAAAAA;
		int evens=n&eMask;
		
		odds=odds<<1;
		evens=evens>>1;
		
		n=odds|evens;
		
		System.out.print(n);
		
		
	}
}
