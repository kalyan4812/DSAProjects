package Arrays;

public class MissingNumber {

	public static void main(String...strings) {
		int a[]= {2,4,1,3,6,7,8};
		missingNumber(a);
	}

	private static void missingNumber(int[] a) {
		int n=a.length+1;
		int actualsum=n*(n+1)/2;
		int sum=0;
		for(int k:a) {
			sum=sum+k;
		}
		System.out.print(actualsum-sum);
	}
}
