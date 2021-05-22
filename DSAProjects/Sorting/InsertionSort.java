package Sorting;

public class InsertionSort {

	//inplace ,stable,best for smaller inputs.
	public static void main(String...strings) {
		int a[]= {50,20,40,60,10,30};
		insertionSort(a);
		
	}

	
	//O(n2) -reverse sorted array,O(n)-sorted array
	private static void insertionSort(int[] a) {
		for(int i=1;i<a.length;i++) {
			int key=a[i];
			int j;
			for( j=i-1;j>=0 && a[j]>key;j--) {
				
					a[j+1]=a[j];
				
			}
			System.out.print(j+" ");
			a[j+1]=key;
		}
		System.out.println();
		for(int i:a) {
			System.out.print(i+" ");
		}
		
	}
}
