package DPProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B1_LongestPath {

	/*
	 * There is a directed graph G with N vertices and M edges. The vertices are
	 * numbered 1,2,…,N, and for each i (1≤i≤M), the i-th directed edge goes from
	 * Vertex xi to yi.G does not contain directed cycles.
	 * 
	 * Find the length of the longest directed path in G. Here, the length of a
	 * directed path is the number of edges in it.
	 */

	// idea:

	// the longest path from a node of outdegree zero is 0.

	// from a node ,go to that node which gives longest path.

	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n+1);

		for (int i = 0; i <=n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		while (m > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			addEdge(adj, x, y);
			m--;
		}
		
		db=new int[n+1];
		Arrays.fill(db,-1);
		
		int max=0;
		for(int i=1;i<=n;i++) {
			max=Math.max(max, longestPath(i,adj));
		}

		System.out.println(max);
	}

	static int db[];
	private static int longestPath(int src, ArrayList<ArrayList<Integer>> adj) {
		
		if(db[src]!=-1) {
			return db[src];
		}
		
		int res=Integer.MIN_VALUE;
		boolean no_neighbour=true;
		for(int child:adj.get(src)) {
			no_neighbour=false;
			res=Math.max(longestPath(child,adj), res);
		}
		db[src]=no_neighbour?0:(res+1);;
		return  db[src];
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);

	}
}
