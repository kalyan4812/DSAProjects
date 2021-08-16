package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import Graphs.B2_ShortestPathUsingBellmanFord.Node;

public class B4_MSTUsingPrimsAlgorithm {

	public static void main(String... strings) {

		ArrayList<ArrayList<Node>> adj = setUpGraph();

		primsAlgorithm(adj, 5);
		System.out.println();
		System.out.println();
		
		primsOptimized(adj,5);

	}

	//O(vlogv)
	private static void primsOptimized(ArrayList<ArrayList<Node>> adj, int v) {
		
		int key[]=new int [v+1];
		int parent[]=new int[v+1];
		boolean mst[]=new boolean[v+1];
		for(int i=0;i<v;i++) {
			key[i]=Integer.MAX_VALUE;
			parent[i]=-1;
			mst[i]=false;
		}
		key[0]=0;
		
		PriorityQueue<Node> pq=new PriorityQueue<Node>(v,new Node());
		pq.add(new Node(0,key[0]));
		
		// get the minimum.
		for(int j=0;j<v-1;j++) {
			int u=pq.poll().val;
            mst[u]=true;
            
            for(Node n:adj.get(u)) {
            	if(!mst[n.val] && n.weight<key[n.val]) {
            		parent[n.val]=u;
            		key[n.val]=n.weight;
            		pq.add(new Node(n.val,key[n.val]));
            	}
            }
		}
		
		
		for(int i=1;i<v;i++) {
			System.out.println(parent[i]+"_"+i);
		}
		
		
	}

	//O(>V2)
	private static void primsAlgorithm(ArrayList<ArrayList<Node>> adj, int v) {
		
		int key[]=new int [v+1];
		int parent[]=new int[v+1];
		boolean mst[]=new boolean[v+1];
		for(int i=0;i<v;i++) {
			key[i]=Integer.MAX_VALUE;
			parent[i]=-1;
			mst[i]=false;
		}
		key[0]=0;
		
		// get the min.
		for(int j=0;j<v-1;j++) {
			int min=Integer.MAX_VALUE,u=0;
            for(int k=0;k<v;k++) {			
            	if(!mst[k] && key[k]<min) {
            		min=key[v];
            		u=k;
            	}
            }
            
            mst[u]=true;
            
            for(Node n:adj.get(u)) {
            	if(!mst[n.val] && n.weight<key[n.val]) {
            		parent[n.val]=u;
            		key[n.val]=n.weight;
            	}
            }
		}
		
		
		for(int i=1;i<v;i++) {
			System.out.println(parent[i]+"_"+i);
		}
		
		
		

	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Node>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Node>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Node>());
		}

		addEdge(adj, 0, 1, 2);
		addEdge(adj, 1, 3, 8);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 0, 3, 6);
		addEdge(adj, 1, 4, 5);
		addEdge(adj, 2, 4, 7);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Node>> adj, int u, int v, int w) {

		adj.get(u).add(new Node(v, w));
		adj.get(v).add(new Node(u, w));

	}

	static class Node implements Comparator<Node> {
		int val;
		int weight;

		Node() {

		}

		Node(int val, int weight) {
			this.val = val;
			this.weight = weight;
		}

		@Override
		public int compare(Node n1, Node n2) {
			if (n1.weight < n2.weight)
				return -1;
			if (n1.weight > n2.weight)
				return 1;
			return 0;
		}
	}
}
