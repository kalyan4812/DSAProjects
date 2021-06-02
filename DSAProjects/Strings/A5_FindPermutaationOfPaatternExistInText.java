package Strings;

public class A5_FindPermutaationOfPaatternExistInText {

	public static void main(String...strings) {
		String text="geeks for geeks";
		String pat="egek";
		boolean b=fun(text,text.length(),pat,pat.length());
		System.out.println(b);
	}

	//O(N)-window method.
	private static boolean fun(String text, int m, String pat, int n) {
	
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
