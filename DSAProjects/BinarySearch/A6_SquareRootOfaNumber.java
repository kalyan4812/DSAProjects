package BinarySearch;

import java.util.Scanner;

public class A6_SquareRootOfaNumber {

	
	
	// for montonic sequences ,if you are asked to find x for f(x) think of binary search.
	public static void main(String... strings) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
      int k=  fun(n);
      System.out.println(k);
	}

	
	//O(logn)
	private static int fun(int n) {
	int l=0,h=n,ans=-1;
	while(l<=h) {
		int m=l+(h-l)/2;
		if(m*m==n) {
			return m;
		}
		else if(m*m>n) {
			h=m-1;
		}
		else {
			l=m+1;
			ans=m;
		}
	}
		return ans;
	}
}
