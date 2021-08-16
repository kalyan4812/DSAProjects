package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class A9_WordBreak {

	public static void main(String... strings) {

		String str = "heaven";
		
		ArrayList<String> al = new ArrayList<>(Arrays.asList("h", "a", "ab", "ven"));

		boolean b = wordBreak(0, 0, str, str.length(), al);
		System.out.print(b);
	}

	private static boolean wordBreak(int i, int j, String s, int n, ArrayList<String> al) {
		if (j == n) {
			if (i == n)
				return true;
			return false;
		}
		if(!al.contains(s.substring(i, j+1))) {
			return wordBreak(i,j+1,s,n,al);
		}
		else {
			if(wordBreak(i,j+1,s,n,al)) return true;
			
			return wordBreak(j+1,j+1,s,n,al);
		}
		
	}
}
