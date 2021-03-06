package BitManipulation;

public class A9_ReduceNumberTo1 {

	public static void main(String...strings) {
		// if n is even you can do n/2.
		// if n is odd you can do n+1 or n-1.
		// find  minimum no of operations.
		int n=15;
		minOperations(n);
		System.out.println(fun(n));
	}

	private static int fun(int n) {
		if(n==1) {
			return 0;
		}
		if(n%2==0) {
			return 1+fun(n/2);
		}
		
		return 1+Math.min(fun(n+1), fun(n-1));
		
	}

	private static void minOperations(int n) {
	   int res=0;
	   while(n!=1) {
		   if((n&1)==0) {
			   n=n/2;
		   }
		   else if(n==3) {
			   n=n-1;
		   }
		   else if((n&3)==1) { // same as n%4==1
			   n=n-1;
		   }
		   else if((n&3)==3) { // same as n%4==3
			   n=n+1;
		   }
		   res++;
	   }
	   
	   System.out.println(res);
	}
	
	
	
	
	
}
