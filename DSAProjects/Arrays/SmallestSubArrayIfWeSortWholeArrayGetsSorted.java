package Arrays;

public class SmallestSubArrayIfWeSortWholeArrayGetsSorted {

	public static void main(String...strings) {
		int a[]= {1,2,5,3,0,12,13,8,15,18};
		int b[]= {1,5,3};
		fun(a,a.length);
		fun(b,b.length);
	}

	
	//O(n)
	private static void fun(int[] a, int n) {
		if(n==0 || n==1) {
			System.out.println(0);
			return;
		}
		
		int start=0;
		int end=n-1;
		while(start<n-1 && a[start+1]>a[start]) {
			start++;
		}
		if(start==n-1) {
			System.out.println(0);
			return;
		}
		while(end>0 && a[end-1]<a[end] ){
			end--;
		}
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=start+1;i<end;i++) {
			min=Math.min(min, a[i]);
			max=Math.max(max, a[i]);
		}
		while(start>=0 && a[start]>min) {
			start--;
		}
		while(end<n && a[end]<max) {
			end++;
		}
		System.out.println(end-start+1);
	}
}
