package Arrays;


public class C2_SubArrayWithGivenSumInNonNegativeArray {

	
	public static void main(String...strings) {
		int a[]= {1,4,20,3,10,5};
		int sum=33;
		checkSum(a,sum);
		checkSumByWindowMethod(a,sum);
		fun2(a,a.length,sum);
	}

	//O(n) valid for +ve numbers/>0 ,so s=0 is not valid.(same as below method window technique)
		private static void fun2(int[] a, int n, int s) {
			
			int sum=0;
			int i=0,j=0;
			while(j<n) {
				sum=sum+a[j];
				
				if(sum==s) {
					System.out.println(i+" to "+j);
				}
				while(sum>s && i<=j) {
					sum=sum-a[i];
					i++;
					if(sum==s) {
						System.out.println(i+" to "+j);
					}
					
				}
				j++;
				
			}
			
		}

	//O(n) this method only for +ve elements ?doubt about time complexity.
	private static void checkSumByWindowMethod(int[] a, int s) {
		int sum=0,j=0;
		for(int i=0;i<a.length;i++) {
			if(sum>s) {
				for(int k=j;k>=0;k--) {
					sum=sum-a[i-j];
					if(sum==s) {
						System.out.println("true...");
						break;
					}
				}
			}
			else if(sum==s) {
				System.out.println("true...");
				break;
			}
			else if(sum<s) {
				sum=sum+a[i];
				j++;
			}
		}
		System.out.println(sum==s);
	}

	//O(n2)
	private static void checkSum(int[] a, int s) {
		for(int i=0;i<a.length;i++) {
			int sum=0;
			for(int j=i;j<a.length;j++) {
				sum=sum+a[j];
				if(sum==s) {
					System.out.println("From "+i+" to "+j);
					return;
				}
			}
			
		}
		
	}
}
