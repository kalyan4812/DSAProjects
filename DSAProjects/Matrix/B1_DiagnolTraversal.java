package Matrix;

import java.util.Scanner;

public class B1_DiagnolTraversal {

	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int m1 = n1;

		int a[][] = new int[n1][m1];

		for (int i = 0; i < n1; i++) {

			for (int j = 0; j < m1; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for(int g=0;g<n1;g++){
		    
		    for(int i=0,j=g;j<n1;i++,j++){
		        System.out.println(a[i][j]);
		    }
		}
    }
}
