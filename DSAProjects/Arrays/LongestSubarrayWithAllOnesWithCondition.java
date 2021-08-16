package Arrays;

public class LongestSubarrayWithAllOnesWithCondition {
	
	//at max you can replace k 0s with 1s
	public static void main(String...strings) {
		int [] a= {0,1,0,1,0,1,1,1,0};
		int k=2;
		fun(a,a.length,k);
	}

	private static void fun(int[] a, int n,int k) {
		int s=0,e=0,max=0,numofzero=0;
		int fs=0,fe=0;
		
		while(e<n) {
			if(a[e]==0) {
				numofzero++;
				
			}
			if(numofzero>k) {
				if(a[e]==0) {
					numofzero--;
				}
				s++;
			}
			if(max<e-s+1) {
				max=e-s+1;
				fe=e;
				fs=s;
			}
			
			e++;
		
		}
		System.out.println(max);
		System.out.println("start : "+fs +" end : "+fe);
	}
}
