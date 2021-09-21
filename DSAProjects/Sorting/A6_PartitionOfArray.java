package Sorting;

public class A6_PartitionOfArray {

	public static void main(String...strings) {
		int a[]= {5,13,6,9,12,11,8};
		int pivot=6;
	    // i.e all elements left to 8 should be small and right should be large.
		// output : 5,6,8,9,12,11,13
		
		partition(a,pivot);
		
		
		System.out.println();
		int b[]= {5,13,6,9,12,11,8};
		lamutoPartition(b,0,pivot);
		
		
		
		System.out.println();
		int c[]= {5,3,8,4,2,7,1,10};
		hoaresPartition(c,0,c.length-1);
		
		
	}

	
	//here pivot is first element
	
	//Note pivot may not be at correct position it just ensures all elements <=5 & >=5 as two groups
	// output: (1,3,2,4) (8,7,5,10)
	
	//uses less comparision compared to lamuto
	private static void hoaresPartition(int[] a, int l, int r) {
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
		
		for(int k:a) {
			System.out.print(k+" ");
		}
	}


	//O(n) ,but pivot should be always last element
	private static void lamutoPartition(int[] a,int l,int h) {
		
		
		//this condition to handle when pivot is not last element ,just swap last and given pivot element and apply laumoto partition
		if(h!=a.length-1) {
			int temp=a[h];
			a[h]=a[a.length-1];
			a[a.length-1]=temp;
		}
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
		for(int k:a) {
			System.out.print(k+" ");
		}
	}

	//t(n),t(n)-space pivot can be anywhere
	private static void partition(int[] a, int pivot) {
		int h=pivot;
		int l=0;
		int[] temp=new int[a.length];
		int index=0;
		for(int i=l;i<a.length;i++) {
			if(a[i]<a[pivot]) {
				temp[index]=a[i];
				index++;
			}
		}
		temp[index]=a[pivot];
		index++;
		for(int i=l;i<a.length;i++) {
			if(a[i]>a[pivot]) {
				temp[index]=a[i];
				index++;
			}
		}
		
		for(int i=l;i<a.length;i++) {
			a[i]=temp[i-l];
		}
		
		for(int k:a) {
			System.out.print(k+" ");
		}
		
	}
}
