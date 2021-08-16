package Arrays;


public class MaxCircularSubArraySum {

	
	public static void main(String...strings) {
		int a[]= {-10,-5,-5};
		System.out.println(getSum(a));
		System.out.println(getSumOtherWay(a));
		
	}

	
	//t(n)
	
	// here count1=maxsubarray,count2=minsubarray
	//maxcircular sum=totalsum-minsubarray
	//ans=max of count1,maxcircular
	//corner case is when all elements are -ve ,then return count1
	private static int getSumOtherWay(int[] a) {
		int maxEnd=a[0],minEnd=a[0],count1=a[0],count2=a[0],arraysum=a[0];
		for(int i=1;i<a.length;i++) {
			maxEnd=Math.max(a[i],maxEnd+a[i]);
			count1=Math.max(count1,maxEnd);
			
			minEnd=Math.min(a[i], minEnd+a[i]);
			count2=Math.min(count2,minEnd);
			arraysum=arraysum+a[i];
		}
		
		return count1<0?count1:Math.max(count1,arraysum-count2);
	}


	//O(n2)
	private static int  getSum(int[] a) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++) {
			
			int count=a[i];
			int curmax=a[i];
			for(int j=i+1;j<a.length+i;j++) {
				count=count+a[(j)%(a.length)];
				curmax=Math.max(curmax, count);
			}	
			max=Math.max(max,curmax);
		
		}
		return max;
	}
}
