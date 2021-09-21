package Sorting;

import java.util.Arrays;

public class C5_SquareSortedArrayAndSortIt {

	public static void main(String...strings) {
		int [] a= {-4,-2,-1,3,5};
		fun(a,a.length);
		
		System.out.println();
		int [] b= {-4,-2,-1,3,5};
		fun2(b,b.length);
	}

	//O(N),O(N)-space
	private static void fun2(int[] a, int n) {
		int s=0,e=n-1,i=n-1;
		int temp[]=new int[n];
		while(s<=e) {
			int x=a[s]*a[s];
			int y=a[e]*a[e];
			if(x>y) {
			temp[i]=x;	
			s++;
			i--;
			
			}
			else if(y>x){
				
				temp[i]=y;
				e--;
				i--;
				
			}
			else {
				temp[i]=x;
				s++;
				e--;
			}
			
			
		}
		for(int k:temp) {
			System.out.print(k+" ");
		}
		
	}

	
	//O(nlogn)
	private static void fun(int[] a, int n) {
	
		for(int i=0;i<n;i++) {
			a[i]=a[i]*a[i];
		}
		Arrays.sort(a);
		
		for(int i:a) {
			System.out.print(i+" ");
		}
	}
}
