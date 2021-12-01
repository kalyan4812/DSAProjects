package Samples;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class A7_MaxSumThroughJumps {

	
	public static void main(String... strings) {

		//int a[]= {1,-1,-2,4,-7,3};
		
		int a[]= {10,-5,-2,4,6,3};
		ArrayList<Integer> al=new ArrayList<>();
		for(int b:a) {
			al.add(b);
		}
		int k=3;
		
		long ans=fun(al,k);
		System.out.println(ans);
		
		
		long ans2=fun2(a,k,0);
		System.out.println(ans2+a[0]);
		
		
		int n=841;
		int x=1;
		
		for(int i=0;i<50;i++) {
			int nx=(x+n/x)/2;
			x=nx;
		}
		
		
		System.out.println(x);
		
		
		
	}

	private static long fun2(int[] a, int k, int i) {
		
		if(i>=a.length) {
			return 0;
		}
		
		
		long max=Integer.MIN_VALUE;
		
		for(int j=i+1;j<=i+k && j<a.length;j++) {
			max=Math.max(max, a[j]+fun2(a,k,j+1));
		}
		
		return max;
	}

	private static long fun(ArrayList<Integer> al, int k) {
		long curr=0;
		
		Deque<Integer> dq=new LinkedList<>();
		
		for(int i=al.size()-1;i>=0;i--) {
			
			curr=al.get(i)+(dq.isEmpty()?0:al.get(dq.peekFirst()));
			
			while(dq.size()>0 && curr>al.get(dq.peekLast())) {
				dq.pollLast();
			}
			dq.addLast(i);
			
			if(dq.getFirst()>=i+k) {
				dq.pollFirst();
			}
			al.set(i,(int)curr);
			
		}
		
		return curr;
		
	}
}
