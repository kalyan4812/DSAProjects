package BinarySearch;

public class B3_NextAlphabeticalElement {

	public static void main(String...strings) {
		char c[]= {'a','e','f','h'};
		char k='f';
		// output should be h.
		char p=fun(c,k);
		System.out.println(p);
	}

	//O(logn)
	private static char fun(char[] c, char k) {
		int n=c.length;
		int l=0,h=n-1;
		char ans=0;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(c[m]==k) {
				l=m+1;
			}
			else if(c[m]>k) {
				ans=c[m];
				h=m-1;
			}
			else {
				l=m+1;
			}
			
		}
		return ans;
	}
}
