package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A7_DetectCycleInDirectedGraph {

	public static void main(String... strings) {
		ArrayList<ArrayList<Integer>> adj = setUpGraph();

		boolean b = detectUsingDfs(adj, adj.size());
		System.out.println(b);

		boolean d = detectUsingBfs(adj, adj.size());
		System.out.println(d);

	}

//-----------------------------------------BFS APPROACH USING KAHNS ALGORITHM ------------------------------------------------------------
	
	
	// O(V+E)
	private static boolean detectUsingBfs(ArrayList<ArrayList<Integer>> adj, int size) {
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (checkUsingBfs(adj, i, visited)) {
					return true;
				}

			}
		}
		return false;
	}

	private static boolean checkUsingBfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		int V=adj.size();
		
		// array to store in degrees.
		int[] in_degree = new int[V];
      

      
        // add in degrees.
        for (int u = 0; u < V; u++)
        {
            for (int v : adj.get(u)) {
                in_degree[v]++;
            }
        }

       // adding vertices with 0 in degrees into queue.
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
                }
        }

       
        int cnt = 0;

		
        while (!q.isEmpty())
        {

            // Extract front of queue (or perform dequeue)
           
            int u = q.poll();
           
            // Iterate through all its neighboring nodes
            // of dequeued node u and decrease their in-degree
            // by 1
            for (int itr : adj.get(u)) {
            	 in_degree[itr]--;
                if (in_degree[itr] == 0) {
                    q.add(itr);
                }
            }
            cnt++;
        }

		return (cnt!=V);
	}
	
	
	
	
	

//------------------------------------------------------------------ DFS------------------------------------------------------------------
	
	
	// O(v+e) ,O(v+e)-space.
	private static boolean detectUsingDfs(ArrayList<ArrayList<Integer>> adj, int size) {
		boolean visited[] = new boolean[size + 1];
		boolean recst[] = new boolean[size + 1];// Recursion stack;

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (checkUsingDfs(adj, visited, i, recst)) {
					return true;
				}

			}

		}
		return false;

	}

	private static boolean checkUsingDfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, boolean[] recst) {
		visited[s] = true;
		recst[s] = true;

		for (int k : adj.get(s)) {
			if (!visited[k]) {
				if (checkUsingDfs(adj, visited, k, recst)) {
					return true;
				}
			} else if (recst[k]) {
				return true;
			}

		}
		recst[s] = false;
		return false;
	}
	
	
	
	
	
	
	
	

//------------------------------------------------------------------------------------------------------------------------------------------------

	private static ArrayList<ArrayList<Integer>> setUpGraph() {
		int vertices = 4;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 1);

		return adj;
	}

	// t(1)
	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {

		adj.get(u).add(v);

	}
}
