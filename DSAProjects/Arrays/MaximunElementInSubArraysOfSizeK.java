package Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaximunElementInSubArraysOfSizeK {

	public static void main(String... strings) {
		int[] a = { 2, 5, 4, 3, 1, 7 };
		int k = 3;
		fun(a, a.length, k);
		fun2(a,a.length,k);
	}

	//O(n),O(n)-space
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
	private static void fun(int[] a, int n, int k) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < k; i++) {
			max = Math.max(max, a[i]);

		}

		for (int i = k; i < n - k + 1; i++) {
			int curr_max = a[i];
			for (int j = i + 1; j < k + i; j++) {
				curr_max = Math.max(curr_max, a[j]);
			}
			max = Math.max(max, curr_max);
		}

		System.out.println(max);

	}
}
