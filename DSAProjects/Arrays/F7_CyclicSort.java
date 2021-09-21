package Arrays;

public class F7_CyclicSort {

	//sort the elements from x to y continous.
	public static void main(String...strings) {
		int [] a= {13,14,16,12,11,15};
		fun(a,a.length);
	}

	//O(N)
	private static void fun(int[] a, int n) {
		int min=Integer.MAX_VALUE;
		for(int k:a) {
			min=Math.min(k, min);
		}
		System.out.println(min+" ");
		int i=0;
		while(i<n) {
			if(a[i]!=i+min) {
				int index=a[i]-min;
				if(a[i]!=a[index]) {
				int temp=a[i];
				a[i]=a[index];
				a[index]=temp;
				}
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		
		for(int s:a) {
			System.out.print(s+" ");
		}
	}
}
