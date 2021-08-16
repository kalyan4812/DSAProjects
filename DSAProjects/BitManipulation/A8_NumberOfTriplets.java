package BitManipulation;

public class A8_NumberOfTriplets {

	public static void main(String...strings) {
		int a[]= {1,3,2,5,7,2,7,5,6,4};
		
		// find number of  i,j,k indexes such that 0<=i<j<=k<a.length and
		// x=a[i+1]^a[i+2]..a[j-1] ,y=a[j]^a[j+1]...a[k] such that x==y.
		
		find(a);
	}

	// idea : find range i to k where xor is zero,so now wherever you place j in between you get x==y.so if length of range is j-i,then j-i triplets are possible.
	private static void find(int[] a) {
	
		int count=0;
		for(int i=0;i<a.length;i++) {
			int val=a[i];
			for(int j=i+1;j<a.length;j++) {
				val=val^a[j];
				if(val==0) {
					count=count+(j-i);
				}
			}
		}
		System.out.println(count);
	}
	

}
