package Recursion;

import java.util.Scanner;

public class A3_NthFibanocciNumber {

	public static void main(String... strings) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k=fun(n);
		System.out.println(k);

	}

	
	
	
	//O(2^n)
	private static int fun(int n) {
		if(n==0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		
		return fun(n-1)+fun(n-2);

	}
}
