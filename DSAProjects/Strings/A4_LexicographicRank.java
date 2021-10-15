package Strings;

public class A4_LexicographicRank {

	public static void main(String... strings) {
		String s = "BAC";
		fun(s, s.length());

		fun2(s, s.length());

		String p = "BAC";
		int rank = 5;
		// printSubStringUsingRank(p,p.length(),rank);
		
		System.out.println(nextGreaterElement("132"));
	}

	private static void fun2(String s, int n) {

		int a[] = new int[n];

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			a[i] = (int) s.charAt(i);
			min = Math.min(min, a[i]);
		}

		for (int i = 0; i < n; i++) {
			a[i] = a[i] - min + 1;

		}

		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			int c = 0;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[i]) {
					c++;
				}
			}
			count[i] = c;

		}
		
		for(int i=n-2;i>=0;i--) {
			if(a[i]<a[i+1]) {
				count[i]=count[i+1]+1;
			}
		}

		int ans = 0;
		int f = fact(n - 1);
		for (int i = 0; i < n; i++) {
			ans += (count[i]) * f;
			n--;
			f = f / n;

		}

		System.out.println(ans + 1);

	}

	private static void printSubStringUsingRank(String p, int n, int rank) {
		int curr_rank = fun(p, n);

	}

	// O(N)
	private static int fun(String s, int n) {

		int mul = fact(n);
		int rank = 1;

		int count[] = new int[256];
		for (int i = 0; i < n; i++) {
			count[s.charAt(i)]++;
		}
		for (int i = 1; i < 256; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = 0; i < n; i++) {
			mul = mul / (n - i);
			rank = rank + count[s.charAt(i) - 1] * mul;
			for (int j = s.charAt(i); j < 256; j++) {
				count[j]--;
			}
		}
		System.out.println(rank);
		return rank;

	}

	private static int fact(int n) {

		if (n == 0) {
			return 1;
		}
		return n * fact(n - 1);
	}

	public void nextPermutation(int[] a) {

		int n = a.length;
		int ind1 = -1, ind2 = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (a[i] < a[i + 1]) {
				ind1 = i;
				break;
			}
		}
		if (ind1 >= 0) {
			for (int i = n - 1; i >= 0; i--) {
				if (a[i] > a[ind1]) {
					ind2 = i;
					break;
				}
			}

			int temp = a[ind1];
			a[ind1] = a[ind2];
			a[ind2] = temp;
		}

		int len = n - 1 - (ind1 + 1) + 1;
		for (int p = 0; p < len / 2; p++) {
			int temps = a[n - 1 - p];
			a[n - 1 - p] = a[ind1 + 1 + p];
			a[ind1 + p + 1] = temps;
		}

	}
	
	
	 public static String nextGreaterElement(String str) {
	       
	       
	       
	       int m=str.length();
	       
	       int a[]=new int[m];
	       
	       for(int i=0;i<m;i++){
	           a[i]=Integer.parseInt(str.charAt(i)+"");
	           System.out.println(a[i]);
	       }
	       
	       int n=a.length;
	       int ind1=-1,ind2=-1;
	       
	       
	       for(int i=m-2;i>=0;i--){
	           if(a[i]<a[i+1]){
	               ind1=i;
	               break;
	           }
	       }
	       if(ind1==-1){
	           return "-1";
	       }
	       
	       if(ind1>=0){
	           
	           for(int i=n-1;i>=0;i--){
	               if(a[i]>a[ind1]){
	                   ind2=i;
	                   break;
	               }
	           }
	           
	           int temp=a[ind1];
	           a[ind1]=a[ind2];
	           a[ind2]=temp;
	           
	           
	       }
	       
	       
	       
	       
	       int i=ind1+1,j=n-1;
	       
	       while(i<=j){
	           int temp=a[i];
	           a[i]=a[j];
	           a[j]=temp;
	           i++;
	           j--;
	       }
	       
	       String res="";
	       for(int y:a){
	           res+=y;
	       }
	       
	       return res;
	       
	       
	    }
}
