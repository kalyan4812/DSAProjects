package Sorting;

public class A9_CountingSort {

	//use when k directly prpotional to n
	public static void main(String...strings) {
		int [] a= {1,4,4,1,0,1};
		int rangeofelements=5;
		countingSort(a,a.length,rangeofelements);
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
		countingSortStable(a,a.length,rangeofelements);
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	//t(n+k) space,t(n+k) time
	private static void countingSortStable(int[] a, int n, int k) {
		int count[]=new int[k];
		for(int i=0;i<k;i++) {
			count[i]=0;
		}
		for(int i=0;i<n;i++) {
			count[a[i]]++;
		}
		for(int i=1;i<k;i++ ) {
			count[i]=count[i]+count[i-1];
		}
		int output[]=new int[n];
		
		// to make sure its stable ,we are traversing from right to left and it can be used for object sorting also because we are assignig 
		// output array to normal array object not normal index.
		for(int i=n-1;i>=0;i--) {
			output[count[a[i]]-1]=a[i];
			count[a[i]]--;
		}
		for(int i=0;i<n;i++) {
			a[i]=output[i];
		}
	}

	//O(n+k) not stable for objects sorting,beacuse we cant keep index in a object (last for loop)
	private static void countingSort(int[] a, int n, int k) {
		int count[]=new int[k];
		for(int i=0;i<k;i++) {
			count[i]=0;
		}
		for(int i=0;i<n;i++) {
			count[a[i]]++;
		}
		int index=0;
		for(int i=0;i<k;i++) {
			for(int j=0;j<count[i];j++) {
				a[index]=i;
				index++;
			}
		}
	}
}
