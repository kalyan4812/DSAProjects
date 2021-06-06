package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A8_LongestSubstringWithDistinctCharacters {

	public static void main(String...strings) {
		String s="abcdabc";
		fun1(s,s.length());
		
		fun2(s,s.length());
		
		fun3(s,s.length());
		
		fun4(s,s.length());
		
		
		fun5(s,s.length());
	}

	
	
	//O(N),O(N)-space
	private static void fun5(String s, int n) {
		Map<Character,Integer> h=new HashMap<>();
		int maxlen=0,st=0,e=0;
		
		while(e<n) {
			char c=s.charAt(e);
			
			
			if(h.containsKey(c)) {
				st=Math.max(st, h.get(c)+1);
			}
			h.put(c,e);
			
			maxlen=Math.max(maxlen, e-st+1);
			e++;
		}
		
		System.out.println(maxlen);
		
	}



	//O(N),O(N)-space
	private static void fun4(String s, int n) {
		
		Map<Integer,Integer> map=new HashMap<>();
		int res=0,i=0;
		
		for(int j=0;j<n;j++) {
			int c=(int)s.charAt(j);
			
			i=Math.max(i, map.getOrDefault(c,-1)+1);
			int maxEnd=j-i+1;
			res=Math.max(maxEnd, res);
			map.put(c, j);
		}
		System.out.println(res);
	}




	//O(N)
	private static void fun3(String s, int n) {
		int res=0,i=0;
		int prev[]=new int[256];
		Arrays.fill(prev,-1);
		
		for(int j=0;j<n;j++) {
			i=Math.max(i, prev[s.charAt(j)]+1);
			int maxEnd=j-i+1;
			res=Math.max(maxEnd, res);
			prev[s.charAt(j)]=j;
		}
		System.out.println(res);
	}



	//O(n2)
	private static void fun2(String s, int n) {
		int res=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			boolean visited[]=new boolean[256];
			for(int j=i;j<n;j++) {
				if(visited[s.charAt(j)]) {
					break;
				}
				else {
					res=Math.max(res, j-i+1);
					visited[s.charAt(j)]=true;
				}
			}
		}
		System.out.println(res);
		
	}


	//O(n3)
	private static void fun1(String s, int n) {
		int res=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(areDistinct(s,i,j)) {
					res=Math.max(res, j-i+1);
				}
			}
		}
		System.out.println(res);
	}

	//O(N)-check string is of distinct characters or not.
	private static boolean areDistinct(String s, int i, int j) {
		boolean visited[]=new boolean[256];
		for(int k=i;k<=j;k++) {
			if(visited[s.charAt(k)]) {
				return false;
			}
			visited[s.charAt(k)]=true;
		}
		return true;
	}
}
