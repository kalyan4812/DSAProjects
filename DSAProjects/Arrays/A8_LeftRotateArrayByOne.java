package Arrays;

public class A8_LeftRotateArrayByOne {

	public static void main(String... strings) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// output should be : 2,3,4,5,6,7,1

		rotateByOne(a);

		for (int i : a) {
			System.out.print(i + "  ");
		}
		System.out.println();

		int b[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArrayBySomeX(b, 3);
		// output : 4,5,6,7,1,2,3
		// one approach can be use rotataebyOne x times.

		for (int i : b) {
			System.out.print(i + "  ");
		}
		System.out.println();
		int c[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArrayBySomeXWithoutUsingSpace(c, 3);
		// output : 4,5,6,7,1,2,3
		// one approach can be use rotataebyOne x times.

		for (int i : c) {
			System.out.print(i + "  ");
		}
		System.out.println();
		int d[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArrayBySomeXWithoutUsingSpaceOtherWay(d, 3);
		// output : 4,5,6,7,1,2,3
		// one approach can be use rotataebyOne x times.

		for (int i : d) {
			System.out.print(i + "  ");
		}

	}

	// general code to rotate ,if K<0 leftwards,k>0 rightwards
	public static void rotate(int[] a, int k) {
		int n = a.length;
		k = k % n;
		if (k < 0) {
			k = k + n;
		}
		rotateArrayBySomeXWithoutUsingSpace(a, k);

	}

	private static void rotateArrayBySomeXWithoutUsingSpaceOtherWay(int[] p, int d) {
		reverseArrayFromXtoYotherway(p, 0, d - 1);
		reverseArrayFromXtoYotherway(p, d, p.length - 1);
		reverseArrayFromXtoYotherway(p, 0, p.length - 1);

	}

	private static void reverseArrayFromXtoYotherway(int[] a, int i, int j) {
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}

	}

	// time complexity t(d/2+n-d/2+n/2)=t(n)
	private static void rotateArrayBySomeXWithoutUsingSpace(int[] c, int d) {
		reverseArrayFromXtoY(c, 0, d);
		reverseArrayFromXtoY(c, d, c.length - d);
		reverseArrayFromXtoY(c, 0, c.length);

	}

	private static void reverseArrayFromXtoY(int[] a, int i, int j) {
		int p = i;
		int size = j;
		for (int x = 0; x < (size / 2); x++) {
			int temp = a[i];
			a[i] = a[j + p - 1];
			a[j + p - 1] = temp;
			j--;
			i++;

		}

	}

	// time complexity t(d)+t(n-d)+t(d)=t(n) & auxilary space=t(d)
	private static void rotateArrayBySomeX(int[] a, int d) {
		int temp[] = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i];
		}

		for (int i = d; i < a.length; i++) {
			a[i - d] = a[i];
		}

		for (int i = 0; i < d; i++) {
			a[a.length - d + i] = temp[i];
		}

	}

	// time complexity t(n)
	private static void rotateByOne(int[] a) {
		int temp = a[0];
		for (int i = 1; i < a.length; i++) {
			a[i - 1] = a[i];
		}
		a[a.length - 1] = temp;

	}
}
