package Sorting;

public class HeapSort {

	public static void main(String...strings) {
		int [] a= {10,15,50,4,20};
		heapSort(a,a.length);
		
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	private static void heapSort(int[] a, int n) {
			buildHeap(a,n);
			
			for(int i=n-1;i>=1;i--) {
				int temp=a[0];
				a[0]=a[i];
				a[i]=temp;
				heapify(a,i,0);
			}
	}

	private static void buildHeap(int[] a, int n) {
	for(int i=(n-2)/2;i>=0;i--) {
		heapify(a,n,i);
	   }
		
	}

	private static void heapify(int[] a, int n, int i) {
		int largest=i,leftnode=2*i+1,rightnode=2*i+2;
		if(leftnode<n && a[leftnode]>a[largest]) {
		largest=leftnode;	
		 }
        if(rightnode<n && a[rightnode]>a[largest]) {
			largest=rightnode;
		}
        if(largest!=i) {
        	int temp=a[largest];
        	a[largest]=a[i];
        	a[i]=temp;
        	heapify(a,n,largest);
        }

		
	}
}
