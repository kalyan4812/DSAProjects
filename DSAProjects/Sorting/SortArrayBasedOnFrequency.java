package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayBasedOnFrequency {
 
	
	static Map<Integer,Integer> m=new HashMap<>();
	public static void main(String...strings) {
		Integer a[]= {10,7,10,11,10,7,5,6};
		sort(a,a.length);
		
		for(int i:a) {
			System.out.print(i+" ");
		}
	}

	
	//O(nlogn),O(n)-space
	private static void sort(Integer [] a, int n) {
		m.clear();
		for(int i=0;i<n;i++) {
			m.put(a[i], m.getOrDefault(a[i], 0)+1);
		}
		Arrays.sort(a,new MyComparator());
	
	}
	
	public static class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1,Integer o2) {
			int f1=m.get(o1);
			int f2=m.get(o2);
			if(f1!=f2) {
				return f2-f1;
			}
			
			return o1-o2;
		}
		
	}
}
