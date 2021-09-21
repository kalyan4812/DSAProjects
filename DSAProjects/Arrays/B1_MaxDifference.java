package Arrays;


public class B1_MaxDifference {

	public static void main(String...strings) {
		int a[]= {2,3,10,6,4,8,1};
		printMaxDifference(a);
		
		System.out.println();
		printMaxOtherWay(a);
	}

	
	//t(n)
	private static void printMaxOtherWay(int[] a) {
		int min=a[0];
		int max=a[1]-a[0];
		
		for(int i=1;i<a.length;i++) {
			
			if(a[i]-min>max) {
				max=a[i]-min;
			}
			if(a[i]<min) {
				min=a[i];
	
			}
			
		}
		System.out.print(max);
	}

	//t(n2)
	private static void printMaxDifference(int[] a) {
		int maxdiff=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			
			for(int j=i+1;j<a.length;j++) {
				maxdiff=Math.max(maxdiff, a[j]-a[i]);
			}
		}
		System.out.print(maxdiff);
		
	}
}
