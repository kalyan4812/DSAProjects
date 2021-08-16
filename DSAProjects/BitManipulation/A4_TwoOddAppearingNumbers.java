package BitManipulation;

public class A4_TwoOddAppearingNumbers {

	public static void main(String...strings) {
		int a[]= {20,15,20,16};
		fun(a);
	}

	
	//O(N)
	private static void fun(int[] a) {
		int res=0;
		for(int k:a) {
			res=res^k;
		}
		// now here res=x^y, and we know xor gives only if bits differ in both x ,y,so find first set bit in res which means bit where both x ,y differs.
		
		int setbit=res&(~(res-1)); // get right most set bit.
		//int setbit=res&(-res); // other way.
		int x=0,y=0;
		for(int i=0;i<a.length;i++) {
			if((a[i]&setbit)!=0) {
				x=x^a[i];
			}
			else {
				y=y^a[i];
			}
		}
		
		System.out.println(x+"  "+y);
	}
}
