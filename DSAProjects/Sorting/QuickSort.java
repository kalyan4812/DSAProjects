package Sorting;

public class QuickSort {

	public static void main(String...strings) {
		int [] a= {8,4,7,9,3,10,5};
		quickSortUsingLaumutoPartition(a,0,a.length-1);
		for(int k:a) {
			System.out.print(k+" ");
		}
		
		System.out.println();
		quickSortUsingHoarsePartition(a,0,a.length-1);
		for(int k:a) {
			System.out.print(k+" ");
		}
	}

	// 3 times fatser than laumoto partition 
	private static void quickSortUsingHoarsePartition(int[] a, int l, int h) {
		if(l<h) {
			int pivot=hoaresPartition(a,l,h);
			quickSortUsingLaumutoPartition(a,l,pivot);
			quickSortUsingLaumutoPartition(a,pivot+1,h);
		}
		
	}
	private static int hoaresPartition(int[] a, int l, int r) {
		int pivot=a[l];
		int i=l-1;
		int j=r+1;
		
		while(true) {
			do {
				i++;
			}
			while(a[i]<pivot);
				do {
					j--;
				}
				while(a[j]>pivot);
				
				if(i>=j) {
					break;
				}
				else {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
				
		}
		return i;
		
	}
	
	
	private static void quickSortUsingLaumutoPartition(int[] a, int l, int h) {
		if(l<h) {
			int pivot=laumutoPartition(a,l,h);
			quickSortUsingLaumutoPartition(a,l,pivot-1);
			quickSortUsingLaumutoPartition(a,pivot+1,h);
		}
		
	}

	private static int laumutoPartition(int[] a, int l, int h) {
		int i=l-1;
		for(int j=l;j<=h-1;j++) {
			if(a[j]<a[h]) {
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp=a[i+1];
		a[i+1]=a[h];
		a[h]=temp;
		return i+1;
	}
}
