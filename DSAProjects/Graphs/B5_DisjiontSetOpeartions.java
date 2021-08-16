package Graphs;

public class B5_DisjiontSetOpeartions {

	static int parent[]=new int[10000];
	static int rank[]=new int[10000];
	public static void main(String...strings) {
		
		makeSet(6);
		
		// if both nodes have same parent then they are in same component.
	}
	private static void makeSet(int n) {
		
		for(int i=1;i<=n;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		
	}
	
	//O(4k)
	static int findParent(int node) {
		if(node==parent[node]) {
			return node;
		}
		
		return parent[node]=findParent(parent[node]);
	}
	
	static void union(int u,int v) {
		u=findParent(u);
		v=findParent(v);
		
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
}
