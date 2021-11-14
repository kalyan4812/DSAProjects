package Samples;

import java.util.ArrayList;
import java.util.HashMap;

public class A1_FindPaairs {

	// i<j ,a[i]==a[j], i*j/x;
	public static void main(String... strings) {

		int a[] = { 2, 3, 4, 3, 3, 2, 3, 3 };
		int x = 2;

		int ans = fun(a, a.length, x);
		System.out.println(ans);
		
		
		int ans2 = fun2(a, a.length, x);
		System.out.println(ans2);

	}

	
	private static int fun2(int[] a, int length, int x) {
		// TODO Auto-generated method stub
		return 0;
	}


	private static int fun(int[] a, int n, int x) {
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (hm.containsKey(a[i])) {
				hm.get(a[i]).add(i + 1);
			} else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i + 1);
				hm.put(a[i], al);
			}
		}
		int count = 0;

		for (int k : hm.keySet()) {
			ArrayList<Integer> al = hm.get(k);

			for (int i = 0; i < al.size(); i++) {
				for (int j = i + 1; j < al.size(); j++) {
					if ((al.get(i) * al.get(j)) % x == 0) {
						count++;
					}

				}
			}

		}

		return count;

	}

	
}
