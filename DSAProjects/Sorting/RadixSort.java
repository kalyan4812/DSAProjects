package Sorting;

public class RadixSort {
	public static void main(String...strings) {
		int [] a= {319,212,6,8,100,50};
		
		radixSort(a,a.length);
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	private static void radixSort(int[] a, int n) {
		int max=a[0];
		for(int i=1;i<n;i++) {
			max=Math.max(max, a[i]);
		}
		for(int exp=1;max/exp>0;exp=exp*10) {
			countingSort(a,n,exp);
		}
		
	}

	private static void countingSort(int[] a, int n, int exp) {
		int count[]=new int[10];
		for(int i=0;i<10;i++) {
			count[i]=0;
		}
		for(int i=0;i<n;i++) {
			count[(a[i]/exp)%10]++;
		}
		for(int i=1;i<10;i++ ) {
			count[i]=count[i]+count[i-1];
		}
		int output[]=new int[n];
		
		// to make sure its stable ,we are traversing from right to left and it can be used for object sorting also because we are assignig 
		// output array to normal array object not normal index.
		for(int i=n-1;i>=0;i--) {
			output[count[(a[i]/exp)%10]-1]=a[i];
			count[(a[i]/exp)%10]--;
		}
		for(int i=0;i<n;i++) {
			a[i]=output[i];
		}
		
	}
}
