package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class B8_ArticulationPoint { // or cut vertices.

	// point/ node if we remove them the graph will be broken into two/more
	// components.

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		articulationPoint(adj, 5);

	}

	
	//O(V+E),O(V+E)
	private static void articulationPoint(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean visited[] = new boolean[v + 1];
		int dis[] = new int[v + 1];
		int low[] = new int[v + 1];
		int isArt[] = new int[v];

		int timer = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(i, -1, visited, dis, low, adj, timer, isArt);
			}
		}
		
		for(int i=0;i<v;i++) {
			if(isArt[i]==1) {
				System.out.println(i);
			}
		}

	}

	private static void dfs(int s, int parent, boolean[] visited, int[] dis, int[] low, ArrayList<ArrayList<Integer>> adj,int timer, int[] isArt) {
		visited[s]=true;
		dis[s]=low[s]=timer++;
		int child=0;
		for(int k:adj.get(s)){
			if(k==parent) {
				continue;
			}
			if(!visited[k]) {
				dfs(k,s,visited,dis,low,adj,timer,isArt);
				low[s]=Math.min(low[s],low[k]);
				if(low[k]>=dis[s] && parent!=-1) {
					isArt[s]=1;
				}
				child++;
			}
			else {
				low[s]=Math.min(low[s],dis[k]);
			}
		}
		if(parent==-1 && child>1) {
			isArt[s]=1;
		}

	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 5;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 0);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 1, 2);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);
		adj.get(v).add(u);

	}
}
