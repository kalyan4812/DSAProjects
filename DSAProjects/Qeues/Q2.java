package Qeues;

public class Q2 {

	public static void main(String...strings) {
		int a[]= {25,64,9,4,100};
		int k=4;
		int ans=fun(a,a.length,k);
		
		System.out.println(ans);
	}

	private static int fun(int[] a, int n, int k) {
		
		for(int i=0;i<k;i++) {
			int max=0;
			for(int j=0;j<n;j++) {
				if(a[j]>a[0]) {
				  max=j;
				}
			}
			a[max]=(int)Math.sqrt(a[max]);
		}
		
		int s=0;
		for(int p:a) {
			s+=p;
		}
		
		return s;
	}
}
