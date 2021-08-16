package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import Stacks.B9_MaximumAreaHistogram.Pair;

public class C1_MaxAreaRectangleInBinaryMatrix {
	
	/*
	 *  0 1 1 0
	 *  1 1 1 1
	 *  1 1 1 1
	 *  1 1 0 0
	 *
	 */
	
	// idea: divide matrix  into 4 separate histograms.
	// for each histogram find max ,and take max among them.
	public static void main(String...strings) {
		
		int a[][]= {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
		
		int k[]=a[0];
		int max=maxAreaHistogram(k);
		
		int n=a.length;
		int m=a[0].length;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(a[i][j]==0) {
					k[j]=0;
				}
				else {
				k[j]=k[j]+a[i][j];
				}
			}
			max=Math.max(max, maxAreaHistogram(k));
		}
		
		System.out.println(max);
		
	}
	
	
	
	
	
	private static int maxAreaHistogram(int[] a) {
		  
		if(a.length==0) {
			return -1;
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
		
		return max;
		
		
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
