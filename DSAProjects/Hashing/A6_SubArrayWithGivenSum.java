package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class A6_SubArrayWithGivenSum {

	public static void main(String... strings) {
		int a[] = { 1, 4, 13, -3, -10, 5 };

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		fun1(a, k);

		System.out.println();

		fun2(a, k);
	}

	
	//O(N),O(N)-space.
	private static void fun2(int[] a, int sum) {
      HashSet<Integer> hs=new HashSet<>(a.length);
      int n=a.length;
      int s=0;
      for(int i=0;i<n;i++) {
    	  s=s+a[i];
    	  if(s==sum) {
    		  System.out.print("SubArray available with given sum");
    		  break;
    	  }
    	  if(hs.contains(s-sum)) {
    		  System.out.print("SubArray available with given sum");
    		  break; 
    	  }
    	  
    	  hs.add(s);
      }
      
	}

	//O(n2)
	private static void fun1(int[] a, int sum) {

		int n = a.length;

		for (int i = 0; i < n; i++) {
			int s = 0;
			for (int j = i; j < n; j++) {
				s = s + a[j];
				if (s == sum) {
					System.out.print("Found from " + i + " to " + j);
					break;
				}
			}
		}

	}

}
