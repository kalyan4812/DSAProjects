package Arrays;

import java.util.Scanner;

public class A4_LargestValue {
	
	public static void main(String...strings) {
		int a[]=new int [6];
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<a.length;i++) {
			System.out.println("enter value for"+ i+ "th element");
			a[i]=sc.nextInt();
		}
		
		int max= findMax(a);
		System.out.println(max);
		
	}

	private static  int findMax(int[] a) {
	int max=a[0];
	for(int i:a) {
		if(i>max) {
			max=i;
		}
	}
		return max;
	}

}
