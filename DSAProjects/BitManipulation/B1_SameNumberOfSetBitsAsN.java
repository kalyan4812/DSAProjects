package BitManipulation;

public class B1_SameNumberOfSetBitsAsN {

	// find number smaller than n ,which has same number of set bits as n.
	public static void main(String...strings) {
	int n=12;
	find(12);
	}

	private static void find(int n) {
	  int csb=getCsb(n);
	  
	  long ans=getAns(n,csb,63);
	  
	  System.out.println(ans);
	  
	}

	private static long getAns(long n, int csb, int k) {
		if(k==0) {
			return 0;
		}
		long mask=1L<<k;
		long res=0;
		if((n&mask)==0) { // bit is not set.
			res=getAns(n,csb,k-1);
		}
		else {
			long res1=getAns(n,csb-1,k-1);
			long res0=ncr(k,csb);
			res=res1+res0;
		}
		return res;
	}

	private static long ncr(int n, int r) {
		if(n<r) {
			return 0;
		}
		long res=1L;
		for(long i=0L;i<r;i++) {
			res=res*(n-i);
			res=res/(i+1);
		}
		return res;
		
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
