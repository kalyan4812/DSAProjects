package Arrays;

import java.util.Scanner;

public class A2_SearchItem {

	

	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number to find");
		try {
		Integer i=sc.nextInt();
		int a[]= {1,2,3,4,5,8,9};
		A2_SearchItem s=new A2_SearchItem();
		
		System.out.print(s.find(i, a));
		sc.close();
		}
		catch(Exception e) {
			System.out.print("Only number should be given as input");
		}
		
		
	}
	
	public int find(int num,int a[]) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==num) {
				return i;
			}
		}
		return -1;
	}
}
