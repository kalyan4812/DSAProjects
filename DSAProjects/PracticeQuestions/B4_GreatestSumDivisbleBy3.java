package PracticeQuestions;

import java.util.Arrays;

public class B4_GreatestSumDivisbleBy3 {

	public static void main(String... strings) {
		int a[] = { 3, 6, 5, 1, 8 };

		int sum = 0;

		for (int k : a) {
			sum = sum + k;
		}

		db = new int[sum + 1][a.length+1];
		for(int x[]:db) {
			Arrays.fill(x,-1);
		}
		int k = fun(a, a.length, 0, 0);
		System.out.println(k);
		
		
		
		
		int p = fun2(a, a.length, 0, 0);
		System.out.println(p);
	}
	
//-------------------------------------------------------------------------------------------------------------------------------	

	private static int fun2(int[] a, int n, int rem, int i) { // rem=remainder
		if (i >= n) {
			return rem==0? rem : Integer.MIN_VALUE;
		}
		
		int ans = 0;

		ans = Math.max(a[i]+fun2(a,n,(rem+a[i])%3,i+1),fun2(a,n,rem,i+1));
        
		return ans;
	}

	
//-----------------------------------------------------------------------------------------------------------------	
	static int db[][];

	private static int fun(int[] a, int n, int sum, int i) {
		if (i >= n) {
			return sum % 3 == 0 ? sum : 0;
		}
		if(db[sum][i]!=-1) {
			return db[sum][i];
		}
		int rem = 0;

		rem = Math.max((db[sum+a[i]][i+1]!=-1)?db[sum+a[i]][i+1]:fun(a, n, sum + a[i], i + 1),(db[sum][i+1]!=-1)?db[sum][i+1]: fun(a, n, sum, i + 1));
        db[sum][i]=rem;
		return rem;
	}
}
