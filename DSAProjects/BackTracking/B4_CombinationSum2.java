package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class B4_CombinationSum2 {

	public static void main(String...strings) {
		int a[]= {1,1,2,3}; // have duplicates.
		int sum=4;
		
		
		
		combSum(a,a.length,sum);
		System.out.print(al.toString());
	}

	static HashSet<ArrayList<Integer>> al=new HashSet<>();
	static ArrayList<Integer> list;
	
	//O(2^min(target/min elemnet,n)
	private static void combSum(int[] a, int length, int target) {
		list=new ArrayList<>();
		helper(0,a,length,target,list,0);
	}
	private static void helper(int i,int[] a, int n, int target, ArrayList<Integer> l, int sum) {
	  if(sum==target) {
		  al.add(new ArrayList<>(l));
		  return;
	  }
	  if(i==n || sum>target) {
		  return;
	  }
	  sum=sum+a[i];
	  l.add(a[i]);
	  
	  helper(i+1,a,n,target,list,sum);
	  
	  sum=sum-a[i];
	  l.remove(l.size()-1);
	  
	  helper(i+1,a,n,target,list,sum);
	  
	  
	}
}
