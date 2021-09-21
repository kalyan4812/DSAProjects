package Arrays;


public class A6_MoveAllZeroesToEnd {

	
	public static void main(String...strings) {
		int a[]= {0,0,0,-3,0,99,7,0};
        moveZeroesToEnd(a);
        for(int i:a) {
        	System.out.print(i+" ");
        }
        System.out.println();
        moveZeroesInOneTraversal(a);
        for(int i:a) {
        	System.out.print(i+" ");
        }
        
        System.out.println();
        moveZeroesUsingNaiveMethod(a);
        for(int i:a) {
        	System.out.print(i+" ");
        }
        
	}
	
	// O(n2) soultion
	
	private static void moveZeroesUsingNaiveMethod(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				for(int j=i+1;j<a.length;j++) {
					if(a[j]!=0) {
						swap(a[i],a[j]);
						break;
					}
				}
			}
		}
		
	}


	//in one traversal time complexity -> O(n)

	private static void moveZeroesInOneTraversal(int[] a) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0) {
				swap(a[i],a[count]);
				count++;
			}
		}
		
	}

	private static void swap(int i, int j) {
		int temp=i;
		i=j;
		j=temp;
		
	}

	//in two traversals timecomplexity-> o(n)+o(num of zeroes*n)
	private static void moveZeroesToEnd(int[] a) {
		int numofzeroes=getNumOfZeroes(a);
		
		for(int i=0;i<numofzeroes;i++) {
			for(int j=0;j<a.length;j++) {
				if(j!=a.length-1 && a[j]==0) {
					a[j]=a[j+1];
					a[j+1]=0;
				}
			}
		}
		
		
	}

	private static int getNumOfZeroes(int[] a) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				count++;
			}
		}
		return count;
	}
}
