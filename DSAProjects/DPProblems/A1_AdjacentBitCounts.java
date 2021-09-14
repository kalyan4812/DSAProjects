package DPProblems;

public class A1_AdjacentBitCounts {

	/*For a string of n bits x1,x2,x3,..., the adjacent bit count of the string (AdjBC(x)) is given by


	X1*X2 + X2*X3 + X3*X4 + ... + Xn-1 * Xn


	which counts the number of times a 1 bit is adjacent to another 1 bit. For example:
	AdjBC(011101101) = 3
	AdjBC(111101101) = 4
	AdjBC(010101010) = 0

	Write a program which takes as input integers n and k and returns the number of bit strings x of n bits (out of 2ⁿ) 
	that satisfy AdjBC(x) = k. For example, for 5 bit strings, there are 6 ways of getting AdjBC(x) = 2:
	11100, 01110, 00111, 10111, 11101, 11011*/
	
	public static void main(String...strings) {
		
		int n=5;
		int k=2;
		
		int ans=fun(n,k,0)+fun(n,k,1); // strings starting with 0 and 1.
		System.out.println(ans);
	}

	private static int fun(int n, int k, int f) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			if(k==0) {
				return 1;
			}
			return 0;
		}
		
		int rem=-1;
		if(f==0) {
			rem=fun(n-1,k,0)+fun(n-1,k,1);
		}
		else {
			rem=fun(n-1,k,0)+fun(n-1,k-1,1);
		}
		return rem;
	}
}
