package BasicQuestions;

import java.util.Scanner;

public class A1_TakeInput {

	public static void main(String...strings) {
		
		// for taking number and strings at a time.
		
		Scanner sc=new Scanner(System.in);
		
		int n=Integer.parseInt(sc.nextLine()); // if you take normal sc.nextInt(),it will skip down string .
		String s=sc.nextLine();
		
		System.out.println(n+"    "+s);
		
	}
}
