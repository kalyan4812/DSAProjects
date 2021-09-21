package Arrays;


public class F8_DutchNationalFlagAlgorithm {

	public static void main(String...strings) {
		int [] a= {2,0,2,1,1,0};
	
		sort(a);
	}

	private static void sort(int[] a) {
		int low=0,mid=0;
		int high=a.length-1;
		while(mid<=high) {
			switch(a[mid]) {
			case 0:
				if(a[low]!=a[mid]) {
				int temp=a[low];
				a[low]=a[mid];
				a[mid]=temp;
				}
				low++;
				mid++;
				break;
				
			case 1:
				mid++;
				break;
				
			case 2:
				if(a[mid]!=a[high]) {
				int temps=a[mid];
				a[mid]=a[high];
				a[high]=temps;
				}
				high--;
				break;
			}
		}
		for(int i:a) {
			System.out.print(i+" ");
		}
		
	}
}
