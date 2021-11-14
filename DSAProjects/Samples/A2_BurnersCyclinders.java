package Samples;

import java.util.Arrays;
import java.util.Collections;

public class A2_BurnersCyclinders {

	
	public static void main(String...strings) {
		int n=5;
		int k=3;
		Integer x[]= { 10,10,6,9,3};
		
		long ans=fun(n,k,x);
		System.out.println(ans);
	}

	private static long fun(int n, int k, Integer [] x) {
	    
		Arrays.sort(x, Collections.reverseOrder());
		long s=0,a=0,c=1;
		
		for(int i=k;i<n;i++) {
			s+=x[i];
		}
		for(int i=k-1;i>0;i--){
			if(s>=c*(x[i-1]-x[i])){
				s-=c*(x[i-1]-x[i]);
				c++;
				a=x[i-1];
			}else{
				a+=s/c;
				s=0;
				break;
			}
		}
		if(s>0) {
			a+=s/c;
		}
		
		return a;
	}
}
