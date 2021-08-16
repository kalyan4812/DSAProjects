package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class FindDuplicateAndMissingValue {
	public static void main(String...strings) {
		int [] a= {4,3,4,5,1};
		fun(a,a.length,1);
		
		int [] b= {2,6,4,4,3,2};
		fun(b,b.length,1);
		
		int [] c= {2,6,4,4,3,2,2};
		fun2(c,c.length,1);
		
		System.out.println();
		int [] d= {4,3,4,5,1};
		fun3(d,d.length);
	}

	//O(N)
	private static void fun3(int[] a, int n) {
		int p=0,b=0;
		for(int i=0;i<n;i++) {
			if(a[Math.abs(a[i])-1]<0) {
				p=Math.abs(a[i]);
			}else {
			a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
			}
		}
		for(int i=0;i<n;i++) {
			if(a[i]>0) {
				b=i+1;
				break;
			}
		}
		System.out.println("Missing Value :"+b+" "+"Duplicate Value : "+p);	
		
	}

	//O(N),O(N)-space
	private static void fun2(int[] a, int n,int min) {
		HashSet<Integer> duplicates=new HashSet<>();
		ArrayList<Integer> missing=new ArrayList<>();
		int i=0;
		while(i<n) {
			    
			if(a[i]!=i+min) {
				int index=a[i]-min;
				if(a[i]!=a[index]) {
				int temp=a[i];
				a[i]=a[index];
				a[index]=temp;
				}
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
			for(int k=0;k<n;k++) {
				if(a[k]!=k+1) {
					duplicates.add(a[k]);
					missing.add(k+1);
				}
			
		}
		System.out.print("Missing Values :"+missing.toString());
		System.out.println();
		System.out.print("Duplicate Values :"+duplicates.toString());
		
	}

	//O(N)
	private static void fun(int[] a, int n,int min) {
		
		
		
		int i=0;
		while(i<n) {
			    
			if(a[i]!=i+min) {
				int index=a[i]-min;
				if(a[i]!=a[index]) {
				int temp=a[i];
				a[i]=a[index];
				a[index]=temp;
				}
				else {
					i++;
				}
			}
			else {
				i++;
			}
		}
		for(int g:a) {
			System.out.print(g+" ");
			
		}
		System.out.println();
		for(int k=0;k<n;k++) {
			if(a[k]!=k+1) {
				System.out.println("Missing Value :"+(k+1)+" "+"Duplicate Value : "+a[k]);	
			}
		}
	}

}
