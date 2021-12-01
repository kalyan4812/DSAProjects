package Samples;

import java.util.Stack;

public class A5_ValidBSTFromPreOrder {

	public static void main(String... strings) {

		int a[]={44,22,11,33,66,55,77,88};
		
		boolean b=fun(a);
		System.out.println(b);
		
	}

	private static boolean fun(int[] a) {
	   int root=Integer.MIN_VALUE;
	   Stack<Integer> st=new Stack<>();
	   
	   
	   for(int i=0;i<a.length;i++) {
		   
		   
		   while (!st.empty() && a[i] > st.peek())
	        {
	            root = st.pop();
	           
	        }
	        if (a[i] < root)
	            return false;
	        
	        st.push(a[i]);
	   }
	   
		return true;
	}

}
