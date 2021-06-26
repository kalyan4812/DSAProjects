package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class C1_MaxCutsOfRope {

	static int max = -1;

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int l = fun(n, a, b, c,0,0,0);
		System.out.println(l);

		sc.close();

	}

	private static int fun(int len, int a, int b, int c,int p,int q,int r) {
		if(len<0) {
			return -1;
		}
		if (len == 0) {

			max= Math.max(Math.max(p, q), r);
			

		}

		if (len >= a || len >= b || len >= c) {

			fun(len - a,a,b,c, p+1, q, r);
			fun(len - b,a,b,c, p, q+1, r);
			fun(len - c, a,b,c,p, q, r+1);
		}
		
		return max;

	}
}
