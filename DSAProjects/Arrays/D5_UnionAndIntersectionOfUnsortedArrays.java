package Arrays;

import java.util.HashSet;

public class D5_UnionAndIntersectionOfUnsortedArrays {

	public static void main(String...strings) {
		int [] a= {4,2,3,5,4,2,3};
		int []b= {9,1,7,2,4,2,1,2};
		union(a,b,a.length,b.length);
		System.out.println();
		intersection(a,b,a.length,b.length);
	}

	//O(n+m) ,O(n+m) space
	private static void intersection(int[] a, int[] b, int m, int n) {
		HashSet<Integer> h=new HashSet<>();
		HashSet<Integer> finalset=new HashSet<>();
		for(int i:a) {
			h.add(i);
		}
		for(int k:b) {
			if(h.contains(k)) {
			finalset.add(k);
			}
			
		}
		for(int i:finalset) {
			System.out.print(i+" ");
		}
		
	}

	//O(n+m),O(n+m)-space
	// or sort and apply union of sorted arrays logic then time will be O(nlon)+O(mlogn)+O(m+n)
	private static void union(int[] a, int[] b, int m, int n) {
		HashSet<Integer> h=new HashSet<>();
		for(int i:a) {
			h.add(i);
		}
		for(int k:b) {
			h.add(k);
		}
		for(int i:h) {
			System.out.print(i+" ");
		}
		
	}
}
