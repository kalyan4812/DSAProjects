package Arrays;


public class A5_SecondLargest {

	public static void main(String...strings) {
		int[] a= {1,12,3,-22,12,5,0,9};
		System.out.println("second max value :"+getSecondLargest(a));
		
		System.out.print("second max value :"+getSecMaxInOneTraversal(a));
	}

	private static int getSecondLargest(int[] a) {
		int max=getMax(a);
		System.out.println("max value :"+max);
		int secmax=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]>secmax) {
				if(a[i]!=max) {
					secmax=a[i];
				}
			}
		}
		return secmax;
	
	}

	private static int getMax(int[] a) {
		int max=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
		}
		return max;
	}
	
	
	
	//time complexity O(n) but two traversals
	// or sort the array(nlogn) and get secmax.
	// other approach would be getmax,deletemax,getmax.
	
	
	private static int getSecMaxInOneTraversal(int [] a) {
		int secmax=a[0];
		int max=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				secmax=max;
				max=a[i];
			}
			else {
				if(a[i]!=max && a[i]>secmax) {
					secmax=a[i];
				}
			}
		}
		return secmax;
	}
	
}
