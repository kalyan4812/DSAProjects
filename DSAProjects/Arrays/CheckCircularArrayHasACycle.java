package Arrays;

public class CheckCircularArrayHasACycle {

	public static void main(String... strings) {
		int a[] = { 2, -1, 1, 2, -1 };
		check(a, a.length);
	}

	private static void check(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			int slow = i, fast = i;
           boolean forward=a[i]>0;
           while(true) {
        	   slow=getNextStop(a,slow,forward);
        	   if(slow==-1) {
        		   break;
        	   }
        	   fast=getNextStop(a,fast,forward);
        	   if(fast==-1) {
        		   break;
        	   }
        	   fast=getNextStop(a,fast,forward);
        	   if(fast==-1) {
        		   break;
        	   }
        	   if(slow==fast) {
        		   System.out.print("true");
        		   break;
        	   }
           }
		}
		 System.out.print("false");
	}

	private static int getNextStop(int[] a, int slow, boolean forward) {
		boolean direction=a[slow]>0;
		if(direction!=forward) {
			return -1;
		}
		int nextIndex=(slow+a[slow])%a.length;
		if(nextIndex<0) {
			nextIndex=nextIndex+a.length;
		}
		if(nextIndex==slow) {
			return -1;
		}
		return nextIndex;
	}
}
