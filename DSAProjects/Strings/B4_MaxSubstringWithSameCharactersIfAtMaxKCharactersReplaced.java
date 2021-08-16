package Strings;

import java.util.HashMap;
import java.util.Map;

public class B4_MaxSubstringWithSameCharactersIfAtMaxKCharactersReplaced {

	
	public static void main(String...strings) {
		String s="bccbababd";
		int k=2;
		fun(s,s.length(),k);
	}

	//O(N),O(256)-space.
	private static void fun(String str, int n, int k) {
	
		Map<Character,Integer> m=new HashMap<>();
		
		int s=0,e=0,maxfreq=0;
		int maxlen=Integer.MIN_VALUE;
		

		
		while(e<n) {
			char c=str.charAt(e);
			m.put(c, m.getOrDefault(c, 0)+1);
			maxfreq=Math.max(maxfreq, m.get(c));
			
			if((e-s+1)-maxfreq>k) {
				char frontchar=str.charAt(s);
				m.put(frontchar, m.get(frontchar)-1);
				s++;
				
			}
			maxlen=Math.max(maxlen, e-s+1);
			e++;
		}
		System.out.println(maxlen);
	}
}
