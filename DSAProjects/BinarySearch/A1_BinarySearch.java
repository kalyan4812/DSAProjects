package BinarySearch;

import java.util.Scanner;

public class A1_BinarySearch {

	public static void main(String...strings) {
		int a[]= {10,20,30,40,50,60};
		Scanner sc=new Scanner(System.in);
		int ele=sc.nextInt();
		
		iterativeBs(a,ele);
		
		recursiveBs(a,0,a.length-1,ele);
	}

<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/kalyan4812/DSAProjects.git
	//O(logn)+ space for storing functions in stack.
	private static void recursiveBs(int[] a,int low,int high, int ele) {
		
		int l=low,h=high;
		if(l>h) {
			System.out.println("-1");
			return;
		}
		int m=l+(h-l)/2;  // to avoid overflow of int size.
		if(a[m]==ele) {
			System.out.println(m);
			return;
		}
		else if(ele<a[m]) {
			recursiveBs(a,l,m-1,ele);
		}
		else {
			recursiveBs(a,m+1,h,ele);
		}
		
	}


	//O(Logn)
	private static void iterativeBs(int[] a, int ele) {
		int n=a.length;
		int l=0,h=n-1;
		while(l<=h) {
			int m=l+(h-l)/2;  // to avoid overflow of int size.
			if(a[m]==ele) {
				System.out.println(m);
				break;
			}
			else if(ele<a[m]) {
				h=m-1;
			}
			else {
				l=m+1;
			}
		}
		
		
	}
}
