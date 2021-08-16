package Recursion;

public class A4_CheckPalindrome {

	public static void main(String... strings) {
		String s = "RACECAR";
		check(s, 0, s.length() - 1);
	}

	
	
	//O(n^2)
	private static void check(String str, int s, int e) {

		if (s == e) {
			System.out.println("Its a palindrome");
			return;
		}

		if (str.charAt(e) != str.charAt(s)) {  // it will take O(n)
			System.out.println("Its not  a palindrome");
			return;
		}

		check(str, s + 1, e - 1);

	}
}
