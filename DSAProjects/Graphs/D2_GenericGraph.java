package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class D2_GenericGraph<T> {

	HashMap<T, ArrayList<T>> adj; // for wieghted graph ,just change ArrayList<Pair<T,Integer>> ..
	
	// note here ,the advatnage of using hahmap over arraylist is if you use arraylist,you have to add the vertices which are
	// not in the graph,like in the setupgraph form 0 to vertices-1,we have to add in arraylist.
	
	/*
	int vertices = 4;

	ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

	for (int i = 0; i < vertices; i++) {
		adj.add(new ArrayList<Integer>());
	}
	     addEdge(adj, 0, 1); 
		 addEdge(adj, 0, 2);
		 addEdge(adj, 1, 2);
		 addEdge(adj, 1, 3);
		 
		 
		 In the above ,space wastage for 2,3 vertices.
	*/

	
	// you can also use ,hashmap of hashmaps ,to get whether nodex is connected to nodey in t(1).
	
	
	D2_GenericGraph() {
		adj = new HashMap<>();

	}

	public static void main(String... strings) {
		D2_GenericGraph<Integer> g1 = new D2_GenericGraph<>();
		D2_GenericGraph<String> g2 = new D2_GenericGraph<>();

		g1.addEdge(1, 2);
		g1.addEdge(3, 2);
		g1.addEdge(4, 2);
		g1.addEdge(1, 4);
		g1.addEdge(1, 3);

		g1.print();
		
		
		
		
		
		g2.addBiEdge("a", "b");
		g2.addBiEdge("a", "c");
		g2.addBiEdge("c", "d");
		g2.addBiEdge("e", "f");
		g2.addBiEdge("a", "f");
		

		g2.print();
		
		
		

	}

	void addEdge(T n1, T n2) {

		if (adj.containsKey(n1)) {
			adj.get(n1).add(n2);
		} else {
			ArrayList<T> al = new ArrayList<>();
			al.add(n2);
			adj.put(n1, al);
		}

	}

	void addBiEdge(T n1, T n2) {

		if (adj.containsKey(n1)) {
			adj.get(n1).add(n2);
		} else {
			ArrayList<T> al = new ArrayList<>();
			al.add(n2);
			adj.put(n1, al);
		}

		if (adj.containsKey(n2)) {
			adj.get(n2).add(n1);
		} else {
			ArrayList<T> al = new ArrayList<>();
			al.add(n1);
			adj.put(n2, al);
		}

	}

	void print() {
		for (T t : adj.keySet()) {
			System.out.print(t + "---> ");

			for (T k : adj.get(t)) {

				System.out.print(k + " ");

			}
			System.out.println();

		}
		System.out.println();
	}

}
