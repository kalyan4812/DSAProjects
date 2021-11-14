package Samples;

public class A3_DivideIntoSets {

	public static void main(String... strings) {

		// N natural number is given and you to divide this in two sets
		// and return minimum difference sum of two subsets
		
		int ans=fun(4);
		System.out.println(ans);
	}

	private static int fun(int n) {
		if(n%4==0 || n%4==3) {
			return 0;
		}
		return 1;
	}
}
