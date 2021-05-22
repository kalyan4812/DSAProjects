package Arrays;


public class MaxSumOfKConsecutiveElements {

	//max subarray of given size k.
	public static void main(String...strings) {
		int a[]= {5,-10,6,90,3};
		int k=2;
		printSum(a,k);
		printSumByWindowMethod(a,k);
	}

	
	//O(n) window sliding technique
	private static void printSumByWindowMethod(int[] a, int k) {
		int sum=0;
		for(int i=0;i<k;i++) {
			sum=sum+a[i];
		}
		int maxsum=sum;
		for(int i=k;i<a.length;i++) {
			sum=sum+a[i]-a[i-k];
			if(sum>maxsum) {
				maxsum=sum;
			}
		}
		System.out.print(maxsum);
		
	}


	//O(n-k+1*k-1) if k=n/2 then it will be O(n2)
	private static void printSum(int[] a,int k) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length-k+1;i++) {
			int sum=a[i];
			for(int j=i+1;j<i+k;j++) {
				sum=sum+a[j];
				max=Math.max(max, sum);
			}
		}
	System.out.println(max);	
	}
}
