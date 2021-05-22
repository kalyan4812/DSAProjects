package Sorting;

public class IntersectionOfSortedArrays {

	public static void main(String...strings) {
		int a[]= {2,5,8,13,15};
		int b[]= {1,3,8,15,18,20,25};
		intersectionFun(a,b,a.length,b.length);
		System.out.println();
		intersectionFunUsingMergeFunction(a,b,a.length,b.length);
	}

	//O(m+n)
	private static void intersectionFunUsingMergeFunction(int[] a, int[] b, int m, int n) {
		int i=0,j=0;
		while(i< m && j<n) {
			if(i>0 && a[i]==a[i-1]) {
				continue;
			}
			if(a[i]<b[j]) {
				i++;
			}
			else if(a[i]>b[j]) {
				j++;
			}
			else {
				System.out.print(a[i]+" ");
				i++;
				j++;
			}
		}
		
	}

	//O(m*n)
	private static void intersectionFun(int[] a, int[] b, int m, int n) {
	
		for(int i=0;i<m;i++) {
			if(i>0 && a[i]==a[i-1]) {
				continue;
			}
			for(int j=0;j<n;j++) {
				if(a[i]==b[j]) {
					System.out.print(a[i]+" ");
				}
			}
		}
	}
}
