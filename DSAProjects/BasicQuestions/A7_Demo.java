package BasicQuestions;

public class A7_Demo {

	static int mod=(int)Math.pow(10, 9)+7;
	public static void main(String...strings) {
		String s="ac?b?c";
		
		long ans= fun(s);
		System.out.println(ans);
	}
	private static long fun(String s) {
		int la=0,ra=0,lc=0,rc=0,lq=0,rq=0;
		
		for(char c:s.toCharArray()) {
			if(c=='a') {
				ra++;
			}
			if(c=='?') {
				rq++;
			}
			if(c=='c') {
				rc++;
			}
		}
		
		long ans=0;
		int n=s.length();
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
			if(c=='a') {
				ra--;
			}
			if(c=='?') {
				rq--;
			}
			if(c=='c') {
				rc--;
			}
			
			if(c=='b' || c=='?') {
				// lq+rq available question marks.
				 ans+=((la*rc)%mod )*((long)Math.pow(3,lq+rq)%mod);
				 if(lq!=0) {
					 ans+=((lq*rc)%mod )*((long)Math.pow(3,lq+rq-1)%mod);
				 }
				 if(rq!=0) {
					 ans+=((la*rq)%mod )*((long)Math.pow(3,lq+rq-1)%mod);
				 }
				 
				 if(rq!=0 && lq!=0) {
					 ans+=((lq*rq)%mod )*((long)Math.pow(3,lq+rq-2)%mod); 
				 }
			}
			ans=ans%mod;
			if(c=='a') {
				la++;
			}
			if(c=='?') {
				lq++;
			}
			if(c=='c') {
				lc++;
			}
			
		}
		
		return ans;
	}
}
