package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class C91_SubArrayMultiplicationLessThanGivenNumber {

	public static void main(String...strings) {
		int [] a= {4,2,5,3,6};
		int num=45;
		// non negative array
		fun(a,a.length,num);
		funUsingWindow(a,a.length,num);
		fun2(a,a.length,num);
	}

	private static void fun2(int[] a, int n, int num) {
		int s=0;
		int p=1;
		List<List<Integer>> al=new ArrayList<>();
		for(int e=0;e<n;e++) {
			p=p*a[e];
			while(s<e && p>=num) {
				p=p/a[s];
				s++;
			}
			List<Integer> l=new ArrayList<>();
			for(int k=e;k>=s;k--) {
			   l.add(0,a[k]);
			   al.add(new ArrayList<>(l));
			}
			
		}
		System.out.println(al.size());
		System.out.print(al.toString());
	}

	private static void funUsingWindow(int[] a, int n, int num) {
		int s=0,res=0;
		int p=1;
		for(int e=0;e<n;e++) {
			p=p*a[e];
			while(s<e && p>=num) {
				p=p/a[s];
				s++;
			}
			if(p<num) {
				res=res+e-s+1;
			}
			
		}
		System.out.println(res);
	}

	private static void fun(int[] a, int n, int num) {
		for(int i=0;i<n;i++) {
			int m=a[i];
			if(m<num) {
				System.out.println(i);
			}
			for(int j=i+1;j<n;j++) {
				if(m*a[j]<num) {
					System.out.println(i+" "+j);
					m=m*a[j];
				}
				else {
					break;
				}
			}
		}
	}
}
