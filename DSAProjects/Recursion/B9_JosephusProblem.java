package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class B9_JosephusProblem {
	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int k = sc.nextInt();

		int p = fun(s, k);
		System.out.println(p);

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= s; i++) {
			ans.add(i);
		}
		int ind = 0;
		int r = fun2(k, ans, ind);
		System.out.println(r);
		
		
		int l = fun3(s,k);
		System.out.println(l);

		sc.close();

	}

	
	//O(N),t(n)-stack space.
	private static int fun3(int n,int k) { // after killing indexs will be incremennted by k
		if(n==1) return n;
		return (fun3(n-1,k)+k-1)%n+1;
		
	}

	// O(N),t(N)
	private static int fun2(int k, ArrayList<Integer> ans, int ind) {
		if (ans.size() == 1) {
			return ans.get(0);
		}
		ind = (ind + k - 1) % ans.size();
		ans.remove(ind);
		return fun2(k, ans, ind);

	}

	// O(N),t(N)
	private static int fun(int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		ans.clear();
		for (int i = 1; i <= n; i++) {
			ans.add(i);
		}
		int ind = 0;
		while (ans.size() > 1) {
			ind = (ind + k - 1) % ans.size();
			ans.remove(ind);
		}

		return ans.get(0);

	}

}
