package Hashing;

import java.util.HashSet;

public class A5_CountDistinctElements {


	public static void main(String... strings) {
		int a[] = { 10, 12, 20, 15, 10, 20, 12, 12 };

		fun1(a);

		System.out.println();

		fun2(a);
	}

	//O(N),O(N)-space.
	private static void fun2(int[] a) {
		HashSet<Integer> hs=new HashSet<>(a.length); //when use capacity mention it.
		for(int i=0;i<a.length;i++) {
			hs.add(a[i]);
		}
		for(int g:hs) {
			System.out.print(g+" ");
		}
	}

	//O(n2)
	private static void fun1(int[] a) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			boolean visited=false;
			for(int j=i-1;j>=0;j--) {
				if(a[j]==a[i]) {
					visited=true;
					break;
				}
			}
			if(visited) continue;
			
			System.out.print(a[i]+"  ");
		}
		
	}
	
}
