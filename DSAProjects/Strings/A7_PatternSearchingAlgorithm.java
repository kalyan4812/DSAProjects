package Strings;

public class A7_PatternSearchingAlgorithm {

	public static void main(String... strings) {
		String s1 = "ABABAB";
		String s2 = "ABAB";
		fun1(s1, s1.length(), s2, s2.length());
		System.out.println();

		fun2(s1, s1.length(), s2, s2.length());
		System.out.println();

		// if characters in s2 are distnict.
		String s3="AB";
		fun3(s1, s1.length(), s3, s3.length());
		System.out.println();

		
		rabinKarp(s1, s1.length(), s2, s2.length());
		System.out.println();
		
		kmp(s1, s1.length(), s2, s2.length());
		System.out.println();

	}

	
	
	//t(n)
	private static void kmp(String s1, int m, String s2, int n) {
		int lps[]=new int[m];
		fillLps(s1,lps);
		int i=0,j=0;
		while(i<m) {
			if(s2.charAt(j)==s1.charAt(i)) {
				i++;
				j++;
			}
			if(j==n) {
				System.out.print(i-n+" ");
				j=lps[j-1];
				
			}
			else if(i<m && s1.charAt(i)!=s2.charAt(j)) {
				if(j==0) {
					i++;
				}
				else {
					j=lps[j-1];
				}
			}
			
		}
		
	}


	//O(N)-n=length of string.
	private static void fillLps(String s1, int[] lps) {
		int n=s1.length();
		int len=0;
		lps[0]=0;
		int i=1;
		while(i<n) {
			if(s1.charAt(i)==s1.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}
			else {
				if(len==0) {
					lps[i]=0;
					i++;
				}
				else {
					len=lps[len-1];
				}
			}
		}
	}


	//O(m-n+1*m)+O(K)-worst case but better than naive in avg case.
	private static void rabinKarp(String s1, int m, String s2, int n) {
		
		int q=7,d=5;
		
		int h=1;
		for(int i=1;i<n;i++) {
			h=(h*d)%q;
		}
		
		int p=0,t=0;
		for(int i=0;i<n;i++) {
			p=(p*d+s2.charAt(i))%q;
			t=(t*d+s1.charAt(i))%q;
		}
		
		for(int i=0;i<m-n+1;i++) {
			if(p==t) {
				boolean flag=true;
				for(int j=0;j<n;j++) {
					if(s1.charAt(i+j)!=s2.charAt(j)) {
						flag=false;
						break;
					}
				}
				if(flag==true) {
					System.out.print(i+" ");
				}
				
				
			}
			if(i<m-n) {
				t=((d*(t-s1.charAt(i)*h))+s1.charAt(i+n))%q;
				if(t<0) {
					t=t+q;
				}
			}
		}
		
	}

	// O(m).
	private static void fun3(String s1, int m, String s2, int n) {
		for (int i = 0; i < m - n + 1;) {
			int j;
			for (j = 0; j < n; j++) {
				if (s1.charAt(i + j) != s2.charAt(j)) {
					break;
				}

			}
			if (j == n) {
				System.out.print(i + " ");
			}
			if (j == 0) {
				i++;
			} else {
				i = i + j;
			}
		}
	}

	// O(m-n+1*m)
	private static void fun2(String s1, int m, String s2, int n) {

		for (int i = 0; i < m - n + 1; i++) {
			int j;
			for (j = 0; j < n; j++) {
				if (s1.charAt(i + j) != s2.charAt(j)) {
					break;
				}

			}
			if (j == n) {
				System.out.print(i + " ");
			}
		}
	}

	private static void fun1(String s1, int m, String s2, int n) {
		StringBuilder s3 = new StringBuilder(s1);
		for (int i = 0; i < m - n; i++) {
			int k = s3.indexOf(s2);
			if (k >= 0) {
				System.out.print(k + " ");
				s3.replace(k, k + 1, "1");

			}
		}
	}
}
