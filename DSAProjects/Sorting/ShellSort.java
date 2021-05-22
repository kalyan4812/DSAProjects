package Sorting;

public class ShellSort {
	public static void main(String...strings) {
		int [] a= {60,40,10,30,50,20};
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		shellSort(a,a.length);
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	private static void shellSort(int[] a, int n) {
		
		// this is to place smaller elemnts to left so that insertion sort can be improved because smaller elements will be on left
		for(int i=n/2 ;n>1;n=n/2) {
			insertionsortwithgapmorethan1(a,n,i);
			
		}
		
		//here n==1 i.e gap=1
		insertionsort(a,n);
	}

	private static void insertionsortwithgapmorethan1(int[] a, int n, int d) {
            for(int i=0;i+d<n;i++) {
			
			if( a[i]>a[i+d]) {
				int temp=a[i];
				a[i]=a[i+d];
				a[i+d]=temp;
			}
		}
		
		
	}

	private static void insertionsort(int[] a, int n) {
		for(int i=1;i<a.length;i++) {
			int key=a[i];
			int j;
			for( j=i-1;j>=0 && a[j]>key;j--) {
				
					a[j+1]=a[j];
				
			}
			
			a[j+1]=key;
		}
		
	}
}
