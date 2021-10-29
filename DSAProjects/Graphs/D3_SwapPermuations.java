package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class D3_SwapPermuations {

	// given array
	// can u convert it to other array ,but you have to swap only given pairs.
	
	
	// giving wrong answer???
	public static void main(String...strings) {
		
		int p[]= {1,3,2,4};
		int q[]= {1,4,2,3};
		
		int swap[][]= {{3,4}};
		
		// idea : if given swap pairs are in same connected component,they can be interchanged anyway.
		
		// so traverse array p,and check whether p[i],q[i] exist in same component.if any one don't exist return false.
		
		
		
		HashMap<Integer,ArrayList<Integer>> adj=	setUpGraph(swap);
		
		boolean b= dfsTraversal(adj, adj.size(),p,q);
		
		System.out.println(b);
		
	
	}
	
	
	
	
	
	
	private static boolean dfsTraversal(HashMap<Integer,ArrayList<Integer>> adj, int size, int[] p, int[] q) {

		boolean visited[] = new boolean[100];
		
		
		HashMap<Integer,ArrayList<Integer>> comp;
		int count=0;
		for (int i :adj.keySet()) {
			if (!visited[i] ) {
				dfs(adj, i, visited);	
			}
		
		}
		
		
		for(int i=0;i<p.length;i++) {
			if(p[i]==q[i]) {
				continue;
			}
			else {
				if(!adj.containsKey(p[i])) {
					return false;
				}
				
				boolean flag=false;
				for(int k:adj.get(p[i])) {
				   if(k==q[i]) {
					   flag=true;
				   }
				}
				
				if(!flag) {
					return false;
				}
				
				
			}
		}
		
		return true;
	}
	
	
	
	
	
    private static void dfs(HashMap<Integer,ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s + " ");
		
	  	for (int k : adj.get(s)) {
			if (!visited[k]) {
				
				dfs(adj, k, visited);
			}
		}
	}

	private static HashMap<Integer,ArrayList<Integer>> setUpGraph(int[][] swap) {
		HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();

		
		
		for(int a[]:swap) {
			addEdge(adj,a[0],a[1]);
		}
		
		return adj;
		
	}
	
	private static void addEdge(HashMap<Integer,ArrayList<Integer>> adj, int n1, int n2) {
		if (adj.containsKey(n1)) {
			adj.get(n1).add(n2);
		} else {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(n2);
			adj.put(n1, al);
		}

		if (adj.containsKey(n2)) {
			adj.get(n2).add(n1);
		} else {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(n1);
			adj.put(n2, al);
		}

	}
}
