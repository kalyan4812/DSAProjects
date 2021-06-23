package Hashing;

public class A9_LongestCommonSubArrayWithSameSum {

	
	public static void main(String... strings) {
		int a[] = { 0,1,0,0,0,0};
		int b[]= {1,0,1,0,0,1};

		fun(a,b, a.length);
		System.out.println();

		fun2(a, b,a.length); // it is same as longest sub array with sum ,if we replace all 0 s with -1;

	}

	private static void fun2(int[] a,int [] b,int length) {
		// TODO Auto-generated method stub
		
	}

	
	//O(N2)
	private static void fun(int[] a,int [] b, int n) {
		int res=0;
		for(int i=0;i<n;i++) {
			int s1=0,s2=0;
			for(int j=i;j<n;j++) {
				s1=s1+a[j];
				s2=s2+b[j];
				if(s1==s2) {
					res=Math.max(res, j-i+1);
				}
			}
			
		}
		System.out.println(res);
		
	}
}
