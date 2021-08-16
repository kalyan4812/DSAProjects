package Arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximunElementInSubArraysOfSizeK {

	public static void main(String... strings) {
		int[] a = { 2, 5, 4, 3, 1, 7 };
		int k = 3;
		fun(a, a.length, k);
		fun2(a,a.length,k);
		
		System.out.println();
		fun3(a,a.length,k);
	}

	
	//O(N),O(K)-space.
	private static void fun3(int[] a, int n, int k) {

		int s=0,e=0;
		ArrayList<Integer> al=new ArrayList<>();
		while(e<n) {
			while(!al.isEmpty()&& al.get(al.size()-1)<a[e]) {
				al.remove(al.size()-1);
			}
			al.add(a[e]);
			if(e-s+1==k) {
				System.out.print(al.get(0)+" ");
				if(a[s]==al.get(0)) {
					al.remove(0);
				}
				s++;
			}
			e++;
		}
	}

	//O(n),O(k)-space
	private static void fun2(int[] a, int n, int k) {
		Deque<Integer> dq=new LinkedList<>();
		for(int i=0;i<k;i++) {
			while(!dq.isEmpty() && a[i]>=a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		
		for(int i=k;i<n;i++) {
			System.out.print(a[dq.peek()]+"  ");
			
			//remove max element if its out of window.
			while(!dq.isEmpty() && i-k>=dq.peek()) {
				dq.removeFirst();
			}
			while(!dq.isEmpty() && a[i]>=a[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.print(a[dq.peek()]+"  ");
	}

	// O(n*k)
	
	// things to note for sorted array:you go exactly once into while loop
	//for reverse sorted you wont got to while loop.
	//for random one you go only sometimes into while loop
	//so overll complexity is improved.
	private static void fun(int[] a, int n, int k) {

		int max = Integer.MIN_VALUE;

		int s=0,e=0;
		while(e<n) {
			max=Math.max(max, a[e]);
			if(e-s+1==k) {
				System.out.print(max+" ");
				if(a[s]!=max) {
					s++;
				}
				else {
					max=Integer.MIN_VALUE;
					for(int p=s+1;p<s+3;p++) {
						max=Math.max(max, a[p]);
					}
					s++;
				}
			}
			e++;
		}
		System.out.println();
	}
}
