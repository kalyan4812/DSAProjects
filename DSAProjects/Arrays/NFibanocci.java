package Arrays;


public class NFibanocci {

	public static void main(String...strings) {
		int n=3;
		int numcount=8;
		printUsingWindow(n,numcount);
	}

	//o(numcount) +o(num count) space
	private static void printUsingWindow(int n, int numcount) {
		int a[]=new int [numcount];
		for(int i=0;i<n-1;i++) {
			a[i]=0;
			System.out.print(0+" ");
		}
		System.out.print(1+" ");
		a[n-1]=1;
		int sum=1;
		a[n]=1;
		for(int i=n;i<numcount;i++) {
			a[i]=sum;
			System.out.print(a[i]+" ");
			sum=sum+a[i]-a[i-n];
			
		}
		
	}
}
