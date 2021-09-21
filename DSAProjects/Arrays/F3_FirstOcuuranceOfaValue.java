package Arrays;

public class F3_FirstOcuuranceOfaValue {

	//adjacent values differ by 1
	public static void main(String...strings) {
		int a[]={2,3,2,4,5,6,7};
		int val=6;
		fun(a,val);
		System.out.println();
		// here adjacent values at mostdiffer bt k.
		int b[]={70,60,70,80,90,110,130};
		int v=80;
		int maxdiff=20;
		fun2(b,v,maxdiff);
	}
	
	
	//O(n) optimised

	private static void fun2(int[] a, int val,int k) {
		int n=a.length;
		int start=0;
		while(start<n) {
			if(a[start]==val) {
				System.out.print(start);
				break;
			}
			else {
				int diff=Math.abs(a[start]-val)/k;
				// down statement is important beacuse when diff=0,we cant move further so atleast diff should be 1.
				diff=Math.max(1, diff);
				start=start+diff;
			}
		}
		
	}

	//O(n) optimised
	private static void fun(int[] a, int val) {
		int n=a.length;
		int start=0;
		while(start<n) {
			if(a[start]==val) {
				System.out.print(start);
				break;
			}
			else {
				int diff=Math.abs(a[start]-val);
				start=start+diff;
			}
		}
		
	}
}
