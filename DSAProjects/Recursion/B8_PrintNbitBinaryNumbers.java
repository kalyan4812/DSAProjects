package Recursion;

import java.util.Scanner;

public class B8_PrintNbitBinaryNumbers {

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt(); 

		fun(0,0,s,"");

		sc.close();

	}

	private static void fun(int ones, int zeroes, int n,String output) {
		if(n==0) {
			System.out.println(output);
			return;
		}
		if(ones==zeroes) {
			String ans=output+"1";
			fun(ones+1,zeroes,n-1,ans);
		}
		else if(ones>zeroes) {
			String ans1=output+"1";
			String ans2=output+"0";
			fun(ones+1,zeroes,n-1,ans1);
			fun(ones,zeroes+1,n-1,ans2);
		}
		
		
	}
}
