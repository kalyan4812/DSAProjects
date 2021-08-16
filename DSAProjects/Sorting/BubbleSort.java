package Sorting;

public class BubbleSort {

	// it is stable i.e order of elements in original array won't be changed after sorting for equal elements.
	
	public static void main(String...strings) {
		int [] a= {2,10,8,7};
		bubbleSort1(a);
		System.out.println();
		bubbleSort2(a);
		System.out.println();
		System.out.println("Best Approach");
		
		bubbleSort3(a);
	}

	
	// keep tracking whether array is already sorted or if gets sorted in middle using boolean variable.whenits get sorted break the loop
	// so optimised than 1 &2.
	private static void bubbleSort3(int[] a) {
		
		
		for(int i=0;i<a.length-1;i++) {
			boolean swapped=false;
			for(int j=0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false) {
				break;
			}
		}
		for(int k:a) {
			System.out.print(k+"  ");
		}
	}


	//bit optimised than1 because for ith iteration element at n-i-1 is already at its right position.
	private static void bubbleSort2(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int k:a) {
			System.out.print(k+"  ");
		}
		
	}

	//t(n2)
	private static void bubbleSort1(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int k:a) {
			System.out.print(k+"  ");
		}
	}
}