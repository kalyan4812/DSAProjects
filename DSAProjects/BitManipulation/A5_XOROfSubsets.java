package BitManipulation;

public class A5_XOROfSubsets {

	public static void main(String...strings) {
		int a[]= {1,3,2};
		printXOROfAllSubsets(a);
	}

	private static void printXOROfAllSubsets(int[] a) {
	
		if(a.length==1) {
			System.out.print(a[0]);
			return;
		}
		System.out.print("0"); // always.
		
		
		
		//logic: if you fix any number in array, we can have that number in 2^n-1 subsets which is always even.so xor of even occurrence is always zero.
		
	}
}
