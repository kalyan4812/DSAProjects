package BitManipulation;

public class A1_Basics {

	public static void main(String...strings) {
		int x=3,y=6;
		
		System.out.println("AND OPERATOR : "+ (x&y)); // multiply binary digits.
		System.out.println("OR OPERATOR : "+ (x|y));  // add binary digits.
		System.out.println("XOR OPERATOR : "+ (x^y));  // when digits are different then 1 else 0.
		
		
		//In java negative numbers are represented as (-x)=2^32-x;
		System.out.println("NOT OPERATOR : "+ (~x));
		
		System.out.println("RIGHT SHIFT OPERATOR : "+ (x>>1));  // trick: x>>y== x/2^y.
		
		System.out.println("LEFT SHIFT OPERATOR : "+ (x<<1));  // trick: x<<y==x*2^y.
		
		
	}
}
