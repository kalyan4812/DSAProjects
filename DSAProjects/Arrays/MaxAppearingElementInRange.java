package Arrays;

import java.util.ArrayList;

public class MaxAppearingElementInRange {

	public static void main(String...strings) {
		int a[]= {1,2,3};
		int b[]= {3,5,7};
		printElement(a,b);
	}

	//O(n) using prefix method
	private static void printElement(int[] a, int[] b) {
		ArrayList<Integer> al=new ArrayList<>(1000);
		for(int i=0;i<1000;i++) {
			al.add(i,0);
		}
		for(int i=0;i<a.length;i++) {
		   al.set(a[i],al.get(a[i])+1);
		   al.set(b[i]+1, al.get(b[i]+1)-1);
		}
		int max=al.get(0),res=0;
		for(int i=1;i<1000;i++) {
			al.set(i, al.get(i)+al.get(i-1));
			if(al.get(i)>max) {
				max=al.get(i);
				res=i;
			}
		}
		System.out.print(res);
	}
}
