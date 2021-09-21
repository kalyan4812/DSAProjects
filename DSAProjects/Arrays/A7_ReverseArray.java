package Arrays;


public class A7_ReverseArray {

	
	public static void main(String...strings) {
		int a[]= {1,2,3,3,5,5,6,7};
		reverseArray(a);
		
		for(int i:a) {
			System.out.print(i+"  ");
		}
	}
	
	
	//time complexity is t(n/2).

	private static void reverseArray(int[] a) {
		for(int i=0;i<(a.length/2);i++) {
			
			int temp=a[i];
			a[i]=a[a.length-1-i];
			a[a.length-1-i]=temp;
			
		}
		
	}

	
}
