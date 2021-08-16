package Recursion;

import java.util.Scanner;

public class B7_BalancedParanthesis {

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt(); // equal no of ( & ).

		fun(s, s, "");

		sc.close();

	}

	private static void fun(int open, int closed, String output) {

		if (closed == 0 && open == 0) {
			System.out.println(output);
			return;
		}
		if (open == 0) {
			String ans = output + ")";
			fun(open, closed - 1, ans);
		} else if (open == closed) {
			String ans = output + "(";
			fun(open - 1, closed, ans);
		}

		else if (open != closed) {
			String ans1 = output + ")";
			String ans2 = output + "(";
			fun(open, closed - 1, ans1);
			fun(open - 1, closed, ans2);
		}

	}

	/*
	 * USE FULL TIP: ArrayList of string to string array.
	 * 
	 * Convert ArrayList to object array : Object[] objArr = arr.toArray();
	 * 
	 * convert Object array to String array String[] str = Arrays.copyOf(objArr,objArr.length,String[].class);
	 * 
	 * 
	 * 
	 */
}
