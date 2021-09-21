package Arrays;


public class D1_EquilibriumPoint {

	//left sum and right sum are equal.
	public static void main(String...strings) {
		int a[]= {3,4,8,-9,20,6};
		printPoint(a);
		printPointByPrefixSuffixMethod(a);
		printPointByPrefixMethod(a);
	}

	
	//O(n),t(n)-space
	private static void printPointByPrefixSuffixMethod(int[] a) {
		int [] prefixsum=new int[a.length];
		prefixsum[0]=a[0];
		for(int i=1;i<a.length;i++) {
			prefixsum[i]=a[i]+prefixsum[i-1];
		}
		
		int [] suffixsum=new int[a.length];
		suffixsum[a.length-1]=a[a.length-1];
		for(int i=a.length-2;i>=0;i--) {
			suffixsum[i]=a[i]+suffixsum[i+1];
		}
		
		if(prefixsum[a.length-2]==0) {
			System.out.println(a[a.length-1]);
		}
		if(suffixsum[1]==0) {
			System.out.println(a[0]);
		}
		for(int i=1;i<a.length-1;i++) {
			if(prefixsum[i-1]==suffixsum[i+1]) {
				System.out.println(a[i]);
			}
		}
		
		
		
	}


	//O(n) 
	private static void printPointByPrefixMethod(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
		}
		int leftsum=0;
		for(int i=0;i<a.length;i++) {
			if(leftsum==sum-a[i]) {
				System.out.print(a[i]);
				return;
			}
			leftsum=leftsum+a[i];
			sum=sum-a[i];
		}
		
	}

	//O(n2)
	private static void printPoint(int[] a) {
		for(int i=0;i<a.length;i++) {
			int lsum=0,rsum=0;
			for(int j=0;j<i;j++) {
				lsum=lsum+a[j];
			}
			for(int k=i+1;k<a.length;k++) {
				rsum=rsum+a[k];
			}
			if(lsum==rsum) {
				System.out.println(a[i]+" ");
			}
		}
		
	}
}
