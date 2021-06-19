package BinarySearch;

public class B5_MinimumDifferenceElementInSortedArray {

	// absolute differnce.
	public static void main(String... strings) {
		int a[] = { 4, 6, 10 };
		int key = 7;

		// output 6.
		int k = fun(a, key);
		System.out.println(k);
	}

	private static int fun(int[] a, int key) {
		int n = a.length;
		int l = 0, h = n - 1;
		if(key<a[l]) {
			
		}
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a[m] == key)
				return a[m];
			else if (a[m] < key) {
				
				l=m+1;
			} else {
				h=m-1;
			}
		}
		
		// to handle cases if key is outofbounds i.e <4 or >10.
		if(h<0) {
		   return a[0];	
		}
		if(l>n-1) {
			return a[n-1];
		}
		
		// now h>l;
		if(Math.abs(a[l]-key)<Math.abs(a[h]-key)) {
			return a[l];
		}
		else {
			return a[h];
		}
		
		//so at last high is pointing to floor of key,low to ciel of key.
	}
}
