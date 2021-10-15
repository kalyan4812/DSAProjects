package Sorting;

public class D1_SmallestUnsortedSubArrayWholeArrayGetsSorted {
	
	
	public static void main(String...strings) {
		
		int a[]= {2,6,4,8,10,9,15};
		
		int ans=findUnsortedSubarray(a);
		
		System.out.println(ans);  //5
		// You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
	}

	public static  int findUnsortedSubarray(int[] a) {

		int n = a.length;
		int e = -1;
		int st = 0;

		int prev = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (prev > a[i]) {
				e = i;

			} else {
				prev = a[i];
			}
		}

		int next = Integer.MAX_VALUE;

		for (int i = n - 1; i >= 0; i--) {

			if (a[i] > next) {
				st = i;

			} else {
				next = a[i];
			}
		}

		return e - st + 1;
	}
}
