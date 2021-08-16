package Sorting;

public class MergeSort {

	// first see MergeSortedArrays Problem.
	
	public static void main(String...strings) {
		int a[]= {10,15,20,40,8,11,15,22,25};
		mergeSort(a,0,a.length-1);
		
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	private static void mergeSort(int[] a, int l, int r) {
		if(r>l) {
			int m=l+(r-l)/2;
			mergeSort(a,l,m);
			mergeSort(a,m+1,r);
			mergeFunction(a,l,m,r);
		}
		
	}

	private static void mergeFunction(int[] a, int l, int m, int r) {
		
		int left[]=new int[m-l+1];
		int right[]=new int[r-m];
		for(int i=0;i<left.length;i++) {
			left[i]=a[i+l];
		}
		
		for(int i=0;i<right.length;i++) {
			right[i]=a[i+m+1];
		}
		
		actualMerge(a,l,left,right,left.length,right.length);
		
	
		
	}

	private static void actualMerge(int[] a, int l, int [] left,int[] right, int length2, int length3) {
		int i=0,j=0;
		while(i<length2 && j<length3) {
			if(left[i]<=right[j]) {
				a[l]=left[i];
				i++;
				l++;
			}
			else {
				a[l]=right[j];
				j++;
				l++;
			}
		}
		while(i<length2) {
			a[l]=left[i];
			i++;
			l++;
		}
		while(j<length3) {
			a[l]=right[j];
			j++;
			l++;
		}
		
	}
}
