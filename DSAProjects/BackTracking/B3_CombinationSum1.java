package BackTracking;

import java.util.ArrayList;

public class B3_CombinationSum1 {

	public static void main(String...strings) {
		int a[]= {1,2,3};
		int sum=4;
		
		// you can have duplicates.
		
		combSum(a,a.length,sum);
		System.out.print(al.toString());
	}

	static ArrayList<ArrayList<Integer>> al=new ArrayList<>();
	static ArrayList<Integer> list;
	
	//O(2^min(target/minelemnet,n)
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
	  
	  helper(i,a,n,target,list,sum);
	  
	  sum=sum-a[i];
	  l.remove(l.size()-1);
	  
	  helper(i+1,a,n,target,list,sum);
	  
	  
	}
}
