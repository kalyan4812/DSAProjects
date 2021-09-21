package Sorting;

import java.util.HashSet;

public class B3_IntersectionOfSortedArrays {

	public static void main(String... strings) {
		int a[] = { 2, 5, 8, 13, 15 };
		int b[] = { 1, 3, 8, 15, 18, 20, 25 };
		intersectionFun(a, b, a.length, b.length);
		System.out.println();

		intersectionFunUsingMergeFunction(a, b, a.length, b.length);
		System.out.println();

		intersectionBruteForce(a, b, a.length, b.length);
		System.out.println();
		
		
		intersectionUsingMap(a, b, a.length, b.length);
		System.out.println();
	}

	
	//O(m+n),O(m)-space.
	private static void intersectionUsingMap(int[] a, int[] b, int m, int n) {
		
		HashSet<Integer> hs=new HashSet<>(m);	
		
		for(int i=0;i<m;i++) {
			hs.add(a[i]);
		}
		
		for(int j=0;j<n;j++) {
			if(hs.contains(b[j])) {
				System.out.print(b[j]+" ");
				hs.remove(b[j]);
			}
		}
		
	}


	//O((m+n)*m)
	private static void intersectionBruteForce(int[] a, int[] b, int m, int n) {

		for (int i = 0; i < m; i++) {
			boolean visited = false;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] == a[i]) {
					visited = true;
					break;
				}
			}

			if (visited)
				continue;

			for (int k = 0; k < n; k++) {
				if (b[k] == a[i]) {
					System.out.print(a[i] + " ");
					break;
				}
			}
		}

	}

	// O(m+n)
	private static void intersectionFunUsingMergeFunction(int[] a, int[] b, int m, int n) {
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				System.out.print(a[i] + " ");
				i++;
				j++;
			}
		}

	}

	// O(m*n)
	private static void intersectionFun(int[] a, int[] b, int m, int n) {

		for (int i = 0; i < m; i++) {
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}
			for (int j = 0; j < n; j++) {
				if (a[i] == b[j]) {
					System.out.print(a[i] + " ");
				}
			}
		}
	}
}
