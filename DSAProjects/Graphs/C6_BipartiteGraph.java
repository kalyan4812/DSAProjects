package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C6_BipartiteGraph {

	// the graph that can be colored using two colors such that adjacent nodes have
	// different color.

	// idea: graph which does not have odd length cycle.

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		boolean b = checkBipartiteUsingBfs(adj, 4);
		System.out.println(b);

		boolean k = checkBipartiteUsingDfs(adj, 4);
		System.out.println(k);
		
		
		boolean c = checkBipartiteUsingBfsOtherWay(adj, 4);
		System.out.println(k);

	}
//-------------------------------------------------------DFS APPROACH------------------------------------------
	//O(V+E)
	private static boolean checkBipartiteUsingDfs(ArrayList<ArrayList<Integer>> adj, int size) {
		int color[] = new int[size];
		Arrays.fill(color, -1);

		for (int i = 0; i < size; i++) {
			if (color[i] == -1) {
				boolean b = dfsTraversal(adj, i, color);

				if (!b) {

					return false;
				}

			}
		}
		return true;
	}

	private static boolean dfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, int[] color) {
		if (color[s] == -1)
			color[s] = 1;

		for (int k : adj.get(s)) {
			if (color[k] == -1) {
				color[k] = 1 - color[s];
				if (!dfsTraversal(adj, k, color)) {
					return false;
				}
			} else if (color[k] == color[s]) {

				return false;
			}
		}
		return true;
	}

//--------------------------------------------------------------------BFS APPROACH---------------------------------------------------------------	
	// O(v+E)
	private static boolean checkBipartiteUsingBfs(ArrayList<ArrayList<Integer>> adj, int size) {

		int color[] = new int[size];
		Arrays.fill(color, -1);

		for (int i = 0; i < size; i++) {
			if (color[i] == -1) {
				boolean b = bfsTraversal(adj, i, color);

				if (!b) {

					return false;
				}

			}
		}
		return true;
	}

	private static boolean bfsTraversal(ArrayList<ArrayList<Integer>> adj, int s, int[] color) {

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		color[s] = 1;

		while (!q.isEmpty()) {
			int u = q.poll();

			for (int k : adj.get(u)) {
				if (color[k] == -1) {
					color[k] = 1 - color[u];
					q.add(k);
				} else if (color[k] == color[u]) {

					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
//------------------------------------other approach--------------------------------------------------	
	
	// the actual defination of bipartite is ,if we can divide vertices of graph into two mutually exclusive
   // that is no common elements between the sets and all edges are cross i.e form set1 to set2.
	
	 // normal graph without cycle is bipartite.
	// if graph has even length cycle it is bipartite.
   // if graph has odd length cycle it is not bipartite.
	
	// if there is even length cycle,the node which gets visited twice in a cycle will be on the same level.
	
	
	
	
	static class Pair{
	       int v, lev;
	       Pair(int v,int lev){
	           this.lev=lev;
	           this.v=v;
	       }
	}
	private static boolean checkBipartiteUsingBfsOtherWay(ArrayList<ArrayList<Integer>> adj, int vtces) {	
	 int vis[]=new int[vtces];
     Arrays.fill(vis,-1);
     boolean flag=true;
     for(int i=0;i<vtces;i++){
         if(vis[i]==-1){
             boolean x=check(adj,vis,i,0);
             if(!x){
                 flag=false;
                 break;
             }
         }
     }
     
     return flag;
     
  }
  
  
  public static boolean check(ArrayList<ArrayList<Integer>> adj,int vis[],int s,int lev){
      Queue<Pair> q=new LinkedList<>();
      q.add(new Pair(s,lev));
      
      
      while(!q.isEmpty()){
          Pair p=q.poll();
          if(vis[p.v]!=-1){
              if(vis[p.v]!=p.lev){
                  return false;
              }
          }
          
          vis[p.v]=p.lev;
          
          for(int e:adj.get(p.v)){
              if(vis[e]==-1){
                  q.add(new Pair(e,p.lev+1));
              }
          }
      }
      
      return true;
      
      
  }
  

	
//-----------------------------------------------------------------------------------------------------
	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 4;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 3);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
