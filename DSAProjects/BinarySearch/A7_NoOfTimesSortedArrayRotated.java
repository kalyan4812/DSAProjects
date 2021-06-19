package BinarySearch;

public class A7_NoOfTimesSortedArrayRotated {

	public static void main(String...strings) {
		int a[]= {11,12,15,18,2,5,6,8};
		int k=fun(a);
		System.out.println(k);
	}

	
	//O(logn)
	private static int fun(int[] a) {
		int n=a.length;
		int l=0,h=n-1;
		while(l<=h) {
			 if(a[l] <= a[h]){
                 return Math.min(l,n-l);
             }
			int m=l+(h-l)/2;
			int next=(m+1)%n;
			int prev=(m+n-1)%n;
			if(a[m]<=a[next] && a[m]<=a[prev]) {
				return Math.min(m,n-m);
			}
			 if(a[l]<=a[m]) {
				l=m+1;
			}
			else if(a[m]<=a[h]) {
				h=m-1;
			}
		}
		return 0;
	}
}
