package BinarySearch;

public class B1_SearchingInNearlySortedArray {

	public static void main(String...strings) {
		int a[]= {5,10,30,20,40};
		int x=20;
		int k=fun(a,x);
		System.out.println(k);
	}
	
	
	//O(logn)

	private static int fun(int[] a,int x) {
		int n=a.length;
		int l=0,h=n-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(a[m]==x) return m;
			if(m-1>=l && a[m-1]==x) return m-1;
			if(m+1<=h && a[m+1]==x) return m+1;
			
			if(x<a[m]) {
				h=m-2;
			}
			else {
				l=m+2;
			}
		}
		
		return -1;
	}
}
