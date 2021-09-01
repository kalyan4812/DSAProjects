package BinarySearch;

public class B2_FloorAndCielOfElementInSortedArray {

	public static void main(String...strings) {
		int a[]= {3, 5, 10, 15, 17, 12, 9};
		int x=10;
		
		int k=floor(a,x);
		System.out.println(k);
		
		
		int p=ciel(a,x);
		System.out.println(p);
	}

	
	//O(logn)
	private static int ciel(int[] a, int x) {
	
		int n=a.length;
		int l=0,h=n-1;
		int ans=-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(a[m]==x) return a[m];
			else if(a[m]>x) {
				ans=a[m];
				h=m-1;
			}
			else {
				l=m+1;
			}
		}
		return ans;
	}


	//O(logn)
	private static int floor(int[] a, int x) {
		int n=a.length;
		int l=0,h=n-1;
		int ans=-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(a[m]==x) return a[m];
			else if(a[m]<x) {
				ans=a[m];
				l=m+1;
			}
			else {
				h=m-1;
			}
		}
		return ans;
	}
}
