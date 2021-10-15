package BasicQuestions;

public class A5_GCD_LCM {

	public static void main(String...strings) {
		
		int a=10;
		
		int b=16;
		
		int ans=gcd(a,b);
		System.out.println(ans);
		
		
		int ans2=gcd2(a,b);
		System.out.println(ans2);
		
		
		int ans3=lcm(a,b);
		System.out.println(ans3);
	}

	private static int lcm(int a, int b) {
		
		return a*b/gcd(a,b);
	}

	private static int gcd2(int a, int b) {
	    if(b==0) {
	    	return a;
	    }
		return gcd2(b,a%b);
	}

	private static int gcd(int a, int b) {
		
		while(a%b!=0) {
		  int rem=a%b;
		  
		  a=b;
		  b=rem;
		  
		}
		
		return b;
	}
}
