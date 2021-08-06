package BitManipulation;

public class B5_CopySetBitsInRange {

	public static void main(String...strings) {
		int a=5;
		int b=9;
		
		int l=3,r=6;
		copy(a,b,l,r);
	}

	private static void copy(int a, int b, int l, int r) {
	
		int len=r-l+1;// length of range.
		int m=1;
		m=1<<len;
		m=m-1;
		m=m<<(l-1);
		m=m&a;
		
		b=b|m;
		
		System.out.println(m);
		
	}
}
