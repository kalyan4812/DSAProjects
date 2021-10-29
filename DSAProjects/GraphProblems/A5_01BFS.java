package GraphProblems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class A5_01BFS {
	// 0-1 BFS.

	
	// given a directed graph,find cost to reach from src to dest,each reverse of edge costs 1 unit.
	public static void main(String[] args) {
	/*	Input
	    7 7
		1 2 
		3 2
		3 4
		7 4
		6 2
		5 6
		7 5
		
		*/
		Scanner sc = new Scanner(System.in);
		String parts[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);

		ArrayList<ArrayList<Pair>> al = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<>());
		}

		while (m > 0) {
			parts = sc.nextLine().split(" ");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);

			al.get(a).add(new Pair(b, 0));
			al.get(b).add(new Pair(a, 1));
			m--;
		}

		int src = 1, dest = n;

		Deque<Pair> dq = new LinkedList<>();
		boolean vis[] = new boolean[n + 1];
		dq.add(new Pair(src, 0));

		int ans = -1;
		while (!dq.isEmpty()) {

			Pair p = dq.pollFirst();

			if (p.v == n) {
				ans = p.wt;
				break;
			}
			if (vis[p.v]) {
				continue;
			}
			vis[p.v] = true;
			for (Pair k : al.get(p.v)) {

				if (!vis[k.v]) {
					if (k.wt == 0) {
						dq.addFirst(new Pair(k.v, p.wt));

					} else {
						dq.addLast(new Pair(k.v, p.wt + 1));

					}
				}
			}

		}

		System.out.println(ans);

	}

	static class Pair {
		int v, wt;

		Pair(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}
	}

}
