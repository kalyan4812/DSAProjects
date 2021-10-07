package Arrays;

public class G1_FirstMissingPositiveNumber {

	
	public static void main(String...strings) {
		
		int a[]= {0,1,2};
		int ans=fun(a,a.length);
		System.out.println(ans);
	}

	private static int fun(int[] a, int n) {
		
		boolean hasOne=false;
		for(int i:a) {
			if(i==1) {
				hasOne=true;
			}
		}
		if(!hasOne) {
			return 1;
		}
		
		for(int i=0;i<n;i++) {
			if(a[i]<=0 || a[i]>n) {
				a[i]=1;
			}
		}
		
		for(int i=0;i<n;i++) {
			int k=Math.abs(a[i]);
			if(k==n) {
				a[0]=-Math.abs(a[0]);
			}
			else {
				a[k]=-Math.abs(a[k]);
			}
		}
		
		for(int i=1;i<n;i++) {
		  if(a[i]>0) {	
			  return i;
		  }
		}
		
		if(a[0]>0) {
			return n;
		}
		
		return n+1;
	}
}
