package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import Graphs.B4_MSTUsingPrimsAlgorithm.Node;

public class B6_MSTUsingKruskalsAlgorithm {

	//O(ElogE)+O(E*4k)

	public static void main(String... strings) {

		ArrayList<Node> adj = setUpGraph();

		kruskalsAlgo(adj,5);

	}

	private static void kruskalsAlgo(ArrayList<Node> adj, int v) {
		Collections.sort(adj,new Node()); // sort edges according to weight.
		
		int parent[]=new int[v];
		int rank[]=new int[v];
		for(int i=0;i<v;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		
		int costMst=0;
		ArrayList<Node> mst=new ArrayList<>();
		
		for(Node n:adj) {
			if(findParent(n.u,parent)!=findParent(n.v,parent)) {
				costMst=costMst+n.weight;
				mst.add(n);
				union(n.u,n.v,parent,rank);
				
			}
		}
		System.out.println(costMst);
		
		for(Node n:mst) {
			System.out.println(n.u+"_"+n.v);
		}
		
		
	}
	
	//O(4k)
	static int findParent(int node,int [] parent) {
		if(node==parent[node]) {
			return node;
		}
		
		return parent[node]=findParent(parent[node],parent);
	}
	
	static void union(int u,int v,int [] parent,int [] rank) {
		u=findParent(u,parent);
		v=findParent(v,parent);
		
		if(rank[u]<rank[v]) {
			parent[u]=v;
		}
		else if(rank[u]>rank[v]) {
			parent[v]=u;
		}
		else {
			parent[v]=u;
			rank[u]++;
		}
	}
	
	

	

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<Node> setUpGraph() {
		int vertices = 5;

		ArrayList<Node> adj = new ArrayList<>(vertices); // edge list no need of adj list.

		
		addEdge(adj, 0, 1, 6);
		addEdge(adj, 1, 3, 8);
		addEdge(adj, 0, 2, 5);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 2, 3, 7);
		addEdge(adj, 2, 4, 12);
		addEdge(adj, 3, 4, 10);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<Node> adj, int u, int v, int w) {

		adj.add(new Node(u,v, w));
		

	}

	static class Node implements Comparator<Node> {
		int u;
		int v;
		int weight;

		Node() {

		}

		Node(int u,int val, int weight) {
			this.u=u;
			this.v = val;
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
