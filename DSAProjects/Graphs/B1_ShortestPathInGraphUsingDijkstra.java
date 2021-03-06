package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import Graphs.A9_ShortestPathInDAG.Node;

public class B1_ShortestPathInGraphUsingDijkstra {
	// it will work for both directed and undirected.
	public static void main(String... strings) {

		ArrayList<ArrayList<Node>> adj = setUpGraph();
		
		shortestPath(adj, adj.size(), 0); // using priority queue.
		System.out.println();
		
		shortestPathUsingSet(adj,adj.size(),0);  // using tree set.
		
		
		
		System.out.println();
		
		shortestPathOtherWay(adj,adj.size(),0);

	}
	

	//O(Vlogv+Elogv)=O(Elogv)
	private static void shortestPathUsingSet(ArrayList<ArrayList<Node>> adj, int v, int s) {
		
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		
		TreeSet<Node> ts=new TreeSet<>(new Node());
		ts.add(new Node(0,0));
		
		while(!ts.isEmpty()) {
			Node curr=ts.pollFirst();
			for (Node k : adj.get(curr.val)) {
				if (dist[curr.val] + k.weight < dist[k.val]) {
				
					
					dist[k.val] = dist[curr.val] + k.weight;
					
					ts.add(new Node(k.val, dist[k.val]));
				}
			}
		}
		

		for (int k : dist) {
			if (k == Integer.MAX_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(k + " ");
			}
		}
		
		
	}

	//O((V+E)logV)+O(V) ,O(V)-space.
	private static void shortestPath(ArrayList<ArrayList<Node>> adj, int v, int s) {

		int dist[] = new int[v];

		for (int i = 0; i < v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>(v, new Node());
		pq.add(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			for (Node k : adj.get(curr.val)) {
				if (dist[curr.val] + k.weight < dist[k.val]) {
				
					
					dist[k.val] = dist[curr.val] + k.weight;
					
					pq.add(new Node(k.val, dist[k.val]));
				}
			}
		}

		for (int k : dist) {
			if (k == Integer.MAX_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(k + " ");
			}
		}
	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static void shortestPathOtherWay(ArrayList<ArrayList<Node>> adj, int vtces, int src) {
		
		
		boolean vis[]=new boolean[vtces];
	      PriorityQueue<Pair> pq=new PriorityQueue<>((c,d)->(c.wsf-d.wsf));
	      pq.add(new Pair(src,0,0,""+src));
	      
	      while(!pq.isEmpty()){
	        Pair p=pq.poll();
	        if(vis[p.v]){
	            continue;
	        }
	        vis[p.v]=true;
	        System.out.println(p.v+" via "+p.psf+" @ "+p.wsf);
	         for(Node e:adj.get(p.v)){
	             if(!vis[e.val]){
	                 pq.add(new Pair(e.val,e.weight,p.wsf+e.weight,p.psf+e.val));
	             }
	         }   
	          
	      }
	}
	
	
	
	static class Pair{
	       int v,wt,wsf;
	       String psf;
	       Pair(int v,int wt,int wsf,String psf){
	           this.v=v;
	           this.wt=wt;
	           this.psf=psf;
	           this.wsf=wsf;
	       }
	   }
	
	
	
//----------------------------------------------------------------------------------------------------------------------------	
	
	private static ArrayList<ArrayList<Node>> setUpGraph() {
		int vertices = 4;

		ArrayList<ArrayList<Node>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Node>());
		}

		addEdge(adj, 0, 1, 5);
		addEdge(adj, 1, 3, 20);
		addEdge(adj, 0, 2, 10);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 2, 3, 2);

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
///---------------------------------------------------------------------------------------------------------------------------------------------------------------	
	/* Tem=time to extract minimum.
	 * Ti=time to add element.
	 * Tdk-decrease key operation.
	 * 
	 * 
	    Data structure	Tem	Ti	Tdk	General-time complexity	Time complexity
                                                                                   for m ??? O(n)
                  Array	O(n)	O(1)	O(1)	O(n?? + m)	O(n??)
                  
         PriorityQueue	O(log n)	O(log n)	O(n)	O(n ?? log n + m ?? n)	O(n??)
         
             TreeSet	O(log n)	O(log n)	O(log n)	O(n ?? log n + m ?? log n)	O(n ?? log n)
             
       FibonacciHeap	O(log n)	O(1)	O(1)	O(n ?? log n + m)	O(n ?? log n)

	    
	    
	    
	 */
}
