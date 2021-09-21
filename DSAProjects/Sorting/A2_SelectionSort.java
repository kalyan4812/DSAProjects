package Sorting;

public class A2_SelectionSort {

	public static void main(String...strings) {
		int a[]= {10,5,8,20,2,18};
		selectionSort1(a);
		System.out.println();
		selectionSort2(a);
		
	}

	
	//t(n2)
	private static void selectionSort2(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			int min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			// note this condition cant be used for objects sorting
			if(a[min]!=a[i]) {
				int temp=a[min];
				a[min]=a[i];
				a[i]=temp;
			}
			
			
		}
		
		for(int i:a) {
			System.out.print(i+" ");
		}
		
	}

	
	//t(n2),space=t(n)
	private static void selectionSort1(int[] a) {
		int temp[]=new int[a.length];
		
		for(int i=0;i<a.length;i++) {
			int min=0;
			for(int j=1;j<a.length;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			temp[i]=a[min];
			a[min]=Integer.MAX_VALUE;
			
		}
		for(int i=0;i<a.length;i++) {
			a[i]=temp[i];
		}
		for(int i:a) {
			System.out.print(i+" ");
		}
	}
}
