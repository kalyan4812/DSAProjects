package Sorting;

public class B7_SegregreateTwoTypesOfElements {

	
	public static void main(String...strings) {
		int a[]= {-12,10,-10,5};
		funUsingHoarsePartition(a,a.length);
		
	}

	private static void funUsingHoarsePartition(int[] a, int n) {
		int i=-1,j=n;
		while(true) {
			do {
				i++;
			}
			while(a[i]<0);
			do {
				j--;
			}
			while(a[j]>=0);
			if(i>=j) {
				break;
			}
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		
		for(int k:a) {
			System.out.print(k+" ");
		}
	}
}
