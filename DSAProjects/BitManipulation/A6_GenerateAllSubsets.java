package BitManipulation;

public class A6_GenerateAllSubsets {

	public static void main(String...strings) {
		int a[]= {1,3,4};
		
		print(a,a.length);
	}

	//t(2^n*n)  run for n<20.
	private static void print(int[] a, int n) {
		int pow=(1<<n); //2^N
		for(int num=0;num<pow;num++) {
			for(int bit=0;bit<n;bit++) {
				if((num&(1<<bit))!=0) { // check if bit is set or not.
					System.out.print(a[bit]+" ");
				}
			}
			System.out.println();
		}
	}
}
