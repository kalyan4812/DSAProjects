package Sorting;

public class RemoveDuplicateElementFromSortedArray {

	public static void main(String...strings) {
		int [] a= {1,4,4,4,5,6,7,7,8};
		upadte(a,a.length);
	}

	//O(n)
	private static void upadte(int[] a, int n) {
		
		int s=1;
		for(int i=1;i<n;i++) {
			if(a[i]!=a[i-1]) {
				a[s]=a[i];
				s++;
			}
		}
		for(int i=0;i<s;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
