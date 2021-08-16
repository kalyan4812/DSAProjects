package Arrays;


public class MaxLengthEvenOddSubArray {

	public static void main(String...strings) {
		int a[]= {10,12,14,7,8};
		System.out.println(getSum(a));
		System.out.println(getSumSecondWay(a));
		
	}

	

	//t(n)
	private static int getSumSecondWay(int[] a) {
		int max=0;
		int count=0;
		for(int i=0;i<a.length-1;i++) {
			if(a[i]%2==0 && a[i+1]%2!=0 || a[i]%2!=0 && a[i+1]%2==0) {
				count++;
				max=Math.max(max, count);
			}
			else {
				count=0;
			}
		}
		return max+1;
	}

	//O(n2)
	private static int getSum(int[] a) {
		int max=0;
		for(int i=0;i<a.length;i++) {
			int count=1;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]%2==0 && a[j-1]%2!=0 || a[j-1]%2==0 && a[j]%2!=0) {
					count++;
				}
				else {
					break;
				}
			}
			max=Math.max(max, count);
		}
		
		return max;
	}
}
