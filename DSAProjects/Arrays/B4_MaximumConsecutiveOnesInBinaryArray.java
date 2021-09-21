package Arrays;

public class B4_MaximumConsecutiveOnesInBinaryArray {

	public static void main(String... strings) {
		int a[] = { 0, 1, 1, 0, 1, 0 };
		int ans = fun(a, a.length);
		System.out.println(ans);
		
		int ans2=fun2(a,a.length);
		System.out.println(ans2);
	}

	//O(N)
	private static int fun2(int[] a, int n) {
		int count=0;
		int max=0;
		for(int i=0;i<n;i++) {
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
	private static int fun(int[] a, int n) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 1) {
				count++;
				for (int j = i + 1; j < n; j++) {
					if (a[j] == 1) {
						count++;
					} else {
						count = 0;
						break;
					}
					max = Math.max(max, count);

				}
			}
		}
		return max;
	}
}
