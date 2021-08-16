package BitManipulation;

public class B7_CountSetBitsIn1ToN {

	public static void main(String...strings) {
		int n=11;
		System.out.print(count(n));
	}

	private static int count(int n) {
	   if(n==0) {
		   return 0;
	   }
		
		int x=largestPowerOfTwo(n);
		
		int a=(1<<(x-1))*x; // bits upto 2^x
		int b=n-(1<<x)+1; // b/w 2^x to n;
		
		int c=n-(1<<x);// rest
		
		return a+b+count(c);
		
		
	}

	private static int largestPowerOfTwo(int n) {
		int res=1;
		while((1<<res)<=n) {
			res++;
		}
		return res-1;
	}
}
