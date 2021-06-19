package BinarySearch;

public class A8_FindPeakElement {

	
	//BinarySearchOnAnswer : concept of applying binary search on unsorted array.
	// criteria for ignoring half parts is based on answer.
	
	
	// Not smaller than neighbour.
	public static void main(String...strings) {
		int a[]= {10,20,15,5,23,90,67};
		

		int s=fun2(a);
		System.out.println(s);
	
		int k=fun(a);
		System.out.println(k);
	}
	
	

	//O(n)
	private static int fun2(int[] a) {
		int n=a.length;
		if(n==1) return a[0];
		if(a[0]>=a[1]) return a[0];
		if(a[n-1]>=a[n-2]) return a[n-1];
		
		for(int i=1;i<n-1;i++) {
			if(a[i]>=a[i-1] && a[i]>=a[i+1] ) {
				return a[i];
			}
		}
		return -1;
	}

	
	//O(logn)
	private static int fun(int[] a) {
		int n=a.length;
		int l=0,h=n-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if((m==0 || a[m-1]<=a[m]) && (m==n-1 || a[m+1]<=a[m])) {
				return a[m];
			}
			else if(m>=0 && a[m-1]>=a[m]) {
				h=m-1;
			}
			else {
				l=m+1;
			}
		}
		return -1;
	}
}
