package Sorting;

public class B7_SegregreateTwoTypesOfElements {

	
	public static void main(String...strings) {
		int a[]= {2,3,5,-12,10,-10,5,-3,9};
		funUsingHoarsePartition(a,a.length);
		
		int b[]= {2,3,5,-12,10,-10,5,-3,9};
		sortArrayByParity(b); // to maintain order of negative elements.
	}

	private static void funUsingHoarsePartition(int[] a, int n) {
		int i=-1,j=n;
		while(true) {
			do {
				i++;
			}
			while(a[i]<0);
			do {
				j--;
			}
			while(a[j]>=0);
			if(i>=j) {
				break;
			}
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		
		for(int k:a) {
			System.out.print(k+" ");
		}
		System.out.println();
	}
	
	public static void sortArrayByParity(int[] a) {
        int n=a.length;
       
         int i=0,j=0;
         
         while(i<n){
             int x=a[i];
             
             if(x<0){
                 int temp=a[i];
                 a[i]=a[j];
                 a[j]=temp;
                 i++;
                 j++;
             }
             else{
                 i++;
             }
         }
         
         for(int k:a) {
 			System.out.print(k+" ");
 		}
         
    }
}
