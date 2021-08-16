package BinarySearch;

public class A5_CountOnesInSortedBinaryArray {

	public static void main(String...strings) {
		int a[]= {0,0,0,1,1,1,1};
		int k=fun(a);
		System.out.print(k);
	}

	//O(logn)
	private static int fun(int[] a) {
		int n=a.length-1;
		int fo=firstOccurance(a,1);
		if(fo==-1) {
			return 0;
		}
		else {
			return n-fo+1;
		}
	}
	//O(logn)
			private static int firstOccurance(int[] a, int ele) {
				int n=a.length;
				int l=0,h=n-1;
				while(l<=h) {
					int m=l+(h-l)/2;  // to avoid overflow of int size.
					if(a[m]==ele) {
						if(m!=0 && a[m-1]==a[m]) {
							h=m-1;
						}
						else {
							return m;
						}
					}
					else if(ele<a[m]) {
						h=m-1;
					}
					else {
						l=m+1;
					}
				}
				return -1;
			}
}
