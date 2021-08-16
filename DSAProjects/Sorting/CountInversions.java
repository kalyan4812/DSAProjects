package Sorting;


// inversion means  i<j  but a[i]>a[j]
public class CountInversions {

	public static void main(String...strings) {
		int a[]= {2,4,1,3,5};
		int l=a.length;
		coutInversion(a,l);
		int count=coutInversionUsingMergeFunction(a,0,l-1);
		System.out.println(count+" using merge function");
	}

	
	//O(nlogn) ,O(n) space
	private static int coutInversionUsingMergeFunction(int[] a, int l,int r) {
	   int res=0;
		if(l<r) {
			int m=l+(r-l)/2;
			res=res+coutInversionUsingMergeFunction(a,l,m);
			res=res+coutInversionUsingMergeFunction(a,m+1,r);
			res=res+mergeFunctionWithCount(a,l,m,r);
			
		}
		return res;
	}


	private static int mergeFunctionWithCount(int[] a, int l, int m, int r) {
		int left[]=new int[m-l+1];
		int right[]=new int[r-m];
		for(int i=0;i<left.length;i++) {
			left[i]=a[l+i];
		}
		for(int i=0;i<right.length;i++) {
			right[i]=a[i+m+1];
		}
		int i=0,j=0,res=0,k=l;
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j]) {
				a[k]=left[i];
				i++;
				k++;
			}
			else {
				a[k]=right[j];
				j++;
				k++;
				res=res+left.length-i;
			}
		}
		while(i<left.length) {
			a[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			a[k]=right[j];
			j++;
			k++;
		}
		return res;
	}


	//O(n2)
	private static void coutInversion(int[] a, int n) {
		int count=0;
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(a[i]>a[j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
