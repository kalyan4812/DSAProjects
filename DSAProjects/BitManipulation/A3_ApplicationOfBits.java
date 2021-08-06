package BitManipulation;

public class A3_ApplicationOfBits {

	public static void main(String...strings) {
		
		int a[]= {2,1,2,5,6,5,7,7,6};
		findOneTimeOccuringNumber(a);
		
		
		int x=5,y=3;
		swap(x,y);
		
		
		int m=5;
		print_XOR_Upto_M(m);
		
		
		int l=2,r=4;
		print_XOR_Between_LandR(l,r);
		
		
		int s=4;
		checkSisEven(s);
		
		
		int r1=13,k=2;
		checkIfKthBitIsSet(r1,k);
		
		int w=8,h=2;
		setIthBitOfNumber(w,h);
		
		int e=8,i=4;
		clearIthBit(e,i);
		
		
		removeLastSetBit(13);
		
		checkIfNumberIsPowerOf2(16);
		
		countNumberOfSetBits(14);
		
		/*
		 *  7n/8=8n-8/8=((n<<3)-n)>>3;
		 */
		
		
		// for A<=B<=C, A^B<=A^C or B^C<=A^C.
	}

	
	
	
	
	
	private static void countNumberOfSetBits(int n) {
	
		//METHOD 1: O(no of bits)
		
		int count=0;
		while(n!=0) {
			if((n&1)==1) {
				count++;
			}
			n=n>>1;
		}
		System.out.println(count);
		
		
		//METHOD 2:o(no of set bits)
		n=14;
		
		int res=0;
		while(n>0) {
			n=(n&(n-1));// remove last set bit.
			res++;
		}
		System.out.println(res);
		
		//or
		 res=0;
		 n=14;
		while(n!=0) {
			n=n-(n&(-n));// right most set bit rsb.
			
			res++;
		}
		System.out.println(res);
		
	}






	//O(1)
	private static void checkIfNumberIsPowerOf2(int n) {
	
		if((n&(n-1))==0) {
			System.out.println(n+" is power of 2");
		}
		else {
			System.out.println(n+" is not  power of 2");
		}
		
		
	}






	//O(1)
	private static void removeLastSetBit(int n) {
		
		System.out.println(n&(n-1));
	}







	private static void clearIthBit(int n, int k) {
		int mask=~(1<<(k-1));
		System.out.println(n&mask);
		
	}







	private static void setIthBitOfNumber(int n, int k) {
	
		int mask=1<<(k-1);
		
		System.out.println(n|mask);
		
	}







	private static void checkIfKthBitIsSet(int n, int k) {
		
		// n=13: 1101
		if((n&(1<<(k-1)))==0) {
			System.out.println(k+" th bit of "+n +" was not set");
		}
		else {
			System.out.println(k+" th bit of "+n +" was  set");
		}
		
	}






	private static void checkSisEven(int n) {
		
		// & operator is faster than modulo operator.
		if((n&1)==0) {
			System.out.println(n+" is even");
		}
		else {
			System.out.println(n+" is odd");
		}
		
	}






	//O(1)
	private static void print_XOR_Between_LandR(int l, int r) {
		int a=print_XOR_Upto_M(l-1);
		int b=print_XOR_Upto_M(r);
		System.out.println(a^b);
	}






	//O(1)
	private static int  print_XOR_Upto_M(int m) {
	
		/*
		   n      ans
		   --     ---
		   1      1
		   
		   2      3
		   
		   3      0
		   
		   4      4
		   
		   5      1 
		   
		   6       7
		   
		   7       0
		   
		   8       8
		   
		 */
		
		if(m%4==0) {System.out.println(m); return m; }
		else if(m%4==1) { System.out.println(1); return 1;}
		else if(m%4==2) {System.out.println(m+1); return m+1;}
		else if(m%4==3) {System.out.println(0); return 0;}
		return -1;
		
		
	}





	private static void swap(int x, int y) {
		
		x=x^y;
		y=x^y;
		x=x^y;
		
		System.out.println("x : "+x+ " ,"+" y : "+y);
	}



	//O(n)
	private static void findOneTimeOccuringNumber(int[] a) {
	
		// xor of same numbers is 0.
		// xor of 0 with some number is same number.
		int xor=0;
		for(int k:a) {
			xor=xor^k;
		}
		
		System.out.println(xor);
	}
}
