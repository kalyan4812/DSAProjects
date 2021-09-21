package Arrays;


public class B3_TrappingRainWater {

	
	public static void main(String...strings) {
		int[] a= {3,0,1,2,5};
		System.out.println(getAmountOfTrappedWater(a));
		System.out.println(getAmountOfTrappedWaterSecondWay(a));
	}

	
	//t(n) ,auxilary space=t(n+n)
	private static int getAmountOfTrappedWaterSecondWay(int[] a) {
		
		int[] lmax=new int[a.length];
		lmax[0]=a[0];
		
		int[] rmax=new int[a.length];
		rmax[a.length-1]=a[a.length-1];
		
		for(int i=1;i<a.length;i++) {
			lmax[i]=Math.max(a[i],lmax[i-1]);
		}
		
		for(int j=a.length-2;j>=0;j--) {
			rmax[j]=Math.max(a[j],rmax[j+1]);
		}
		int amount=0;
		
		for(int i=1;i<a.length-1;i++) {
			amount=amount+(Math.min(lmax[i], rmax[i])-a[i]);
		}
		return amount;
	}


	//t(n2)
	private static int getAmountOfTrappedWater(int[] a) {
		int amount=0;
		for(int i=1;i<a.length-1;i++) {
			int lmax=a[i];
			int rmax=a[i];
			
			for(int j=0;j<i;j++) {
				if(a[j]>lmax) {
					lmax=a[j];
				}
			}
			for(int k=i+1;k<a.length;k++) {
				if(a[k]>rmax) {
					rmax=a[k];
				}
			}
			amount=amount+Math.min(lmax, rmax)-a[i];
			
		}
		return amount;
	}
}
