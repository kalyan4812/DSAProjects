package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B3_MergeKSortedArrays {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		al.add(new ArrayList<>(Arrays.asList(10, 20, 30)));
		al.add(new ArrayList<>(Arrays.asList(5, 15)));
		al.add(new ArrayList<>(Arrays.asList(1, 9, 11, 18)));

		ArrayList<Integer> ans = merge(al);
		System.out.print(ans.toString());
	}
	
	//O(nklogk)==O(nk*logk)

	private static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> al) {

		ArrayList<Integer> ans = new ArrayList<Integer>();

		
		PriorityQueue<Triplet> pq=new  PriorityQueue<>();
		
		for(int i=0;i<al.size();i++) {
			pq.add(new Triplet(al.get(i).get(0),i,0));
		}
		
		while(!pq.isEmpty()) {
			Triplet tr=pq.poll();
			ans.add(tr.val);
			int aPos=tr.aPos,vPos=tr.vPos;
			if(vPos+1<al.get(aPos).size()) {
				pq.add(new Triplet(al.get(aPos).get(vPos+1),aPos,vPos+1));
			}
		}
		return ans;
	}

	static class Triplet implements Comparable<Triplet> {

		int val, aPos, vPos;

		Triplet(int val, int aPos, int vPos) {
			this.aPos = aPos;
			this.val = val;
			this.vPos = vPos;
		}

		@Override
		public int compareTo(Triplet t) {
			if (val <= t.val) {
				return -1;
			}

			return 1;
			// or return val-t.val;
		}

	}
}
