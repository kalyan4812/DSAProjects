package BinarySearch;

public class C1_MedianOfRowWiseSortedMatrix {

	public static void main(String...strings) {
		int a[][]= {{1,3,6},{2,6,9},{3,6,9}};
		// 1 2 3 3 6 6 6 9 9 , median is 6.
		
		int k=fun(a);
		System.out.println(k);
	}

	//O(log(2^32)*n*logm)==O(32*n*logm)
	private static int  fun(int[][] a) {
	  double l=1,h=1e9;
	  int n=a.length;
	  int m=a[0].length;
	  while(l<=h) {
		  double mid=l+(h-l)/2;
		  int count=0; // elements smaller than mid in matrix.
		  for(int i=0;i<n;i++) {
			  count=count+countElementsSmallerThanEqualToMid(a[i],mid);
		  }
		  if(count<=(n*m)/2) { // n*m gives size of matrix.
			  l=m+1;
		  }
		  else {
			  h=m-1;
		  }
	  }
		int index=(int)l;
		return index;
	}

	//O(logm)
	// indiectly we have to first index of element which is greater than mid.
	private static int countElementsSmallerThanEqualToMid(int[] a, double mid) {
		int l=0,h=a.length-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(a[m]<=mid) {
				l=m+1;
			}
			else {
				h=m-1;
			}
		}
		return l;
	}
}
