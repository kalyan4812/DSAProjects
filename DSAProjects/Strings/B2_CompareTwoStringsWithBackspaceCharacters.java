package Strings;

public class B2_CompareTwoStringsWithBackspaceCharacters {

	
	
	public static void main(String...strings) {
		String s1="bcd##e"; // # character delete a letter previous of it ,like it works like a backspace button.
		String s2="bd#e";
		
		boolean b=fun(s1,s1.length(),s2,s2.length());
		System.out.println(b);
	}

	
	//O(N+M)
	private static boolean fun(String s1, int m, String s2, int n) {
		int e1=m-1;
		int e2=n-1;
		while(e1>=0 && e2>=0) {
			int str1Ind=getChar(s1,e1);
			int str2Ind=getChar(s2,e2);
			
			//if both strings reached to end.
			if(str1Ind<0 && str2Ind<0) {
				return true;
			}
			
			if(str1Ind<0 || str2Ind<0) {
				return false;
			}
			
			if(s1.charAt(str1Ind)!=s2.charAt(str2Ind)) {
				return false;
			}
			
			e1=str1Ind-1;
			e2=str2Ind-1;
			
			
		}
		return true;
	}

	private static int getChar(String s, int e) {
		int specialchar=0;
		
		while(e>=0) {
			if(s.charAt(e)!='#') {
				if(specialchar==0) {
					return e;
				}
				else {
					specialchar--;
				}
			}
			else {
				specialchar++;
			}
			e--;
		}
		return e;
	}
}
