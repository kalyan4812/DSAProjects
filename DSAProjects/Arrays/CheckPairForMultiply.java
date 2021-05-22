package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class CheckPairForMultiply {

	public static void main(String... strings) {
		int a[] = { 4, 1, 3, 10, 5, 7, 8 };
		int val = 15;
		check(a, a.length, val);
		
		System.out.println();

		int b[] = { 5, 1, 3, 4, 15, 7 };
		checkBySorting(b, b.length, val);
		
		System.out.println();

		int c[] = { -5, 1, -3, 4, 15, 7 };
		checkByHashing(c, c.length, val);
		
		
		
	}

	//O(n) ,O(n) space
	private static void checkByHashing(int[] c, int n, int val) {
		HashSet<Integer> h=new HashSet<>();
		for(int num:c) {
			if(h.contains(val/num)) {
				System.out.println(val/num +" "+num);
			}
			else {
				h.add(num);
			}
		}
		
	}

	//only for +ve numbers O(nlogn)
	private static void checkBySorting(int[] a, int n, int val) {
		
		Arrays.sort(a);
		int s = 0, e = n - 1;
		while (s <= e) {
          if(a[s]*a[e]==val) {
        	
        	
        	System.out.println(a[s]+" "+a[e]);
        	  e--;
        	  s++;
          }
          else if(a[s]*a[e]>val) {
        	  e--;
          }
          else {
        	  s++;
          }
		}

	}

	// O(n2)
	private static void check(int[] a, int n, int val) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] * a[j] == val) {
					System.out.println(a[i] + " " + a[j]);
				}
			}
		}

	}
}
