package Arrays;


public class B9_MinimumFlipsToMakeBinaryArraySame {

	
	public static void main(String...strings) {
		int [] a= {0,0,1,1,0,0,1,1,0,1};
		printMinFlips(a);
		System.out.println();
		printMinFlipsOtherWay(a);
	}

	//one traversal
	private static void printMinFlipsOtherWay(int[] a) {
		for(int i=1; i<a.length;i++) {
			if(a[i]!=a[i-1]) {
				if(a[i]!=a[0]) {
				System.out.print("From "+i+" to ");	
				}
				else {
					System.out.println(i-1);
				}
			}
		}
		if(a[a.length-1]!=a[0]) {
			System.out.println(a.length-1);
		}
		
	}


	//require two traversals t(n)
	private static void printMinFlips(int[] a) {
		int c1=0,c2=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]!=a[i-1]) {
				if(a[i-1]==1) {
					c1++;
				}
				else {
					c2++;
				}
			}
		}
		if(a[a.length-1]==1) {
			c1++;
		}
		else {
			c2++;
		}
		System.out.println("num of one groups : "+c1);
		System.out.println("num of zero groups : "+c2);
		
		if(c1<c2) {
			flipfun(a,1);
		}
		else if(c1>c2) {
			flipfun(a,0);
		}
		else {
			flipfun(a,1);
			// u can flip 0 zero also if c1==c2
		}
		
	}

	private static void flipfun(int[] a, int num) {
		
		for(int i=0;i<a.length;i++) {
			if(i==0 && a[i]==num) {
				System.out.print("From "+i+" to ");
			}
			
			else if(i>0 && a[i]==num && a[i]!=a[i-1]) {
				System.out.print("From "+i+" to ");
			}
			else if(i>0 && i!=a.length-1 && a[i]!=num && a[i]!=a[i-1]) {
				System.out.println(i-1);
			}
			else if(i==a.length-1 && a[i]==num) {
				System.out.println(i);
			}
			else if(i==a.length-1 && a[i]!=num) {
				System.out.println(i-1);
			}
		}
		if(a[a.length-1]==num) {
			System.out.println(a.length-1);
		}
	}
}
