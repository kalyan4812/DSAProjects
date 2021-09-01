package Qeues;

public class Q3 {

	public static void main(String...strings) {
		int a=13567;
		
		fun(a);
		
		
	}

	private static void fun(int a) {
		
		String s=a+"";
		char c[]=s.toCharArray();
		
		
		
		for(int i=1;i<c.length;i++) {
			int r=c[i]-'0';
			if(r<c[i-1]-'0') {
				System.out.println(c[i]-'0');
				return;
			}
		}
		System.out.println("True");
	}
}
