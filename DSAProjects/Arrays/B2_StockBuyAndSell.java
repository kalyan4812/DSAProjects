package Arrays;


public class B2_StockBuyAndSell {

	
	public static void main(String...strings) {
		int a[]= {1,5,3,8,12};
		
		int k=getMaxProfit(a,0,a.length);
		System.out.println(k);
		System.out.print(getMaxProfitOtherWay(a));
		
		
		
	}

	//t(n)
	private static int getMaxProfitOtherWay(int[] a) {
		int profit=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]>a[i-1]) {
				profit=profit+a[i]-a[i-1];
			}
		}
		return profit;
	}

	// recursive O(n2)
	private static int getMaxProfit(int[] a,int start,int end) {
		if(end<=start) {
			return 0;
		}
		int maxprof=0;
		for(int i=start;i<end;i++) {
			for(int j=i+1;j<end;j++) {
				if(a[j]>a[i]) {
					int currprof=a[j]-a[i]+getMaxProfit(a,start,i-1)+getMaxProfit(a,j+1,end);
					maxprof=Math.max(maxprof, currprof);
				}
			}
		}
		return maxprof;
	}
	
	
}
