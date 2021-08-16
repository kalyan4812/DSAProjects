package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class B9_MaximumAreaHistogram {

	public static void main(String...strings) {
		int a[]= {6,2,5,4,5,1,6}; // heights of building.
		fun(a);
	}

	private static void fun(int[] a) {
	  
		if(a.length==0) {
			return;
		}
		
		ArrayList<Integer> right=nextSmallerToRight(a);
		ArrayList<Integer> left=nextSmallerToLeft(a);
		
		int width[]=new int[left.size()];
		for(int i=0;i<width.length;i++) {
			width[i]=right.get(i)-left.get(i)-1;
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			max=Math.max(max, a[i]*width[i]);
		}
		
		System.out.println(max);
		
		
	}
	
	private static ArrayList<Integer> nextSmallerToLeft(int[] a) {
		if (a.length == 0) {
			return null;
		}
		Stack<Pair> st = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 0; i <a.length; i++) {
			if (st.isEmpty()) {
				al.add(-1);
			} else if (!st.isEmpty() && st.peek().value < a[i]) {
				al.add(st.peek().index);
			} else if (!st.isEmpty() && st.peek().value >= a[i]) {
				while (!st.isEmpty() && st.peek().value >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					al.add(-1);
				} else {
					al.add(st.peek().index);
				}
			}
			st.push(new Pair(a[i],i));
		}
		return al;
		
	}

	private static ArrayList nextSmallerToRight(int[] a) {
		if (a.length == 0) {
			return null;
		}
		Stack<Pair> st = new Stack<>();
		ArrayList<Integer> al = new ArrayList<>();

		for (int i = a.length - 1; i >= 0; i--) {
			if (st.isEmpty()) {
				al.add(a.length);
			} else if (!st.isEmpty() && st.peek().value < a[i]) {
				al.add(st.peek().index);
			} else if (!st.isEmpty() && st.peek().value >= a[i]) {
				while (!st.isEmpty() && st.peek().value >= a[i]) {
					st.pop();
				}
				if (st.isEmpty()) {
					al.add(a.length);
				} else {
					al.add(st.peek().index);
				}
			}
			st.push(new Pair(a[i],i));
		}
		Collections.reverse(al);

		return al;

	}
	
	static class Pair {
		int value, index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
