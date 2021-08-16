package Recursion;

import java.util.Scanner;

public class B1_KthSymbolInGrammar {

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		/*
		 * pattern-given n=1,k=1 value 0,for 0-print 01,for 1 -print 10
		 * 0
		 * 0 1
		 * (0 1) 1 0 (n=3,k=1,2,3,4)   here 0 1 is same as above , 1 0 is compliment to above row (01->10)
		 * 0 1 1 0 1 0 0 1
		 * 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
		 * so given n,k print value.
		 */
		
		int p=fun(n,k);
		System.out.println(p);
		sc.close();
	}

	
	
	private static int fun(int n, int k) {
		if(n==1 && k==1) {
			return 0;
		}
		if( k<=(Math.pow(2, n-1))/2 ) {  // idea if k is in left half ,it is same as answer in n-1 row.
			return fun(n-1,k);
		}
		
		else  {  
			return (fun(n-1,k-(int)Math.pow(2, n-1)/2)==1)?0:1;  // if k is in right half answer is compliment to n-1 row items.
			
			}
		
		
	}
}
