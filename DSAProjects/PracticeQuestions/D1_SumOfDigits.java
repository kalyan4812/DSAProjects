package PracticeQuestions;

public class D1_SumOfDigits {

	public static void main(String...strings) {
		int num=3782; // from 1 to 3782.
		int ans=fun(num);
		System.out.println(ans);
		
		// answer for sum of digits between a and  b is fun(b)-fun(a-1);
	}

	private static int fun(int num) {
		if(num/10==0) {
			return num*(num+1)/2;
		}
		String s=num+"";
		int d=s.length();// number of digits.
		
		int f=num/(int)Math.pow(10, d-1); // extract first digit.
		
		int res=0;
		int x=(int)Math.pow(10, d-2)*45*(d-1);
		for(int i=0;i<f;i++) {
			res=res+(i*(int)Math.pow(10, d-1))+x;
		}
		
		int rest=num%(int)Math.pow(10, d-1);
		res=res+f*(rest+1);
		res=res+fun(rest);
		return res;
	}
}
