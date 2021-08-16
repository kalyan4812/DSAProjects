package Matrix;

public class A6_SearchInRowWiseColumnWiseSortedMatrix {

	public static void main(String...strings) {
		int a[][]= {{10,20},{12,36}};
		int x=364;
		
		serach(a,a.length,a[0].length,x);
	}

	//O(n+m)
	private static void serach(int[][] a, int n, int m, int x) {
		int i=0,j=m-1;
		while(i<n && j>=0) {
			if(a[i][j]==x) {
				System.out.print(x+ " found at "+"("+i+","+j+")");
				return;
			}
			else if(a[i][j]>x) {
				j--;
			}
			else {
				i++;
			}
		}
		
		System.out.print(x +" is not found in matrix");
	}
}
