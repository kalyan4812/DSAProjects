package BitManipulation;

public class B4_MinimumFlipsToMakeAtoB {

	public static void main(String...strings) {
		
		int a=5;
		int b=6;
		
		flips(a,b);
		
	}

	private static void flips(int a, int b) {
	
		int k=a^b; // flipped bits.
		int csb=getCsb(k);
		System.out.println(csb);
	}
	
	private static int getCsb(int n) {
		int res=0;
		while(n>0) {
			n=(n&(n-1));// remove last set bit.
			res++;
		}
		return res;
	}
}
