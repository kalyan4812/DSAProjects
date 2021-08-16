package Arrays;


public class ConsecutiveOnesInBinaryArray {

	public static void main(String...strings) {
		int[] a= {1,0,1,1,1,1,0,1,1};
		System.out.println(getOnesCount(a));
		System.out.println(getOnesCountOtherWay(a));
	}

	
	//t(n)
	private static int getOnesCountOtherWay(int[] a) {
		int max=0;
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				max=Math.max(max, count);
				count=0;
			}
			else {
				count++;
			}
		}
		return max;
	}

	//O(n2)
	private static int getOnesCount(int[] a) {
		int max=0;
		for(int i=0;i<a.length;i++) {
			
			if(a[i]==1) {
				int count=1;
				for(int j=i+1;j<a.length;j++) {
					if(a[j]!=1) {
						break;
					}
					else {
						count++;
					}
				}
			
			max=Math.max(max, count);
			}
		}
		return max;
	}
	
	
	
}
