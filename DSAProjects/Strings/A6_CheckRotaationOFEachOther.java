package Strings;

public class A6_CheckRotaationOFEachOther {

	public static void main(String...strings) {
		String s1="ABCD";
		String s2="CDAB";
		boolean b=fun(s1,s1.length(),s2,s2.length());
		System.out.print(b);
		
	}

	private static boolean fun(String s1, int m, String s2, int n) {
		if(m!=n) {
			return false;
		}
		
		
		//return fun2(s1+s2,2*m,s2,m); or 
		s1=s1+s1;
		return s1.indexOf(s2)>=0;
	}
	//O(N)-window method.
		private static boolean fun2(String text, int m, String pat, int n) {
		
			int counttext[]=new int[256];
			int countpat[]=new int[256];
			for(int i=0;i<n;i++) {
				counttext[text.charAt(i)]++;
				countpat[pat.charAt(i)]++;
			}
			for(int i=n;i<m;i++) {
				if(areSame(counttext,countpat)) {
					return true;
				}
				counttext[text.charAt(i)]++;
				counttext[text.charAt(i-n)]--;
				
			}
			
			return false;
			
		}

		private static boolean areSame(int[] counttext, int[] countpat) {
			for(int i=0;i<256;i++) {
				if(counttext[i]!=countpat[i]) {
					return false;
				}
			}
			return true;
		}
}
