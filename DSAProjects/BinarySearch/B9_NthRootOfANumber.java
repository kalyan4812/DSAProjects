package BinarySearch;

public class B9_NthRootOfANumber {

	public static void main(String...strings) {
		int n=27;
		int m=3;
		double k=fun(n,m);
		System.out.println(k);
	}

	
	//O(m*log(n*10^d)  d=decimal spaces in ans.
	private static double fun(int n, int k) {
		double l=1,h=n;
		double eps=1e-6;
		while((h-l)>eps) {
			double m=l+(h-l)/2;
			if(multiply(m,k)<n) {
				l=m;
			}
			else {
				h=m;
			}
		}
		return h;
	}

	private static double multiply(double m, int k) {
	      double ans=1.0;
	      for(int i=1;i<=k;i++) {
	    	  ans=ans*m;
	      }
		return ans;
	}
}
