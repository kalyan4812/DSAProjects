package Arrays;


public class MaximumSumSubArray {

	public static void main(String...strings) {
		int [] a= {2,3,-8,7,-1,2,3};
		System.out.println(getSum(a));
		System.out.println(getSumOtherWay(a));
		getSumWithIndexs(a);
		
	}
	
	
	private static void getSumWithIndexs(int[] a) {
		int maxsum=a[0],curr_max=a[0];
		int start=0,end=0,curr_start=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]>curr_max+a[i]) {
				curr_start=i;
				curr_max=a[i];
			}
			else {
				curr_max=curr_max+a[i];
			}
			if(curr_max>maxsum) {
				maxsum=curr_max;
				end=i;
				start=curr_start;
				
			}
		}
		System.out.print("MaxSum "+maxsum +" start From "+start+" to "+end);
	}


	//t(n)
	//kadanes alogirithm

	private static int getSumOtherWay(int[] a) {
		int maxEnd=a[0];
		int maxsum=a[0];
		
		for(int i=1;i<a.length;i++) {
		
			
			
			maxEnd=Math.max(a[i], maxEnd+a[i]);
			maxsum=Math.max(maxsum, maxEnd);
		}
		return maxsum;
	}

	//t(n2)
	private static int getSum(int[] a) {
		
		int maxsum=0;
		for(int i=0;i<a.length;i++) {
			int count=a[i];
			
			for(int j=i+1;j<a.length;j++) {
				count=count+a[j];
				maxsum=Math.max(maxsum, count);
			}
			
		}
		return maxsum;
	}
	
	
}
