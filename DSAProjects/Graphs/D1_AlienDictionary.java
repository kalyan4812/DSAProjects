package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class D1_AlienDictionary {

	// dictionary where alphabets order differ,we have to print in which sorted
	// order alphabets are implemented in dictionary.

	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();

	public static void main(String... strings) {

		String a[] = { "baa", "abcd", "abca", "cab", "cad" };
		for (int i = 0; i < a.length; i++) {
			al.add(new ArrayList<>());
		}

		formAGraph(a, a.length);

		topologicalSortUsingDfs(al);

	}

	private static void formAGraph(String[] a, int n) {

		for (int i = 0; i < n - 1; i++) {
			char c1[] = a[i].toCharArray();
			char c2[] = a[i + 1].toCharArray();
			int min = Math.min(a[i].length(), a[i + 1].length());

			for (int j = 0; j < min; j++) {
				if (c1[j] != c2[j]) {
					al.get(c1[j] - 'a').add(c2[j] - 'a');
					break;
				}
			}

		}

	}

	private static void topologicalSortUsingDfs(ArrayList<ArrayList<Integer>> adj) {
		int size = 4;

		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[size + 1];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				sortUsingDfs(adj, visited, stack, i);
			}
		}
		while (stack.empty() == false) {
			char c = (char) (stack.pop() + 65);
			System.out.print(c + " ");
		}
		System.out.println();
	}

	private static void sortUsingDfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack,
			int s) {
		visited[s] = true;

		for (int k : adj.get(s)) {
			if (!visited[k]) {
				visited[k] = true;
				sortUsingDfs(adj, visited, stack, k);
			}
		}
		stack.push(s);
	}
}
