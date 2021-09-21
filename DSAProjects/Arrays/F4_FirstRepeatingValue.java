package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class F4_FirstRepeatingValue {

	public static void main(String...strings) {
		int a[]= {2,3,4,4,5,3,7};
		fun(a);
		fun2(a);
	}
	
	
	//O(n),O(n)-space

	private static void fun2(int[] arr) {
		int max = 0;
		int n=arr.length;
        for (int x = 0; x < n; x++) {
            if (arr[x] > max) {
                max = arr[x];
            }
        }
        int temp[]
            = new int[max + 1]; // the idea is to use
                                // temporary array as hashmap
        Arrays.fill(temp, 0);
 
        for (int x = 0; x < n; x++) {
            int num = arr[x];
            temp[num]++;
        }
 
        for (int x = 0; x < n; x++) {
            int num = arr[x];
            if (temp[num] > 1) {
               System.out.print(arr[x]);
               break;
            }
        }
		
	}

	//O(n),O(n)-space
	// to get last repeating vaue break the loop hen u find match in hashset.
	private static void fun(int[] a) {
		int n=a.length;
		HashSet<Integer> h=new HashSet<>();
		int repeatvalue=0;
		for(int i=n-1;i>=0;i--) {
			if(h.contains(a[i])) {
				repeatvalue=a[i];
			}
			else {
				h.add(a[i]);
			}
		}
		
		System.out.println(repeatvalue);
	}
}
