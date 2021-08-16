package Arrays;

import java.util.Scanner;

public class DeleteItem {

	
	public static void main(String... args) {
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int a[]= {1,2,3,4,5,6};
		boolean b=delete(a,i);
		if(b) {
			for(int s: a) {
				System.out.print(s+" ");
			}
		}
		else {
			System.out.print("Item not found");
		}
		sc.close();
	}

	private static boolean delete(int[] a, int item) {
		
		for(int i=0;i<a.length;i++) {
			if(a[i]==item) {
				if(i==a.length-1) {
					a[i]=Integer.MAX_VALUE;
					return true;
				}
				for(int x=i;x<a.length-1;x++) {
					a[x]=a[x+1];
				
				}
				return true;
			}
		}
		return false;
	}
}
// time complexity O(n) for delete at specific position
// delete at end O(1) if we know earlier