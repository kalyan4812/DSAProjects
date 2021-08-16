package Strings;

import java.util.HashMap;
import java.util.Map;

public class B1_FindLongestSubstringWithKDistnictCharacters {

	public static void main(String...strings) {
		String s="bccbababd";
		int k=2;
		fun(s,s.length(),k);
	}

	
	//O(N),O(N)-space.
	private static void fun(String s, int n, int k) {
		Map<Character,Integer> h=new HashMap<>();
		int maxlen=0,st=0,e=0;
		
		while(e<n) {
			char c=s.charAt(e);
			h.put(c, h.getOrDefault(c, 0)+1);
			
			while(h.size()>k) {
				char front=s.charAt(st);
				h.put(front, h.getOrDefault(front, 0)-1);
				
				if(h.get(front)==0) {
					h.remove(front);
				}
				st++;
			}
			
			maxlen=Math.max(maxlen, e-st+1);
			e++;
		}
		
		System.out.println(maxlen);
		
	}
}
