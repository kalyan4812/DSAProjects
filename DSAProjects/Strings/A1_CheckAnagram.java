package Strings;

public class A1_CheckAnagram {

	public static void main(String...strings) {
		String s1="geeks";
		String s2="ekegs";
		boolean b=check(s1,s2);
		System.out.print(b);
	}
	
	// note 'p'-'a'='P'-'A'
	// -->   'p'='P'+'a'-'A'
	// ---> lowercase=uppercase+'a'-'A';
	
	

	//O(N),t(256)-space
	private static  boolean check(String s1, String s2) {
	
		if(s1.length()!=s2.length()){
			return false;
		}
		int count[]=new int[256];
		
		char c[]=s1.toCharArray();
		for(char ch:c) {
			count[ch]++;
		}
		char cd[]=s2.toCharArray();
		for(char ch:cd) {
			count[ch]--;
		}
		
		for(int i:count) {
			if(i!=0) {
				return false;
			}
		}
		return true;
		
	}
}
