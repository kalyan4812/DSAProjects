package Sorting;

public class PartitionAroundRange {

	public static void main(String...strings) {
		int [] a= {10,5,6,3,20,9,40};
		int [] range= {5,10};
		funUsingDutchNationalAlgorithm(a,range,a.length);
	}

	//O(n)
	private static void funUsingDutchNationalAlgorithm(int[] a, int[] r, int n) {
		int l=0,h=n-1,mid=0;
		while(mid<=h) {
			if(a[mid]<r[0]) {
				int temp=a[l];
				a[l]=a[mid];
				a[mid]=temp;
				l++;
				mid++;
			}
			else if(a[mid]<=r[1] && a[mid]>=r[0]) {
				mid++;
				
			}
			else {
				int temp=a[mid];
				a[mid]=a[h];
				a[h]=temp;
				h--;
			}
		}
		for(int k:a) {
			System.out.print(k+" ");
		}
		
	}
}
